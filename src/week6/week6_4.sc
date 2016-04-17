package week6

object week6_4 {
  case class Book(title: String, authors: List[String]) {}
  
  val books: Set[Book] = Set(
  	Book(title   = "Structure and Interpretation of Computer Programs",
  			 authors = List("Abelson, Harald", "Sussman, Gerald J.")),
  	Book(title   = "Introduction to Functional Programming",
  			 authors = List("Bird, Richard", "Wadler, Phil")),
  	Book(title   = "Effective Java",
  			 authors = List("Bloch, Joshua")),
  	Book(title   = "Effective Java 2",
  			 authors = List("Bloch, Joshua")),
  	Book(title   = "Java Puzzlers",
  			 authors = List("Bloch, Joshua", "Gafter, Neal")),
  	Book(title   = "Programming in Scala",
  			 authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
  )                                               //> books  : Set[week6.week6_4.Book] = Set(Book(Effective Java 2,List(Bloch, Jos
                                                  //| hua)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex, Venners, 
                                                  //| Bill)), Book(Structure and Interpretation of Computer Programs,List(Abelson,
                                                  //|  Harald, Sussman, Gerald J.)), Book(Effective Java,List(Bloch, Joshua)), Boo
                                                  //| k(Introduction to Functional Programming,List(Bird, Richard, Wadler, Phil)),
                                                  //|  Book(Java Puzzlers,List(Bloch, Joshua, Gafter, Neal)))
                                                  
  for (b <- books; a <- b.authors if a startsWith "Bloch,")
  	yield b.title                             //> res0: scala.collection.immutable.Set[String] = Set(Effective Java 2, Effecti
                                                  //| ve Java, Java Puzzlers)
  for (b <- books if (b.title indexOf "Program") >= 0)
  	yield b.title                             //> res1: scala.collection.immutable.Set[String] = Set(Programming in Scala, Str
                                                  //| ucture and Interpretation of Computer Programs, Introduction to Functional P
                                                  //| rogramming)
  for {
  	b1 <- books
  	b2 <- books
  	if b1 != b2
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1                                      //> res2: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
  
  for {
  	b1 <- books
  	b2 <- books
  	if b1.title < b2.title
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
 	} yield a1                                //> res3: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)
}