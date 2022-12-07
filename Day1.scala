import scala.io.Source
import scala.collection.immutable._


object day1
{

def main(args:Array[String]):Unit ={
val inputFile = Source.fromFile("inputs/01-input.txt")

def loadInput(inputText: String): List[List[Int]] = {
  inputText.split("\n\n").map(_.split("\n").map(_.toInt).toList).toList
}


def part1(cals: List[List[Int]]): Int = {
  cals.map(c => c.sum).max
}

def part2(cals: List[List[Int]]): Int = {
  cals.map(c => c.sum).sorted.takeRight(3).sum
}

val cals = loadInput(inputFile.mkString.trim)

println(part1(cals))
println(part2(cals))

    }
}