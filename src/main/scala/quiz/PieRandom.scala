package quiz

sealed trait Fruit

case object Apple extends Fruit
case object Orange extends Fruit

class PieRandom(counts: (Fruit, Int)*) {
  def select(): Fruit = ???
}
