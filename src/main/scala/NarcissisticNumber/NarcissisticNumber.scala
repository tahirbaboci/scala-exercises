package NarcissisticNumber

import scala.annotation.tailrec

object NarcissisticNumber {


  def narcissistic(n: Int): Boolean = {
    sum(powerOfTheDigits(getDigits(n, List.empty), findCountOfDigits(n, 1)), 0) == n
  }

  def powerOfTheDigits(l: List[Int], count: Int): List[Double] = l.map(scala.math.pow(_,count))

  @tailrec
  def sum(l: List[Double], acc: Double): Double = {
    l match {
      case Nil => acc
      case h::tail => sum(tail, acc+h)
    }
  }
  @tailrec
  def findCountOfDigits(n: Int, acc: Int): Int = {
    val devided = n / 10
    if(devided != 0)
      findCountOfDigits(devided, acc + 1)
    else
      acc
  }
  @tailrec
  def getDigits(n:Int, acc: List[Int]): List[Int] = {
    val digit = n % 10
    if(n != 0) {
      getDigits(n / 10, digit :: acc)
    }
    else
      acc
  }

}