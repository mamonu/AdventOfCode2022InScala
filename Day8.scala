import scala.io.Source
import scala.collection.immutable._
import scala.util.matching.Regex


object day8 {

  def main(args: Array[String]): Unit = {


 

val inputFile = Source.fromFile("inputs/08-input.txt").getLines().toList


println(part1(inputFile))
println(part2(inputFile))


    
}
}