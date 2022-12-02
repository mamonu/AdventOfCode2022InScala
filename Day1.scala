import scala.io.Source

object day1
{

def main(args:Array[String]):Unit ={

val inputFile = Source.fromFile("inputs/01-input.txt")
val cals = inputFile.getLines().filter(_.nonEmpty).map(_.split("\n")).filter(_.nonEmpty).map(_.map(_.toInt))
val totalCals = cals.map(_.sum)

// Q1
println(totalCals.max)

// Q2
println(totalCals.toList.sorted(Ordering[Int].reverse).take(3).sum)
    }
}