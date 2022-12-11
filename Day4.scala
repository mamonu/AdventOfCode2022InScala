import scala.io.Source
import scala.collection.immutable.{Seq, List}

// Not yet working :grimace:

object day4
{
  def main(args:Array[String]):Unit ={
    val inputFile = Source.fromFile("inputs/04-input.txt").getLines().to[scala.collection.immutable.Seq]

def parse(input: String): (Seq[Int], Seq[Int]) = {
  val first = input.split(',').toList.map {
    case s"${lo}-${hi}" => lo.toInt to hi.toInt
  }.head
  val second = input.split(',').toList.map {
    case s"${lo}-${hi}" => lo.toInt to hi.toInt
  }.tail.head
  (first, second)
}

    def part1(input: Seq[String]): Int = input
      .map(parse)
      .count(x => x._1.containsSlice(x._2) || x._2.containsSlice(x._1))

    def part2(input: Seq[String]): Int = input
      .map(parse)
      .count(x => x._1.intersect(x._2).nonEmpty)

    println(part1(inputFile))
    println(part2(inputFile))
  }
}
