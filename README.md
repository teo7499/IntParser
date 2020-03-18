# Scala IntParser
Another challenge from my CTO. The purpose of this project was to test my understanding of Scala and recursion.

The only limitation for this script was to not use scala core library functions to determine whether an input is an Integer( e.g. .isInt())

You can run this programme if you have SBT to compile and build.

<b>Script Details</b>

Basically what I did was to use ASCII value of the input to determine whether it is an Int. Of course, I had to convert to a list of chars and check each char individually before putting it back altogether.

I moved through each element using recursion. This line takes the first element of the list and checks its ASCII value before storing the the value and running the function again to get the other elements in the list:

<blockquote>case c :: tail if c >= '0' && c <= '9' => parse(tail, total * 10 + (c - '0'))</blockquote>

Lastly this line checks if the input entered results in an overflow, if yes the function returns an "out of range" output:

<blockquote>case Nil => if (total<=Integer.MAX_VALUE) Right(total.toInt) else Left("Number out of range!")</blockquote>
