package leetCode

import leetCode.Roman._

import scala.annotation.tailrec


object RomanToInt extends App {
  def romanToInt(s: String): Int = {
    val roman = mapToRoman(s)
    println(roman)
    val v = mapToInt(roman).reverse
    println(v)
    tailRecRomanToInt(v, 0, v.head)
  }
  println(romanToInt("MCMXCIV"))

  @tailrec
  def tailRecRomanToInt(values: List[Int], acc: Int, prev: Int): Int = {
    values match {
      case Nil => Math.abs(acc)
      case h::tail =>
        if (h >= prev)
          tailRecRomanToInt(tail, h + acc, h)
        else
          tailRecRomanToInt(tail, acc - h, h)
    }
  }
  def mapToRoman(s: String): List[Roman] = s.toList.map(r => Roman(r))
  def mapToInt(romanList: List[Roman]): List[Int] = {
    romanList.map{
      case I => 1
      case V => 5
      case X => 10
      case L => 50
      case C => 100
      case D => 500
      case M => 1000
    }
  }
}

case class Roman(value: Char)
object Roman {
  object I extends Roman('I')
  object V extends Roman('V')
  object X extends Roman('X')
  object L extends Roman('L')
  object C extends Roman('C')
  object D extends Roman('D')
  object M extends Roman('M')
}
