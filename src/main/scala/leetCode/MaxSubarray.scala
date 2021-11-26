package leetCode

object MaxSubarray extends App{
  def maxSubArray(nums: Array[Int]): Int = {
      val allPositive = nums.toList.forall(_<0)
      if(allPositive){
        nums.sum
      }else {
        findIt(nums.toList, 0, 0)
      }
  }
  println(maxSubArray(Array(5,4,-1,7,8)))

  def findIt(nums: List[Int], maxAcc: Int, sum: Int): Int = {
    nums match {
      case Nil => maxAcc
      case h::tail if sum < 0 =>
            findIt(tail, maxAcc, 0+h)
      case h::tail =>
        if(maxAcc > sum+h) {
          findIt(tail, maxAcc, sum + h)
        } else {
          findIt(tail, sum+h, sum + h)
        }

    }
  }
}
