import scala.io._
import scala.collection.immutable.Set

object day6
{

def main(args:Array[String]):Unit ={


val aoc = io.Source.fromFile("inputs/06-input.txt").getLines.mkString

def getDistinctCharactersIndex(datastream: String, distinctnumber: Int): Int = {
    var distinctCharactersIndex = -1
    for (i <- 0 until datastream.length) {
        if (datastream.substring(i, i + distinctnumber).toSet.size == distinctnumber) {
            distinctCharactersIndex = i + distinctnumber
            return distinctCharactersIndex
        }
    }
    return distinctCharactersIndex
}

def funcgetDistinctCharactersIndex(datastream: String, distinctnumber: Int): Int = {
    val distinctCharactersIndex = (0 until datastream.length).find { i =>
        datastream.substring(i, i + distinctnumber).toSet.size == distinctnumber
    }.map { i => i + distinctnumber }.getOrElse(-1)
    return distinctCharactersIndex
}




println(getDistinctCharactersIndex(aoc,4))
println(getDistinctCharactersIndex(aoc,14))

println(funcgetDistinctCharactersIndex(aoc,4))
println(funcgetDistinctCharactersIndex(aoc,14))




}
}
