package leetCode

object SumOfSquareNumbers extends App{
  def judgeSquareSum(c: Int): Boolean = {
    findSquareSumNumbers(c, false, 0, Math.sqrt(c).toInt)
  }

  println(judgeSquareSum(5))

  def findSquareSumNumbers(c: Int, acc: Boolean, a: Int, b: Int): Boolean = {
    if(a>b)
      acc
    else{
      val result = Math.sqrt(a) + Math.sqrt(b)
      if(result == c)
        findSquareSumNumbers(c, true, a, b = b - 1)
      else if (result > c)
        findSquareSumNumbers(c, false, a, b = b - 1)
      else if(result < c)
        findSquareSumNumbers(c, false, a = a + 1, b)
      else
        findSquareSumNumbers(c, false, a, b)
    }
  }
}
