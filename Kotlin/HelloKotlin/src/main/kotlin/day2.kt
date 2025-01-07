fun main(args:Array<String>){
/*
    var A = Array<Int>(10, init = {i-> i+1})
   // A.set(3,8)
    print("Hello World ${A[3]}")
var B = arrayOfNulls<String>(10)
B[0]="Hello"
  println(B[0])
var C=arrayOf("cs","mju","hello","world")
println(C[0])
for( (i,c) in C.withIndex()) {
    println("data at $i is $c")
}


 var L= listOf("Hello","World")
var L2= mutableListOf("Hello","World")
L2.add(1,"CSMJU")
 for (l in L2){println(l)}
var S= mutableSetOf("a","b","c","d","a")
    for (l in S){print("$l ")}
var M= mapOf(Pair("th","Thailand"),Pair("en","English")
,Pair("jp","Japan"))
  println(M["th"])

var input= readLine()
var alphabet= mutableSetOf<Char>()
for (c in input!!.toCharArray()){alphabet.add(c)}
 println(alphabet.sorted())
*/
/*var F=100
if(F>100)println("Yes")
if(F>100)println("Yes") else println("No")
*/
var score=49
/*var grade=""
if(score>=80) grade="A"
else if(score>=70) grade="B"
else if(score>=60) grade="C"
else if(score>=50) grade="D"
else grade="F"
*/
    /*
var grade=    if(score>=80)"A" else if(score>=70) "B"
    else if(score>=60) "C" else if(score>=50) "D"
    else "F"

var status=if (score>=50)"Pass!!" else "Fail!!"
 println("$score $grade  $status")
*/
var ln="en"
var language=when(ln){
  "th"->{println("Thailand");"Thailand"}
  "en"-> {println("English");"English"}
  "cn"-> {println("China");"China"}
   else->{ println("I don't know");"Unknown"}
    }
println("return $language")


}

