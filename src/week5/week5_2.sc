package week5

object week5_2 {
  def msort(xs: List[Int]): List[Int] = {
  	val n = xs.length / 2
  	if (n == 0) xs
  	else {
	  	def merge(xs: List[Int], ys: List[Int]): List[Int] =
		  	(xs, ys) match {
		  		case (Nil, ys) => ys
	  			case (xs, Nil) => xs
	  			case (x :: xs1, y :: ys1) => {
	  				if (x <= y)
	  					x :: merge(xs1, ys)
	  				else
	  					y :: merge(xs, ys1)
	  			}
		  	}
  		val (first, second) = xs splitAt n
  		merge(msort(first), msort(second))
  	}
  }                                               //> msort: (xs: List[Int])List[Int]
  
  msort(List(4, 1, -2, 5, 9))                     //> res0: List[Int] = List(-2, 1, 4, 5, 9)
}