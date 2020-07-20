import java.io.File

/*
* This program contains demos of apply, let, run, with, alse and takeIf
* */



private fun applyDemo(){
    // apply return receiver
    val menuFile = File("menu.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(true)
    }

    /* Equals to code below
    *  val menuFile = File("menu.txt")
    *  menuFile.setReadable(true)
    *  ...
    *  menuFile.setExecutable(true)
    * */
}



// let can use `it` but apply can't
private fun letDemo(valx: Int):String{
    val value = listOf(2,3,4).first().let { it * it } // 4
    val sb = if (valx == 1) "sx" else null
    /* Equals to code below
    *  val value = listOf(2,3,4).first()
    *  val values = value * value
    * */

    // use let and elvis, return "it is not null" only sb is not null or "null warning"
    return sb?.let{"$it is not null"}?:"null warning!"
    // equals to code below
    /*
    val tmp = if (sb == null){
        "null warning"
    }else{
        "$sb is not null"
    }
    return tmp
    */
}



fun checkLength(cont: String): Boolean {
    return cont.length > 10
}

fun printStr(status: Boolean): Unit{
    println("str is $status")
}

// run is similar with apply but it not return receiver, only return lambda result, true or false
private fun runDemo(){
    // val menuFile = File("getDemo.txt")
    // val status = menuFile.run { readText().contains("something") }

    // use run to call methods
    val str = "sasddddddddw"
    val str1 = "sdd"
    str.run(::checkLength)
    str1.run(::checkLength).run(::printStr)
    // equals to code below
    /*checkLength(str)
    printStr(checkLength(str1))*/
}



// with is similar with run
// simple examples
/*
val nameTooLong:Boolean = with("xxxxxxxxxxxxxxxxxxxxxxxxxxx"){
    length >= 20
}*/



// also is similar with let, also return receiver but let return lambda result
// simple example
/*var file:List<String>
File("file.txt").also{
    print(it.name)
}.also{
    file = it.readLines()
}*/



// takeIf return receiver or null according by condition in lambda
val fileC = File("getDemo.txt").takeIf { it.canRead() && it.canWrite() }?.readText()
// equals to code below
/*
val getFileC = File("getDemo.txt")
val fc = if (getFileC.canRead() && getFileC.canWrite()){
    file.readText()
}else{
    null
}*/



// takeUnless means `unless condition can't be fulfill` then return a receiver