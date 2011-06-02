package scalau

import scalau.units.Units_SI_extra._
//import scalau.units.Units_SI._
//import scalau.units.Units_Imperial._

/**
 * Most of the tests are about compile-time Dimensional checking;
 * If this compiles, the tests pass 
 */
object DimTest extends App { 

  def sameDim[A, B](implicit ev: A =:= B = null) = ev ne null
  
	val speed1 = 10.0 _m__s;  println("speed1=" + speed1)
	val time1 = 5 _min;    println("time1=" + time1)
	val len1 = 25 _ft;  println("len1=" + len1)
	val sp = 77.4354
	val speed2 = sp _m__s
  
//  Operations within the same dimension
//  val x1 = speed1 + time1   // cannot add speed and time; this must be a compile error
	val len2 = (14.0 _m) + len1     // adding same dimensions, different units, ok
	val speed3 = speed1 + 100 _m__s 

	val speed4 = speed3 * 5
	require( speed4.isInstanceOf[Speed] )
	
	val speed5 = speed4 / 3.0
	require( speed5.isInstanceOf[Speed] )

	val ratio = speed5 / speed4    // ratio of same dimensions => Double
	require( ratio.isInstanceOf[Double] )
	
	// testing comparators
	speed1 > speed2

	//  Multiplication, division  - infer and create the correct new type
	val newSpeed = new Length(99) / new Time(12)    // ==>Speed 
	val len3 = len1  + speed1 * time1  + new Length(44)   // type Length inferred correctly
	val speed7 = new Length(44) / new Time(11) - new Speed(66)    // type Speed inferred correctly
	
	implicit def mm(a:Length, b:Time) = new Length(a.x * b.x)
  val whatIsThis = 15._m * (42 _min)  // compile error, if the implicit above is removed

  val m2s2 = 44.0 _m2__s2
  val gy = 21 _Gy
  val sv = 45 _Sv
  
  println(m2s2.getClass)
  
  val fact=4
  val acc = 33 _m__s2
  val t1 = 1.5 _s
  val dist = acc * t1 * t1

  val twicez = acc*2*fact
  
  println ("twice=" + twicez)

	val a = len2 * len3
	val root = (16 _m2).sqrt; 
	
	println("len2 in main units is " + len2.get)
  val len2ft = len2 get "_ft"
  println ("" + len2 + " in feet is " + len2ft)
}
