
import scala.io.Source
import scala.collection.immutable._

//notworkingyet

object day3
{

def main(args:Array[String]):Unit ={
val inputFile = Source.fromFile("inputs/03-input.txt")

val POINTS = inputFile.mkString.trim.ascii_letters.map((m, n) => (m -> (n + 1))).toMap



def part1(rucksacks: List[String]): Int = {
  rucksacks.filter((r) => (d := r.length / 2) == d.toInt)
           .map((r) => next(iter(set(r.substring(0, d)) & set(r.substring(d)))))
           .map(POINTS(_))
           .sum
}





}
}