fun main(args:Array<String>) {

    /*    repeat(10){
     i-> print("X${i+1} ")
 }
 */
    /*
do {
var input= readLine()
}while(input!="password")
println("Loged in")

    var input= readLine()
    while(input!="password"){
        input= readLine()
        if(input=="")continue
            println(" Error")
            println("##################")
    }
    println("Loged in")
*/
    /*for(i in 0..20 step 2)print(" $i")
for(i in 20 downTo  0 step 2)print(" $i")
    println()
for(i in 0 until 20)print(" $i")
*/
iloop@    for (i in 1..5) {
jloop@        for (j in 1..6) {
      if(i>=5)break@iloop
            print("($i,$j) ")
        }
        println()
    }
}