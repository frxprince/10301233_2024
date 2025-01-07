fun main(args:Array<String>){
/*
 print("Hello World")
 println("Hello \\nCSMJU")
var a:String="Hello ABCD"
val b:String="XXXX"
var c="Hello"
var d=1234
    println(d::class.simpleName)
*/
//var a =readln().toFloat()
//var pi=3.14159274F
//var b= readln().toInt()
//var c=a+b
//println("the circle with radius $a has the area of ${(pi*a*a)}")

var s1= """
    Hello
        World
    """
println(args[1]  ) // < >  <=  >= == !=

var A= Array<String>(5,init={index->"MJU"})
A[0]="Hello"
A[1]="World"

println("${A[0]} ${A[1]} ${A[2]}")
}