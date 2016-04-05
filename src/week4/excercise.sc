package week4

object excercise {
//	def eval(e: Expr): Int = e match {
//		case Number(n) => n
//		case Sum(e1, e2) => eval(e1) + eval(e2)
//	}
	
	List(1, 2) ++ List(3, 4)                  //> res0: List[Int] = List(1, 2, 3, 4)
	List(1, 2) ::: List(3, 4)                 //> res1: List[Int] = List(1, 2, 3, 4)
	
	(1, 2)                                    //> res2: (Int, Int) = (1,2)
}