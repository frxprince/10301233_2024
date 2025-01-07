fun main(args:Array<String>){
 println(rectangleArea2(10.0,20.0))
 //printMyName()
 //rectangleArea(name="Brick", height = 200.0)
}
fun rectangleArea(width:Double=1.0,height:Double=1.0,
                  name:String="no name"){
println("$name width=$width height=$height area=${width*height}")
}

fun printMyName(name:String="Anonymous"){
   println("your name is $name")
}

fun myName()="Dr Paween"

fun rectangleArea2(width:Double=1.0,height:Double=1.0,
                  name:String="no name")=width*height
