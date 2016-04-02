package week4

object week4_6 {
	def patternType[T](xs: List[T]) = xs match {
		case Nil => "Nil"
		case x => "x"
	}                                         //> patternType: [T](xs: List[T])String
	
	patternType(List(1, 2))                   //> res0: String = x
}