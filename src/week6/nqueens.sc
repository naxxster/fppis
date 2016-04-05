package week6

object nqueens {
  def queens(n: Int): Set[List[Int]] = {
  	def placeQueens(k: Int): Set[List[Int]] = {
  			
  		if (k == 0) Set(List())
  		else
  			for {
  				queens <- placeQueens(k - 1)
  				col <- 0 until n
  				if isSafe(col, queens)
  			} yield col :: queens
  	}
  	placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]

  def isSafe(col: Int, queens: List[Int]): Boolean = {
  	val row = queens.length
  	val queensWithRow = (row - 1 to 0 by -1) zip queens
  	queensWithRow forall {
  		case (r, c) => col != c && row + col != r + c && row - col != r - c
  	}
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean

	isSafe(0, Nil)                            //> res0: Boolean = true
	isSafe(2, List(1))                        //> res1: Boolean = false
	
	queens(4)                                 //> res2: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
	
	((3-1) to 0 by -1) zip List(0, 3, 1)      //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,0), (1,3
                                                  //| ), (0,1))
                                                  
	def show(queens: List[Int]) = {
		val lines =
			for (col <- queens.reverse)
			yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
		"\n" + (lines mkString "\n")
	}                                         //> show: (queens: List[Int])String
	
	(queens(4) map show) mkString "\n"        //> res4: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
                                                  
	(queens(8) map show) take 3 mkString "\n" //> res5: String = "
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * X * * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * X * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * X * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * X * * * * * "
}