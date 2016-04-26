package week7

object week7_2 {
	// 소수 검사 함수
	def isPrime(x: Int) =
		if (x <= 1) false
		else (2 to (x - 1)) forall (x % _ != 0)
                                                  //> isPrime: (x: Int)Boolean


	// 결과
  (1 to 20) filter (isPrime(_))                   //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 5, 7, 11, 13
                                                  //| , 17, 19)



	// 1000 보다 크고 10000보다 작은 두 번 째 소수 구하기
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Range@filter(p:A=>Boolean):Repr
	((1000 to 10000) filter isPrime)(1)       //> res1: Int = 1013
	
	
	// 재귀를 사용한 구현
	def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
                                                  //> secondPrime: (from: Int, to: Int)Int
	def nthPrime(from: Int, to: Int, n: Int): Int =
		if (from >= to) throw new Error("no prime")
		else if (isPrime(from))
			if (n == 1) from
			else nthPrime(from + 1, to, n - 1)
		else nthPrime(from + 1, to, n)    //> nthPrime: (from: Int, to: Int, n: Int)Int
		
  secondPrime(1000, 10000)                        //> res2: Int = 1013

	// secondPrime 은 잘 동작하지만 너무 구현이 장황함
	// 앞의 filter 사용한 버전은 간단하지만 filter 과정에서 쓸모없는 연산을 많이 하게 됨
	// 10000의 상위값을 줄이면 속도를 개선 가능하지만, 값을 얻을 수 없는 상황이 생길 수도 있음
	// 성능과 기능 사이에서 헤매는 상황이 발생함
	// 간단한 버전에서 tail 을 미리 evaluation하지 않는고 필요할 때만 evaluation한다면 성능의 문제를 해결할 수 있음
	// Stream 에서 그렇게 구현함
  
  // 빈 스트림
  //Stream.empty
  // http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$@empty[A]:scala.collection.immutable.Stream[A]
  
  // 스트림 생성자
	//Stream.cons
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$@cons
  
  // Stream.empty, Stream.cons 사용
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)

	// 일반적인 컬렉션과 비슷하게 Stream 객체를 팩토리로 사용할 수 있음
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$@apply[A](xs:A*):scala.collection.immutable.Stream[A]
  val xs1 = Stream(1, 2, 3)                       //> xs1  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  // 컬렉션에 toStream 메소드 호출하여 스트림화시킬 수 있음
  // http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Range@toStream:scala.collection.immutable.Stream[A]
  (1 to 1000).toStream                            //> res3: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  // 스트림 값의 ? 표시는 아직 evaluated 되지 않은 값임을 표시함

	// (lo until hi).toStream 을 직접 구현한다면 ...
	def streamRange(lo: Int, hi: Int): Stream[Int] =
		if (lo >= hi) Stream.empty
		else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
		
	// 위의 함수의 List 용 버전은 구조상으로는 같음
	// Stream.empty == Nil
	// Stream.cons == ::
	def listRange(lo: Int, hi: Int): List[Int] =
		if (lo >= hi) Nil
		else lo :: listRange(lo + 1, hi)  //> listRange: (lo: Int, hi: Int)List[Int]
		
	// Stream 은 List 의 거의 모든 메소드를 지원함
	// 아래의 예제는 filter 와 apply 메소드가 사용됨
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream
	((1000 to 10000).toStream filter isPrime)(1)
                                                  //> res4: Int = 1013
                                                  
	// ::. 은 Stream 에서 지원이 안 됨
	// #:: 라는 메소드를 Stream 용으로 지원
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream@#::(hd:A):scala.collection.immutable.Stream[A]
	// x #:: xs == Stream.cons(x, xs)
	// #:: 를 패턴에서도 사용할 수 있음
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream@#::(hd:A):scala.collection.immutable.Stream[A]
	val zeroTofive = 0 #:: (1 to 5).toStream  //> zeroTofive  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
	zeroTofive.toList                         //> res5: List[Int] = List(0, 1, 2, 3, 4, 5)
	zeroTofive match {
		case 0 #:: xs => "0 match"
		case x #:: xs => "x match"
	}                                         //> res6: String = 0 match
	
	// Stream 에 대한 구현 코드
	// 예전에 작업했던 List 와 비슷
	//trait Stream[+A] extends Seq[A] {
	//	def isEmpty: Boolean
	//	def head: A
	//	def tail: Stream[A]
	//}
	
	// => 의 pass by name 이 키포인트
	//object Stream {
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$$cons$
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$$Cons
	// https://github.com/scala/scala/blob/v2.11.8/src/library/scala/collection/immutable/Stream.scala#L1223
	//	def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
	//		def isEmpty = false
	//		def head = hd
	//		def tail = tl
	//	}
	
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$@empty[A]:scala.collection.immutable.Stream[A]
	// http://www.scala-lang.org/api/2.11.8/index.html#scala.collection.immutable.Stream$$Empty$
	// https://github.com/scala/scala/blob/v2.11.8/src/library/scala/collection/immutable/Stream.scala#L1166
	//	val empty = new Stream[Nothing] {
	//		def isEmpty = true
	//		def head = throw new NoSuchElementException("empty.head")
	//		def tail = throw new NoSuchElementException("empty.tail")
	//	}
	//}
	
	// 그 외에 각종 메소드들이 구현되어 있다.
	// 하나의 예인 filter 의 구현
	// https://github.com/scala/scala/blob/v2.11.8/src/library/scala/collection/immutable/Stream.scala#L515
	//def filter(p: T => Boolean): Stream[T] =
	//	if (isEmpty) this
	//	else if (p(head)) cons(head, tail.filter(p))
	//	else tail.filter(p)
	
	
	// 퀴즈
	//def streamRange(lo: Int, hi: Int): Stream[Int] =
	//	print(lo + " ")
	//	if (lo >= hi) Stream.empty
	//	else Stream.cons(lo, streamRangeㅆ(lo + 1, hi))
	
	// https://github.com/scala/scala/blob/v2.11.8/src/library/scala/collection/immutable/Stream.scala#L846
	streamRange(1, 10).take(3).toList         //> res7: List[Int] = List(1, 2, 3)
}