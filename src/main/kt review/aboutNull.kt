/*
* This file contains knowledge about null
* Usually all parameters' value in kotlin can't be null
* User can't call a function on a object or parameter which can be null unless you handle by yourself
* */

fun main(args: Array<String>) {
//    THE CODE BELOW is wrong, you can't assign a null value to a String type
//    var signaturedDrink = "Ale"
//    signaturedDrink = null

//    THE CODE BELOW is wrong, readLine() may return a string or null
//    var beverage = readLine().capitalize()
    print("Enter choose: ")
    val sb = readLine()
    val choose = if (sb.isNullOrBlank()) null else "not null"
//    val choose = if (sb.isNullOrBlank()) "not null" else null

    // use Safe Calls ?.  when readline return null, it will skip the capitalize()
    var beverage:String? = readLine()?.capitalize()
    println("B0 $beverage")

    var beverage1:String? = readLine()?.let {
        if (it.isNotBlank()) it.capitalize() else "Buttered Ale"
    }
    println("B1 $beverage1")

    // use non-null assert !!.
    // if readline return null, it will throw exception
    //var beverage2 = choose!!.capitalize()
    //println("B2 $beverage2")

    // use elvis ?:   if choose is null, use String instead
    val replace = choose ?: "not null 2"
    println(replace)
}
