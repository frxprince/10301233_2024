var S:String?=null
fun main(args:Array<String>){
// ? nullable , ?: Elvis operator , !! Bypass
 S="Hello World"
 println("The length is ${S?.length?:"No data"}")
println(S!!)
    /*
  if(S!=null) {
      println("The length is ${S?.length}")
  }else{
      println("No data ")
  }
  */

}