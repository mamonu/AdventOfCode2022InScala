import scala.io.Source

object day1
{

def main(args:Array[String]):Unit ={

val inputFile = Source.fromFile("inputs/01-input.txt")
val cals = inputFile.getLines().map(_.split("\n")).map(_.map(_.toInt))
val totalCals = cals.map(_.sum)

// Q1
println(totalCals.max)

// Q2
println(totalCals.sorted(Ordering[Int].reverse).take(3).sum)
    }
}