package scalau

/**
 * Generic Dimension class. 
 * The concrete type (Impl) is specified in the generated classes 
 */
trait Dimension {
  type Impl <: Quantity
  def build(x:Double): Impl
  val baseUnits: String  // string representation of base units. e.g.: "_kg_m2__s3"
  val mainUnit: String                   // e.g. "_W"
  def allUnits: Map[String, Double]      // e.g. ("_J__s" -> 1.0, "_hp" -> 745.699872)
  def name = getClass().getSimpleName()  // e.g. "Power"
  override def toString() = name
  
  /**
   * Parse baseUnits into a Map. For example: "_kg_m2__s2"  ==>  Map("_kg"->1, "_m"->2, "_s"->-2)
   */
  def baseUnitsMap: Map[String, Int] = {  // _m->1, _s->-2
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

  def isSquare: Boolean = !baseUnitsMap.values.exists(_%2 != 0)

}

/**
 * Quantity class. Holds a numeric value linked to a Dimension
 */
abstract class Quantity (val x: Double) extends Dimension {
  
  /**
   * @return the Double (scalar) value of the Quantity in the main unit
   */
  def get = x
  
  /**
   * Plain unit conversion
   * @return a scalar(Double) value representing the equivalent Quantity in the given unit 
   */
  def get(unit: String): Double = {
    x/allUnits(unit)                 
  }

  /**
   * Unit conversion to multiple units (e.g. "_ft", "_in".  Feet and inches
   * @return a List of scalar(Double) value representing the equivalent Quantity in the given unit(s) 
   */
  def get(unit1: String, unit2: String, moreUnits: String*): Map[String, Double] = {
    Map[String, Double]()          
    // todo: conversion for more than 1 unit
  }
  
  /**
   * toString
   */
  override def toString() = "%f %s (%s)".format(x, mainUnit, super.toString)
}

/**
 * Addition, Subtraction with identical Dimensions
 * Multiplication, Division with scalars
 * In all these cases the result is of the same dimension
 */
trait Addable {
  self: Quantity =>
    
  /**
   * Addition with same dimension
   */
  def +(other: Impl) = {
    val r = build(x + other.x)
    println("Addition: " + x + "+" + other.x + "=" + r)
    r
  }
  
  /**
   * Subtraction with same Dimension
   */
  def -(other: Impl) = {
    val r = build(x - other.x)
    println("Subtraction: " + x + "-" + other.x + "=" + r)
    r
  }
  
  /**
   * Multiplication with scalar
   */
  def *(num: Double): Impl = {   // or self.Impl
    val r = build(x * num)
    println("Mult with scalar: " + x + "*" + num + "=" + r)
    r
  }
  
  /**
   * Division with scalar
   */
  def /(num: Double): Impl = {   // or self.Impl
    val r = build(x / num)
    println("Div with scalar: " + x + "/" + num + "=" + r)
    r
  }
  
  /**
   * Division with same dimension => scalar
   */
  def /(other: Impl): Double = {
    val r = x / other.x
    println("Division with same Dimension: " + x + "/" + other.x + "=" + r)
    r
  }

}

/**
 * Implementation of Multiplication and Division with other dimensions. 
 * The resulting type is specified by the implicits
 * Also implements square root op.
 */
trait Multipliable {
  self: Quantity =>
    
  // todo: need to move the actual operation (mult/div/sqrt) to this trait
  // the implicit functions only need to provide the resulting type/dimension
  def *[B <: Quantity, Res <: Quantity](other: B)(implicit mult: (this.type, B) => Res): Res = {
    val r = mult(self, other)
    println("" + x + "*" + other.x + "=" + r)
    r
  }
  def /[B <: Quantity, Res <: Quantity](other: B)(implicit divide: (this.type, B, Null) => Res): Res = {
    val r = divide(this, other, null)
    println("" + x + "/" + other.x + "=" + r)
    r
  }
  def sqrt[Res <: Quantity](implicit sqroot: (this.type, Null) => Res): Res = {
    val r = sqroot(this, null)
    println("" + x + " sqrt=" + r)
    r
  }
}

/**
 * Basic comparation operators. Will accept only the same Dimension
 */
trait Comparable {
  self: Quantity =>
  def >(other: Impl) = x > other.x
  def >=(other: Impl) = x >= other.x
  def <(other: Impl) = x < other.x
  def <=(other: Impl) = x <= other.x
  def ==(other: Impl) = x == other.x
  def !=(other: Impl) = x != other.x
}
