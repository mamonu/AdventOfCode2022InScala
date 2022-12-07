import scala.util.matching.Regex
import scala.collection.mutable.ListBuffer

//notworkingyet
object day1
{

def main(args:Array[String]):Unit ={




// Read inputs from file
val input = scala.io.Source.fromFile("inputs/05-input.txt").getLines.mkString("\n")
val Array(stack, inst) = input.split("\n\n")

// Sort stack out
val stackRegex = new Regex("\\[|\\]")
val stackRegex2 = new Regex("(?<=\\w) ")
val stackCleaned = stackRegex.replaceAllIn(stack, "")
val stackCleaned2 = stackRegex2.replaceAllIn(stackCleaned, ",")
val stackLines = stackCleaned2.split("\n").reverse
val stackParsed = stackLines.map(_.split(",").filter(_.nonEmpty)).map(_.toList).to[ListBuffer]

// Parse instructions ([n, src, dst])
val instRegex = new Regex("\\d+")
val instParsed = inst.split("\n").map { line =>
  instRegex.findAllIn(line).map(_.toInt).toList
}

// Function to rearrange stacks
def rearrange(arrangement: ListBuffer[List[String]], instruction: List[Int], crane: Int = 9000): ListBuffer[List[String]] = {
  val List(n, src, dst) = instruction
  val srcStack = arrangement(src - 1)
  val dstStack = arrangement(dst - 1)
  if (crane == 9000) {
    arrangement(dst - 1) = dstStack ++ srcStack.slice(srcStack.length - n - 1, srcStack.length)
  } else if (crane == 9001) {
    arrangement(dst - 1) = dstStack ++ srcStack.slice(srcStack.length - n, srcStack.length)
  }
  arrangement(src - 1) = srcStack.slice(0, srcStack.length - n)
  arrangement
}

// Solution
val result = instParsed.foldLeft(stackParsed) { (acc, instruction) =>
  rearrange(acc, instruction, 9001)
}

println("Result: " + result.map(_.last).mkString)


}
}