package week6

object week6_6 {
  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V -> 
                                                  //| 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
                                                  
  capitalOfCountry("US")                          //> res0: String = Washington
  //capitalOfCountry("Andorra")
  capitalOfCountry get "Andorra"                  //> res1: Option[String] = None
  capitalOfCountry get "US"                       //> res2: Option[String] = Some(Washington)
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case None => "missing data"
  	case Some(capital) => capital
  }                                               //> showCapital: (country: String)String
  
  showCapital("Andorra")                          //> res3: String = missing data
  showCapital("US")                               //> res4: String = Washington
  
  for (x <- capitalOfCountry get "US") yield x    //> res5: Option[String] = Some(Washington)
  for (x <- capitalOfCountry get "US" if x != "Washington") yield x
                                                  //> res6: Option[String] = None
  for (x <- capitalOfCountry get "US"; y <- capitalOfCountry get "Andorra" if x == "Washington") yield (x, y)
                                                  //> res7: Option[(String, String)] = None
                                                  
 	val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit.sortWith(_.length < _.length)             //> res8: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res9: List[String] = List(apple, orange, pear, pineapple)
  fruit.groupBy(_.head)                           //> res10: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pea
                                                  //| r, pineapple), a -> List(apple), o -> List(orange))
                                                  
  val cap1 = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washingto
                                                  //| n, Switzerland -> Bern)
  cap1("Andorra")                                 //> res11: String = <unknown>
}