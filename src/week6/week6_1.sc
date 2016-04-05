package week6

object week6_1 {
	val nums = Vector(1, 2, 3, -88)           //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, -88)
  val people = Vector("Bob", "James", "Peter")    //> people  : scala.collection.immutable.Vector[String] = Vector(Bob, James, Pet
                                                  //| er)
                                                  
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  xs map (_ * 2)                                  //> res1: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (_.isUpper)                            //> res2: String = HW
  
  1 until 5                                       //> res3: scala.collection.immutable.Range = Range(1, 2, 3, 4)
  1 to 5                                          //> res4: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res5: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res6: scala.collection.immutable.Range = Range(6, 4, 2)
  
  s exists (_.isUpper)                            //> res7: Boolean = true
  s forall (_.isUpper)                            //> res8: Boolean = false

  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res9: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (List('.', _))                        //> res10: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res11: Int = 50
  xs.max                                          //> res12: Int = 44
  
  def isPrime(n: Int): Boolean =
  	(2 until n) forall (n % _ != 0)           //> isPrime: (n: Int)Boolean

	1 until 2                                 //> res13: scala.collection.immutable.Range = Range(1)
  isPrime(1)                                      //> res14: Boolean = true
  isPrime(2)                                      //> res15: Boolean = true
  isPrime(3)                                      //> res16: Boolean = true
  isPrime(4)                                      //> res17: Boolean = false
}