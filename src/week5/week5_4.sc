package week5

object week5_4 {
  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
  	case Nil => xs
  	case y :: ys => y * factor :: scaleList(ys, factor)
  }                                               //> scaleList: (xs: List[Double], factor: Double)List[Double]
  
  def map[T,U](xs: List[T], f: T => U): List[U] = xs match {
  	//case Nil => xs
  	case Nil => Nil
  	case y :: ys => f(y) :: map(ys, f)
  }                                               //> map: [T, U](xs: List[T], f: T => U)List[U]
  
  def scaleList2(xs: List[Double], factor: Double): List[Double] =
  	xs map (x => x * factor)                  //> scaleList2: (xs: List[Double], factor: Double)List[Double]

  scaleList(List(1, 2, 3, 4, 5), 1.5)             //> res0: List[Double] = List(1.5, 3.0, 4.5, 6.0, 7.5)
  scaleList2(List(1, 2, 3, 4, 5), 1.5)            //> res1: List[Double] = List(1.5, 3.0, 4.5, 6.0, 7.5)
  //map(List(1, 2, 3, 4, 5), x => x * 1.5)
  map(List(1, 2, 3, 4, 5), (x: Int) => x * 1.5)   //> res2: List[Double] = List(1.5, 3.0, 4.5, 6.0, 7.5)
  
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case y :: ys => (y * y) :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map (x => x * x)                       //> squareList2: (xs: List[Int])List[Int]
  
  squareList(List(1, 2, 3, 4, 5))                 //> res3: List[Int] = List(1, 4, 9, 16, 25)
  squareList2(List(1, 2, 3, 4, 5))                //> res4: List[Int] = List(1, 4, 9, 16, 25)
  
  def posElems(xs: List[Int]): List[Int] = xs match {
  	case Nil => xs
  	case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  }                                               //> posElems: (xs: List[Int])List[Int]
  
  def filter[T](xs: List[T], f: T => Boolean): List[T] = xs match {
  	case Nil => xs
  	case y :: ys => if (f(y)) y :: filter(ys, f) else filter(ys, f)
  }                                               //> filter: [T](xs: List[T], f: T => Boolean)List[T]
  
  def posElems2(xs: List[Int]): List[Int] =
  	xs filter (x => x > 0)                    //> posElems2: (xs: List[Int])List[Int]
  	
  posElems(List(-1, 2, -3, 4))                    //> res5: List[Int] = List(2, 4)
  posElems2(List(-1, 2, -3, 4))                   //> res6: List[Int] = List(2, 4)
  filter(List(-1, 2, -3, 4), (x: Int) => x > 0)   //> res7: List[Int] = List(2, 4)
  
  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	nums filter (x => x > 0)                  //> res8: List[Int] = List(2, 5, 7, 1)
	nums filterNot (x => x > 0)               //> res9: List[Int] = List(-4)
	nums partition (x => x > 0)               //> res10: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
	nums takeWhile (x => x > 0)               //> res11: List[Int] = List(2)
	nums dropWhile (x => x > 0)               //> res12: List[Int] = List(-4, 5, 7, 1)

	nums span (x => x > 0)                    //> res13: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
	
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case y :: ys => {	// { 가 필요없네? }
			val (first, second) = xs span (x => x == y)
			first :: pack(second)
		}
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	
	pack(List("a", "a", "a", "b", "c", "c", "a"))
                                                  //> res14: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a
                                                  //| ))
                                                  
	def encode[T](xs: List[T]): List[(T, Int)] = {
		def encodePacked(xs: List[List[T]]): List[(T, Int)] = xs match {
			case Nil => Nil
			case y :: ys => (y.head, y.length) :: encodePacked(ys)
		}
		
		encodePacked(pack(xs))
	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
	
	def encode2[T](xs: List[T]): List[(T, Int)] = {
		pack(xs) map (ys => (ys.head, ys.length))
	}                                         //> encode2: [T](xs: List[T])List[(T, Int)]
	
	encode(List("a", "a", "a", "b", "c", "c", "a"))
                                                  //> res15: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
                                                  
	encode2(List("a", "a", "a", "b", "c", "c", "a"))
                                                  //> res16: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}