package scalau.generator

/**
 * A Dimension object representation
 */
case class DimRepr(val name: String, 
    							 val baseUnits: String, 
    							 val baseUnitsMap: Map[String, Int], 
    							 val mainUnit: String, 
    							 val allUnits: Map[String, Double]) {

  def isSquare: Boolean = !baseUnitsMap.values.exists(_%2 != 0)
}

/**
 * A parser and builder for Dimension objects
 */
object DimRepr {
  
  def parse(line: String): DimRepr = {
    val elem = line.split(';').map(_.trim)
    require(elem.size>2)
    val name = elem(0)
    val baseUnits = elem(1)
    val baseUnitsMap = parseBaseUnits(baseUnits)
    val mainUnit = elem(2)
    val splitter = (str: String) => {
    	val xs = str.split('=');
    	require(xs.size == 1 || xs.size ==2, "wrong allUnits description: " + str)
    	val factor = if (xs.size == 1) 1.0 else xs(1).toDouble
    	xs(0) -> factor
    }
    val allUnits = elem.drop(2).map(splitter).toMap
    
    DimRepr(name, baseUnits, baseUnitsMap, mainUnit, allUnits)
  }
  
  /**
   * We may not even need this
   */
  def parseBaseUnits(baseUnits: String): Map[String, Int] = {  // in: _m__s2  out: Map("_m"->1, "_s"->(-2))
    var chars = baseUnits.toList
    val baseUnitsMap = scala.collection.mutable.Map[String, Int]()
    val isUnderscore = (c: Char) => c == '_'
    while (!chars.isEmpty) {
      val x = chars.prefixLength(isUnderscore(_))
      require (x==1 || x==2, "None, or too many underscores starting here: " + chars + " in " + baseUnits)
      var factor = if (x==1) 1 else -1
      chars = chars.dropWhile(isUnderscore(_))
      
      val u = chars.takeWhile(_.isLetter)
      require(u.size > 0, "No letters found for unit stating here: " + chars + " in " + baseUnits)
      val unit = u.foldLeft("")(_+_)
      chars = chars.dropWhile(_.isLetter)
      
      val num = chars.takeWhile(_.isDigit)
      if (num.size > 0) factor *= num.foldLeft("")(_+_).toInt
      chars = chars.dropWhile(_.isDigit)
      
      baseUnitsMap(unit) = factor
    } 
    baseUnitsMap.toMap    
  }

// 	def main(args: Array[String]) {
//  	println(DimRepr.parse("Pressure; _kg4__m8_s2; _Pa; _N__m2; _kPa=1000"))
// 	}

}
