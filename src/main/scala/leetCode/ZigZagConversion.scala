package leetCode


object ZigZagConversion extends App {
  def convert(s: String, numRows: Int): String = {
    s.toList
    val result = tailRecConvert(0, s.toList, Array.ofDim(numRows), numRows, goUp = true)
    result.foreach(a => println(a))
    result.toList.mkString("").replace("null", "")
  }
  println(convert("PAYPALISHIRING", 3))

  def tailRecConvert(i: Int, l: List[Char], acc: Array[String], numRows: Int, goUp: Boolean): Array[String] = {
    l match {
      case Nil => acc
      case h::tail =>
        if(i == numRows - 1)
          tailRecConvert(i= i - 1, tail, acc.updated(i, acc(i) + h.toString), numRows, goUp = false)
        else if(i == 0)
          tailRecConvert(i = i + 1, tail, acc.updated(i, acc(i) + h.toString), numRows, goUp = true)
        else if(goUp)
          tailRecConvert(i = i + 1, tail, acc.updated(i, acc(i) + h.toString), numRows, goUp)
        else if(!goUp)
          tailRecConvert(i = i - 1, tail, acc.updated(i, acc(i) + h.toString), numRows, goUp)
        else
          tailRecConvert(i, tail, acc, numRows, goUp)
    }
  }

}