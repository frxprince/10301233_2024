fun main(args:Array<String>){
    println(sum(1,2))
val A= listOf<Int>(1,2,3,4,5,6,4,4,5,2,1)
PrintA(A,{k-> println("From param $k")})
}

fun PrintA(X:List<Int>,action:(Int)->Unit){
 for (i in X){
     println(i)
     action(i)
 }
}
val sum:(Int,Int)->Int={a:Int,b:Int-> a+b}

/*
fun sum(x:Int,y:Int):Int{
  return x+y
}
*/