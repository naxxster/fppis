package week5

object week5_1 {
  def last[T](xs: List[T]): T = xs match {
  	case Nil => throw new Error("last of empty list")
  	case List(x) => x
  	case y :: ys => last(ys)
  }                                               //> last: [T](xs: List[T])T
  
  def init[T](xs: List[T]): List[T] = xs match {
  	case Nil => throw new Error("init of empty list")
  	case List(x) => List()
  	case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  	case Nil => ys
  	case x :: xs1 => x :: concat(xs1, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  def reverse[T](xs: List[T]): List[T] = xs match {
  	case Nil => Nil
  	case List(x) => List(x)
  	case x :: xs1 => reverse(xs1) ::: List(x)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  def removeAt[T](xs: List[T], n: Int) = {
  	(xs take n) ::: (xs drop (n + 1))
 	}                                         //> removeAt: [T](xs: List[T], n: Int)List[T]
                                                  
	def flatten(xs: List[Any]): List[Any] = xs match {
		case Nil => Nil
		case Nil :: xs1 => flatten(xs1)
		case (y :: ys) :: xs1 => flatten(y :: ys) ::: flatten(xs1)
		case x :: xs1 => x :: flatten(xs1)
	}                                         //> flatten: (xs: List[Any])List[Any]
  
  last(List(1, 2, 3))                             //> res0: Int = 3
  init(List(1, 2, 3))                             //> res1: List[Int] = List(1, 2)
  concat(List(1, 2), List(3, 4))                  //> res2: List[Int] = List(1, 2, 3, 4)
  reverse(List(1, 2, 3, 4))                       //> res3: List[Int] = List(4, 3, 2, 1)
  removeAt(List(1, 2, 3, 4), 2)                   //> res4: List[Int] = List(1, 2, 4)
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res5: List[Any] = List(1, 1, 2, 3, 5, 8)
}