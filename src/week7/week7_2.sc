package week7

object week7_1 {
	def isPrime(x: Int) =
		x % 3 == 0                        //> isPrime: (x: Int)Boolean

	((1000 to 10000) filter isPrime)(1)       //> res0: Int = 1005
	
	def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
                                                  //> secondPrime: (from: Int, to: Int)Int
	def nthPrime(from: Int, to: Int, n: Int): Int =
		if (from >= to) throw new Error("no prime")
		else if (isPrime(from))
			if (n == 1) from else nthPrime(from + 1, to, n - 1)
		else nthPrime(from + 1, to, n)    //> nthPrime: (from: Int, to: Int, n: Int)Int
		
  secondPrime(1000, 10000)                        //> res1: Int = 1005
  
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
                                                  
  val xs1 = Stream(1, 2, 3)                       //> xs1  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  (1 to 1000).toStream                            //> res2: scala.collection.immutable.Stream[Int] = Stream(1, ?)

	def streamRange(lo: Int, hi: Int): Stream[Int] =
		if (lo >= hi) Stream.empty
		else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
		
	def listRange(lo: Int, hi: Int): List[Int] =
		if (lo >= hi) Nil
		else lo :: listRange(lo + 1, hi)  //> listRange: (lo: Int, hi: Int)List[Int]
}