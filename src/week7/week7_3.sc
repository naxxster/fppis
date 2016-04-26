package week7

object week7_3 {
	lazy val x = {
		println(1)
		10
	}                                         //> x: => Int
	println(2)                                //> 2
	println(x + 1)                            //> 1
                                                  //| 11
 	println(x + 1)                            //> 11
 	
 	def expr = {
 		val x = { print("x"); 1 }
 		lazy val y = { print("y"); 2 }
 		def z = { print("z"); 3 }
 		z + y + x + z + y + x
 	}                                         //> expr: => Int
 	
 	expr                                      //> xzyzres0: Int = 12
}