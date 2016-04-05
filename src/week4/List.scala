package week4

abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException()
  def tail: Nothing = throw new NoSuchElementException()
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

object test {
  val x: List[String] = Nil
  def f(l: List[NonEmpty], x: Empty) = l prepend x
  def f(l: List[List[NonEmpty]], x:List[Empty]) = l prepend x
}