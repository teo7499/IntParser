import junrong.intparser
import junrong.intparser.IntParser
import org.scalatest.FunSuite


class Test_IntParser extends FunSuite{

  test("parse 0"){
    assert(IntParser.parse("0") === Right(0))
  }

  test("parse 1"){
    assert(IntParser.parse("1") === Right(1))
  }

  test("parse 2"){
    assert(IntParser.parse("2") === Right(2))
  }

  test("parse 10"){
    assert(IntParser.parse("10") === Right(10))
  }

  test("Parse 101"){
    assert(IntParser.parse("101") === Right(101))
  }

  test("parse abc") {
    assert(IntParser.parse("abc") === Left ("Non Number inputted"))
  }

  test("parse 1bc"){
    assert(IntParser.parse("1bc") === Left("Non Number inputted"))
  }

  test("parse -101") {
    assert(IntParser.parse("-101") === Right(-101))
  }

  test("parse -10-1") {
    assert(IntParser.parse("-10-1") === Left("Non Number inputted"))
  }
  //test to check overflow
  test("parse max int"){
    assert(IntParser.parse("2147483647") === Right (2147483647))
  }

  test("parse max int+1"){
    assert(IntParser.parse("2147483648") === Left ("Number out of range!"))
  }

  //test to check overflow detection for extremely large numbers
  test("parse 9999999999"){
    assert(IntParser.parse("9999999999") === Left ("Number out of range!"))
  }

}