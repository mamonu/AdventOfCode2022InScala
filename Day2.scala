import scala.io.Source
import scala.collection.immutable.Seq
import scala.math.abs

//notworkingyet


object day2
{

def main(args:Array[String]):Unit ={


val inputFile = Source.fromFile("inputs/02-input.txt").getLines().to[scala.collection.immutable.Seq]


def part1(input: Seq[String]): Int = {
  val scoresA = Seq("B X", "C Y", "A Z", "A X", "B Y", "C Z", "C X", "A Y", "B Z")
    .zipWithIndex
    .map { case (k, v) => k -> (v + 1) }
    .toMap
  input.foldLeft(0) { (sum, key) => sum + scoresA(key) }
}


def part2(input: Seq[String]): Int = {
  val scoresB = Seq("B X", "C X", "A X", "A Y", "B Y", "C Y", "C Z", "A Z", "B Z")
    .zipWithIndex
    .map { case (k, v) => k -> (v + 1) }
    .toMap
  input.foldLeft(0) { (sum, key) => sum + scoresB(key) }
}



 println(part1(inputFile))
 println(part2(inputFile))


}}


