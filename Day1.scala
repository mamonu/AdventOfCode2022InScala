import scala.io.Source

val inputFile = Source.fromFile("inputs/01-input.txt")
val cals = inputFile.getLines().map(_.split("\n")).map(_.map(_.toInt))
val totalCals = cals.map(_.sum)

// Q1
totalCals.max

// Q2
totalCals.sorted(Ordering[Int].reverse).take(3).sum
