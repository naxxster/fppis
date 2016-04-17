package week6

object week6_5 {
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  	for (x <- xs) yield f(x)                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  	
  def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  	for (x <- xs; y <- f(x)) yield y          //> flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]
 
 	def filter[T](xs: List[T], p: T => Boolean): List[T] =
 		for (x <- xs if p(x)) yield x     //> filter: [T](xs: List[T], p: T => Boolean)List[T]
 		
 	val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> xs  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  mapFun(xs, (x: Int) => x * 1.5)                 //> res0: List[Double] = List(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15
                                                  //| .0)
                                                  
  flatMap(xs, (x: Int) => 0 to x)                 //> res1: List[Int] = List(0, 1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3,
                                                  //|  4, 5, 0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 
                                                  //| 8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  filter(xs, (x: Int) => x % 2 == 0)              //> res2: List[Int] = List(2, 4, 6, 8, 10)

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
  )                                               //> books  : Set[week6.week6_5.Book] = Set(Book(Effective Java 2,List(Bloch, Jo
                                                  //| shua)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex, Venners
                                                  //| , Bill)), Book(Structure and Interpretation of Computer Programs,List(Abels
                                                  //| on, Harald, Sussman, Gerald J.)), Book(Effective Java,List(Bloch, Joshua)),
                                                  //|  Book(Introduction to Functional Programming,List(Bird, Richard, Wadler, Ph
                                                  //| il)), Book(Java Puzzlers,List(Bloch, Joshua, Gafter, Neal)))
                                                  
  for (b <- books; a <- b.authors if a startsWith "Bloch,")
  	yield b.title                             //> res3: scala.collection.immutable.Set[String] = Set(Effective Java 2, Effect
                                                  //| ive Java, Java Puzzlers)

	books.flatMap(b => b.authors.withFilter(a => a startsWith "Bloch,").map(a => b.title))
                                                  //> res4: scala.collection.immutable.Set[String] = Set(Effective Java 2, Effect
                                                  //| ive Java, Java Puzzlers)
}