package quiz

import org.scalacheck._
import org.scalacheck.Prop.forAll

class PieRandomSpec extends Properties("pie random") {
  val CountGen = Gen.choose(1, 10000)
  property("select") = forAll(CountGen, CountGen) { (a: Int, b: Int) =>
    val random = new PieRandom(Apple ->a, Orange -> b)
    val results = (1 to 10000).map(_ => random.select())
    val appleHits = results.count(_ == Apple)
    val orangeHits = results.count(_ == Orange)
    val actualRate = (appleHits * 1.0 / results.size)
    val expectRate = a * 1.0 / (a + b)
    math.abs(actualRate - expectRate) < 0.1
  }
}
