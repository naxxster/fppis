package week4

trait Expr {}
class Number(n: Int) extends Expr {}
class Sum(e1: Expr, e2: Expr) extends Expr {}