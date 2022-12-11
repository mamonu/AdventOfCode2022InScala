import scala.util.matching.Regex
import scala.collection.mutable.ListBuffer
import scala.collection.Seq
import scala.io.Source
import scala.collection.immutable._


object day5 {

def main(args:Array[String]):Unit ={


val inputFile = Source.fromFile("inputs/05-input.txt").mkString

val move = """move (\d+) from (\d+) to (\d+)""".r

def stacks(input: String): Map[Int, List[Char]] = {
  val lines = input.split("\n").toList.takeWhile(_.contains("["))
  val transposed = Seq(lines: _*).transpose.filter(_.exists(x => x >= 'A' && x <= 'Z'))
  val filtered = transposed.map(_.filter(_ != ' '))
  val zipped = filtered.zipWithIndex
  val mapped = zipped.map { case (stack: List[Char], index) => (index + 1, stack) }
  mapped.toList.toMap
}

def moves(input: String): Array[String] =
  input.split("\n").dropWhile(!_.contains("move"))

def endStacks(input: String, reverse: Boolean): Map[Int, List[Char]] = {
  val initial = stacks(input)
  moves(input).foldLeft(initial) {
    case (stacks, move(count, from, to)) =>
      val fromStack = stacks(from.toInt)
      val toStack = stacks(to.toInt)
      val moved = fromStack.take(count.toInt)
      val newFrom = fromStack.drop(count.toInt)
      val newTo = if (reverse) moved.reverse ++ toStack else moved ++ toStack
      stacks + (from.toInt -> newFrom) + (to.toInt -> newTo)
  }
}


def part1(input: String): String = {
  val stacks = endStacks(input, true)
  stacks.toList.sortBy(_._1).map(_._2.head).mkString
}

def part2(input: String): String = {
  val stacks = endStacks(input, false)
  stacks.toList.sortBy(_._1).map(_._2.head).mkString
}

 println(part1(inputFile))
 println(part2(inputFile))

}
}