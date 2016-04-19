package week6

import scala.io.Source

object week6_7 {
	val mnemonics = Map(
  	'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  	'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
                                                  //> mnemonics  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -
                                                  //| > GHI, 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
  	
  def translate(phoneNumber: String) = ???        //> translate: (phoneNumber: String)Nothing

	val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords")
                                                  //> java.io.FileNotFoundException: http://lamp.epfl.ch/files/content/sites/lamp/
                                                  //| files/teaching/progfun/linuxwords
                                                  //| 	at sun.net.www.protocol.http.HttpURLConnection.getInputStream0(Unknown S
                                                  //| ource)
                                                  //| 	at sun.net.www.protocol.http.HttpURLConnection.getInputStream(Unknown So
                                                  //| urce)
                                                  //| 	at java.net.URL.openStream(Unknown Source)
                                                  //| 	at scala.io.Source$.fromURL(Source.scala:141)
                                                  //| 	at scala.io.Source$.fromURL(Source.scala:131)
                                                  //| 	at week6.week6_7$$anonfun$main$1.apply$mcV$sp(week6.week6_7.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week6.week6_7$.main(week6.week6_7.scala:5)
                                                  //| 	at week6.week6_7.main(week6.week6_7.scala)
	val words = in.getLines
	val mnem = Map(
		'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  	'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
  
  def charCode: Map[Char, Char] =
  	for ((key, value) <- mnem;
  				letter <- value)
  		yield letter -> key
  		
  def wordCount(word: String): String =
  	word.toUpperCase map charCode
  	
  wordCount("JAVA")
}