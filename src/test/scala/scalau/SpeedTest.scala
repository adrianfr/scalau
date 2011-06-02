package scalau

import scalau.units.Units_SI_extra._
//import scalau.units.Units_SI._
//import scalau.units.Units_Imperial._

/**
 * Most of the tests are about compile-time Dimensional checking;
 * If this compiles, the tests pass 
 */
object SpeedTest extends App { 
  
  def timed[T](label: String)(code: => T): T = {
    val t1 = System.nanoTime;
    val res = code
    val time = System.nanoTime - t1
    println(label + " " + time/1000000.0 + " millisec")
    res
  }

  def times(n: Int)( code: =>Unit ) {
    for (i <- 1 to n) code
  }

  val a = 2.2._m__s
  val b = 4.5._m__s
	timed ("Dimension"){
  	times(100000) {
  	  a*b
  	}
	}
	
	timed ("Double"){
  	times(100000) {
  	  2.2+4.5
  	}
	}
	
	
}
