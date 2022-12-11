import scala.io.Source
import scala.collection.immutable.{Seq, List}
import scala.util.matching.Regex

// :grimace:  

object day4
{
  def main(args:Array[String]):Unit ={
    val inputFile = Source.fromFile("inputs/04-input.txt").getLines().to[scala.collection.immutable.Seq]

def parse(input: String): (Seq[Int], Seq[Int]) = {
    val pattern = "([0-9]+)-([0-9]+)"
    val regex = new Regex(pattern)
    val (first, second) = regex.findAllMatchIn(input).map { m =>
      m.group(1).toInt to m.group(2).toInt
    }.toList match {
      case first :: second :: Nil => (first, second)
      case _ => throw new IllegalArgumentException("Invalid input format")
    }
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
