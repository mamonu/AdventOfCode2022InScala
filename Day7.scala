import scala.io.Source
import scala.collection.immutable._
import scala.util.matching.Regex


object day7 {

  def main(args: Array[String]): Unit = {


  type Dir = List[String]
  type Size = Int

  val cdDir = """\$ cd (\S+)""".r
  val cdUp  = """\$ cd \.\.""".r
  val file  = """(\d+) (\S+)""".r

  def parse(pwd: Dir, input: List[String]): Iterator[(Dir, Size)] = {
    if (input.isEmpty) {
      Iterator.empty
    } else {
      input.head match {
        case cdUp()           => parse(pwd.tail, input.tail)
        case cdDir(dir)       => parse(dir :: pwd, input.tail)
        case file(size, name) => pwd.tails.map((_, size.toInt)) ++ parse(pwd, input.tail)
        case _                => parse(pwd, input.tail)
      }
    }
  }


def part1(input: List[String]): Int = {
  val sizes = parse(Nil, input).toSeq
    .groupBy(_._1)
    .mapValues(_.map(_._2).sum)
  sizes.values.filter(_ <= 100000).sum
}

def part2(input: List[String]): Int = {
  val sizes = parse(Nil, input).toSeq
    .groupBy(_._1)
    .mapValues(_.map(_._2).sum)
  val usedSpace = sizes(Nil)
  val needToFree = 30000000 - (70000000 - usedSpace)
  sizes.values.filter(_ >= needToFree).min
}

val inputFile = Source.fromFile("inputs/07-input.txt").getLines().toList


println(part1(inputFile))
println(part2(inputFile))


    
}
}