package week5

import scala.math.Ordering

object week5_3 {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  	val n = xs.length / 2
  	if (n == 0) xs
  	else {
	  	def merge(xs: List[T], ys: List[T]): List[T] =
		  	(xs, ys) match {
		  		case (Nil, ys) => ys
	  			case (xs, Nil) => xs
	  			case (x :: xs1, y :: ys1) => {
	  				if (ord.lt(x, y))
	  					x :: merge(xs1, ys)
	  				else
	  					y :: merge(xs, ys1)
	  			}
		  	}
  		val (first, second) = xs splitAt n
  		merge(msort(first)(ord), msort(second)(ord))
  	}
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

	val xs = List(-5, 6, 3, 2, 7)             //> xs  : List[Int] = List(-5, 6, 3, 2, 7)
	val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  msort(xs)                                       //> res0: List[Int] = List(-5, 2, 3, 6, 7)
  msort(fruit)                                    //> res1: List[String] = List(apple, orange, pear, pineapple)
}