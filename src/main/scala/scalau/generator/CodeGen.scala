package scalau.generator

object CodeGen { 
  
  val s00 = (setName: String) => "/*\n * DO NOT MODIFY THIS FILE. It is code-generated from config/UnitsDef_" + setName + ".txt\n */\n"
  val s01 = "package scalau.units\n\n"  // top of the file
  val s02 = "import scalau._\n\n"

	val s03 = (setName: String) => "object Units_" + setName + " {\n\n"
	
	val s11 = "\t// implicit conversions: Double to <Dimension>\n\n"
	  
	// implicit def doubleToLength(x: Double): Length = new Length(x)
  val s15 = (dim: String) => "\timplicit def doubleTo" + dim + "(x: Double) = new " + dim + "(x)\n"
	val s19 = "\n\n\n"
	
	// templates for classes defining a dimension
	//	class Time (x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {
	//	  type Impl = Time;  
	//	  def build(x:Double) = new Time(x) 
	//    val baseUnits = "_s"
	//	  val mainUnit = "_s"
	//	  val units = Map[String, Double]("_s"->1, "_sec"->1, "_min"->60, "_hours"->3600)
	//		def _s = new Time(x)
	//	 	def _sec = _s
	//	 	def _min = new Time(x * units("_min"))
	//	 	def _hours = new Time(x * units("_hours"))
	//	}
	val s21 = (dim: String) => 
	  "\tclass " + dim + "(x:Double) extends Quantity(x) with Addable with Multipliable with Comparable {\n" 
	val s22 = (dim: String) => "\t\ttype Impl = " + dim + "\n"  
	val s23 = (dim: String) => "\t\tdef build(x:Double) = new " + dim + "(x)\n" 
	val s24 = (baseUnits: String) => "\t\tval baseUnits = \"" + baseUnits + "\"\n"
	val s25 = (mainUnit: String) => "\t\tval mainUnit = \"" + mainUnit + "\"\n"
	val s26 = (mappings: String) => "\t\tval allUnits = Map[String, Double](" + mappings + ")\n" 
	val sMapping = (altUnit: String, altFactor: Double) => "\"" + altUnit + "\" -> " + altFactor.toString + ", "
	val s27 = (dim:String, altUnit: String, altFactor: Double) => 
	  "\t\tdef " + altUnit + " = new " + dim + "(x * " + altFactor + ")\n"
	val s29 = "\t}\n\n"
	  
	  
	// templates for Operations: generate the 4 implicits for equation  A=B*C
	val s41 = "\t// Implicits for Dimensional Operations\n\n"   
  val s42 = (dimA: String, dimB: String, dimC: String) =>   //	implicit def Speed_x_Time(a:Speed, b:Time) = new Length(a.x * b.x) 
	  "\timplicit def " + dimB + "_x_" + dimC + "(a:" + dimB + ", b:" + dimC + ") = new " + dimA + "(a.x * b.x)\n"
	val s43 = (dimA: String, dimB: String, dimC: String) =>   //	implicit def Length_d_Time(a:Length, b:Time, op:Null) = new Speed(a.x / b.x)"""
	  "\timplicit def " + dimA + "_d_" + dimB + "(a:" + dimA + ", b:" + dimB + ", op:Null) = new " + dimC + "(a.x / b.x)\n"
	val s44 = (dim: String, root: String) => "\timplicit def sqroot(a: " + dim + ", op:Null) = new " + root + "(scala.math.sqrt(a.x))\n"

	// Close top level object
	val s99 = "}\n\n"
	

	 /**
	 * Main generator function
	 */
	def generate(setName: String, defFileName: String, scalaFileName: String) {
	  val (dimDef, opsDef) = readDefs(defFileName)
	  val dimList: List[DimRepr] = readDimensions(dimDef)
	  val dimClassesCode = genDimClasses(dimList)
	  val dimImplCode = genDimImplCode(dimList)
	  val opsList: List[Triple[String, String, String]] = readOperations(opsDef)
	  val opsCode = genOperationsCode(opsList, dimList)
	  val code = s00(setName) + s01 + s02 + s03(setName) + dimClassesCode + dimImplCode + opsCode + s99
	  Files.writeToFile(scalaFileName:String, code)
	  code 
	}
	
	/**
	 * @return the Dimensions and Operations sections as two separate strings
	 */
	def readDefs(fileName: String) = {
		val strData = scala.io.Source.fromFile(fileName).mkString
		val elemData = strData.split("##")
		val dimDef = elemData.dropWhile(_!="Dimensions").tail.head
		val opsDef = elemData.dropWhile(_!="Operations").tail.head
		(dimDef, opsDef)
	}
	
	/**
	 * @return a list of DimRepr objects, parsed from Dimension description file
	 */
	def readDimensions(dimDefs: String): List[DimRepr] = {
	  val dimLines = getLines(dimDefs)
	  for {
	    line <- dimLines; 
	  	dim = DimRepr.parse(line)
	  }  yield dim
	}

	/**
	 * @return a list of Triples (A, B, C) where A=B*C - as dimensions
	 */
	def readOperations(opsDef: String): List[Triple[String, String, String]] = {
 		val mkOpsTriple = (op:String) => {
		  val split1 = op.split('=')
		  val split2 = split1(1).split('*')
		  Triple(split1(0), split2(0), split2(1))
		}
 		getLines(opsDef) map (mkOpsTriple)
	}

	/**
	 * @return the Dimension classes code	
	 */
	def genDimClasses(dimList: List[DimRepr]) = {
 	  val dimCode = new StringBuilder
	  for (dim <- dimList) {
	  	dimCode ++= s21(dim.name)
	  	dimCode ++= s22(dim.name)
	  	dimCode ++= s23(dim.name)
	  	dimCode ++= s24(dim.baseUnits)
	  	dimCode ++= s25(dim.mainUnit)
	  	val tmpMappings = dim.allUnits.keySet.foldLeft("")((acc, key) => acc + sMapping(key, dim.allUnits(key)))
	  	val mappings = if (dim.allUnits.size == 0) tmpMappings else tmpMappings.dropRight(2) 
	  	dimCode ++= s26(mappings)
	  	dim.allUnits.keySet.foreach(
	  		(key: String) => dimCode ++= s27(dim.name, key, dim.allUnits(key))
	  	)
	  	dimCode ++= s29
	  }
 	  dimCode.toString
	}
	
	/**
	 * @return the doubleTo<Dimension> implicits lines 
	 */
	def genDimImplCode(dimList: List[DimRepr]) = {
	  val implCode = new StringBuilder ++= s11
	  for (dim <- dimList) {
	    implCode ++= s15(dim.name)
	  }
	  implCode ++= s19
	  implCode.toString
	}

	/**
	 * @return the operations implicits code
	 */
	def genOperationsCode(opsList: List[Triple[String, String, String]], dimList: List[DimRepr]) = {
 		val opsCode = new StringBuilder ++= s41
	  for (op <- opsList) {
	    val square = op._2 == op._3    // true if this is a squaring operation
	    if (!square) opsCode ++= s42(op._1, op._2, op._3)
	    opsCode ++= s42(op._1, op._3, op._2)
	    if (!square) opsCode ++= s43(op._1, op._2, op._3)
	    opsCode ++= s43(op._1, op._3, op._2) 
	    if (square) opsCode ++= s44(op._1, op._2)
	    opsCode ++= "\n"
		}

// 		for (dim <- dimList; if (dim.isSquare)) {
// 		  val rootDim = findRootDim(dim, dimList)
//			opsCode ++= s44(dim.name, rootDim.name) 
//		}

		opsCode.toString
	}
	
	def findRootDim(dim:DimRepr, dimList: List[DimRepr]): DimRepr = {
	  val rootUnitsMap = for (d <- dim.baseUnitsMap) yield (d._1, d._2/2)
	  for (d <- dimList) {
	    if (d.baseUnitsMap == rootUnitsMap) return d
	  }
	  throw new Exception("Root dimension not found for " + dim.name)
	}
	
	def getLines(in:String): List[String] = {
	  val lines = in.linesIterator.toList
	  for { line <- lines
	  			s = line.takeWhile(_!='/').trim
	  			if (!s.isEmpty)
	  } yield s 
	}

	def main(args: Array[String]) {
	  val setName = if (args.size > 0) args(0) else "SI"   // generate the "SI" set by default
	  val defFile = """src/main/config/UnitsDef_""" + setName + ".txt"
	  val scalaFile = """src/main/scala/scalau/units/Units_""" + setName + ".scala"
	  generate(setName, defFile, scalaFile)
	}

}

