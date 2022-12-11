import scala.util.matching.Regex
import scala.io.Source
import scala.collection.immutable._


object Day10 {

  def main(args: Array[String]): Unit = {



    def expand(s: String): List[String] = s match {
    case "noop" => List("noop")
    case x      => List("noop", x)
  }

  def xs(input: List[String]): List[Int] = {
    val expanded = input.flatMap(expand)


// Use the scanLeft method to apply a function to each element of the expanded list,
// starting with the initial value of 1. The function will return the current value
// of x unless the current string is "noop" or starts with "addx ", in which case
// it will return a new value for x based on the current string.


  expanded.scanLeft(1) {
  case (x, "noop") => x
  case (x, y) if y.startsWith("addx ") =>
    val regex: Regex = "addx (-?\\d+)".r
    val regex(yValue) = y
    x + yValue.toInt
}


  }

 def part1(input: List[String]): Int = {
  xs(input)
    .zipWithIndex
    .map{ case (x, index) => (x, index + 1) }
    .filter(_._2 % 40 == 20)
    .map{ case (x, cycle) => x * cycle }
    .sum
}


 def part2(input: List[String]): String ={
  val pixels = xs(input)
    .zipWithIndex
    .map { case (spritePos, pixel) =>
      if (Math.abs((pixel % 40) - spritePos) <= 1) '█' else ' '
    }
  pixels.grouped(40).map(_.mkString).mkString("\n")
}



val inputFile = Source.fromFile("inputs/10-input.txt").getLines.toList

println(part1(inputFile))
println(part2(inputFile))

  }

}


