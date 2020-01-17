package junrong.intparser

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object IntParser {

  def main(args: Array[String]): Unit = {

    val myInt = readLine("Input: ")
    parse(myInt) match{
      case Right(myInt) => println(s"Got int $myInt")
      case Left(error) => println(s"Got error $error")
    }

  }

  def parse(s: String): Either[String, Int] = {
    //check if number is negative. Drops the negative sign once to prevent Non-number error
    if (s.toList.headOption == Some('-')) {
      parse(s.toList.drop(1), 0) match {
        //Minus total from 0 to convert to negative int
        case Right(total) => Right(0 - total)
        case _ => Left("Non Number inputted")
      }
    }
    else parse(s.toList, 0)
  }

  @tailrec
  def parse(list: List[Char], total: Long): Either[String, Int] = {
    list match {
      case Nil => if (total<=Integer.MAX_VALUE) Right(total.toInt) else Left("Number out of range!")
      case c :: tail if c >= '0' && c <= '9' => parse(tail, total * 10 + (c - '0'))
      case _ => Left("Non Number inputted")
    }
  }
}
