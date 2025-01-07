import kotlin.math.PI

fun main(args:Array<String>){
//val line1=Line(width=123.0)
//val line2=Line(width=5678.0)
//line2.printWidth()
// line1.printWidth()
//val square1=Square(3.0)
//square1.printWidth() ; square1.Area()
//val rectangle=Rectangle(3.0,5.0)
//rectangle.printWidth();rectangle.printHeight();rectangle.Area()
//val circle=Circle(2.0)
//circle.printWidth();circle.printRadius();circle.Area()
/*val diamond=AnyShape(2.0,3.0)
diamond.printWidth();diamond.printHeight()
diamond.Area(object:AreaforAnyShape{
    override fun Area(width: Double, height: Double) {
        println("Area= ${width*height*0.5}")
    }
})
  */
 val diamonshape=AnyShapeLambda(2.0,6.0)
 diamonshape.printHeight();diamonshape.printWidth()
 diamonshape.Area({w,h->print("The area of diamon is ${w*h*0.5}")})
}
class AnyShapeLambda(var w:Double,var h:Double):Rectangle(w,h){
    fun Area(area:(w:Double,h:Double)->Unit){
        area(w,h)
    }
}


class AnyShape(var w:Double,var h:Double):Rectangle(w,h){
    init{ println("The AnyShape Object is initiating") }
    fun Area(area:AreaforAnyShape){
       area.Area(width,height)
    }
}
interface AreaforAnyShape{
    fun Area(width:Double,height:Double){}
}
class Circle(var CircleWidth:Double=0.0):Square(CircleWidth){
    init{ println("The Circle Object is initiating") }
    fun printRadius(){println("Radius= ${width/2} ") }
override fun Area(){println("Area= ${ PI * (width/2)*(width/2)}")}
}
open class Rectangle(var rectangleWidth:Double,var height:Double=0.0):
    Square(rectangleWidth){
    init{ println("The Rectangle Object is initiating") }
    fun printHeight(){println("Height=$height")}
   override fun Area(){ println("Area = ${width*height}") }
}
open class Square(var squareWidth:Double=0.0):Line(squareWidth){
 init{ println("The Square Object is initiating") }
  open fun Area(){
     println("Area = ${width*width}")
    }
}

open class Line(var width:Double=0.0){
    init {
    println("The Line Object is initiating")
    }
    fun printWidth(){
        println("Width=$width")
    }
}
