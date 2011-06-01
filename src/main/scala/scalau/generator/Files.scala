package scalau.generator

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * File read/write utilities
 */
object Files {
	def using[A <: {def close(): Unit}, B](param: A)(f: A => B): B =
		try { f(param) } finally { param.close() }

	/**
	 * Writes the String text to file: fileName
	 */
	def writeToFile(fileName:String, text:String) =
	  using (new java.io.FileWriter(fileName)) {
	    fileWriter => fileWriter.write(text)
	  }

	/**
	 * Appends the String text to the contents of file: fileName
	 */
	def appendToFile(fileName:String, text:String) =
	  using (new FileWriter(fileName, true)){ 
	    fileWriter => using (new PrintWriter(fileWriter)) {
	      printWriter => printWriter.println(text)
	    }
	  }
	
	/**
	 * @return A String containing the contents of the file <fileName> 
	 */
	def readFromFile(fileName:String): String =  scala.io.Source.fromFile(fileName).mkString

}