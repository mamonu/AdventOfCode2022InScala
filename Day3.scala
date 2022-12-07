
import scala.io.Source
import scala.collection.immutable._
import scala.io.Codec
import scala.collection.immutable.HashSet


object day3
{

def main(args:Array[String]):Unit ={


val inputFile = Source.fromFile("inputs/03-input.txt")

def priority(c: Char): Int = {
  if (c.isLower) {
    c.toInt - 'a' + 1
  } else {
    c.toInt - 'A' + 27
  }
}


val rucksacks: Vector[String] = inputFile.getLines.toVector
  .map(_.trim)
  .flatMap(_.split('\n'))


val part1Result = rucksacks
  .map(rucksack => {
    val l = rucksack.length
    val compartment1 = rucksack.substring(0, l / 2)
    val compartment2 = rucksack.substring(l / 2, l)
    compartment1.intersect(compartment2).headOption.getOrElse('!')
  })
  .map(priority)
  .sum



val part2Result = rucksacks
  .sliding(3, 3)
  .map(triplet => {
    val rucksack1 = triplet(0)
    val rucksack2 = triplet(1)
    val rucksack3 = triplet(2)
    rucksack1.intersect(rucksack2).filter(rucksack3.contains(_)).headOption.getOrElse('!')
  })
  .map(priority _) 
  .sum


println(s"Part 1: $part1Result")
println(s"Part 2: $part2Result")





}
}