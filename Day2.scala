import scala.io.Source
import scala.collection.immutable._
import scala.math.abs

//notworkingyet


object day2
{

def main(args:Array[String]):Unit ={

val inputFile = Source.fromFile("inputs/05-input.txt").getLines().toList

def score1(moves: List[Char]): List[Int] = moves.mkString match {
  case "A X" => List(3, 1)
  case "A Y" => List(6, 2)
  case "A Z" => List(0, 3)
  case "B X" => List(0, 1)
  case "B Y" => List(3, 2)
  case "B Z" => List(6, 3)
  case "C X" => List(6, 1)
  case "C Y" => List(0, 2)
  case "C Z" => List(3, 3)
  case _ => throw new Exception("Unknown input " + moves)

}




def score2(moves: List[String]): List[Int] = moves match {
  case x :: "X" :: Nil =>
    x match {
      case "A" => List(0 + 3)
      case "B" => List(0 + 1)
      case "C" => List(0 + 2)
    }
  case x :: "Y" :: Nil =>
    x match {
      case "A" => List(3 + 1)
      case "B" => List(3 + 2)
      case "C" => List(3 + 3)
    }
  case x :: "Z" :: Nil =>
    x match {
      case "A" => List(6 + 2)
      case "B" => List(6 + 3)
      case "C" => List(6 + 1)
    }
  case _ => throw new Exception("Unknown input " + moves)
}


def part1(input: List[String]): Int =
  input.map(score1).flatten.map(_.toInt).sum


def part2(input: List[String]): Int =
  input.map(score2).flatten.map(_.toInt).sum






  
 println(part1(inputFile))
 println(part2(inputFile))


}}


