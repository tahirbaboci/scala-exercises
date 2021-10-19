package NarcissisticNumber

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class NarcissisticNumberSpec extends AnyFreeSpec with Matchers {


  "Sample" in {
    assert(NarcissisticNumber.narcissistic(7))
    assert(NarcissisticNumber.narcissistic(371))
    assert(!NarcissisticNumber.narcissistic(122))
    assert(!NarcissisticNumber.narcissistic(4887))
  }
}
