
import scala.io.Source
import scala.collection.immutable._

//notworkingyet

object day4
{

def main(args:Array[String]):Unit ={
val inputFile = Source.fromFile("inputs/04-input.txt")


def part1(pairs: List[(Set[Int], Set[Int])]) : Int = {
  pairs.map(pair => if (pair._1.subsetOf(pair._2) || pair._2.subsetOf(pair._1)) 1 else 0).sum
}

def part2(pairs: List[(Set[Int], Set[Int])]) : Int = {
  pairs.map(pair => if (pair._1.intersect(pair._2).nonEmpty) 1 else 0).sum
}

def loadInput(inputText: String) : List[(Set[Int], Set[Int])] = {
  inputText.split("\n").toList.map(row =>
    row.split(",").map(col => {
      val numbers = col.split("-").map(_.toInt)
      Set(numbers:_*)
    }).toList
  ).map(row => (row(0), row(1)))
}



val pairs = loadInput(inputFile.mkString)


println(part1(pairs))
println(part2(pairs))



}
}