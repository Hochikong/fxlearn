/*
* This file contains all function knowledge
* */

fun main(args: Array<String>) {
    println(add(1, 2))
    println(minus(3, 2))
    println(multiple(4,2))
    println(divide(10, 2))
    println(add(x=10.0, y=20.0))
    sb("SXC")
    println(desc(age=54))
    println(lambda())
    println(lambda2("cxk", 22))
    println(highOrderFunc("sxc", 23, lambda2))
    println(highOrderFunc2("hof2", 11, lambda2))
    println(count("snsnnsnwmfndf"))
    functionRef("www", ::sb1)  // 具名函数引用

    val funcs = highOrderFuncR() // 函数工厂
    funcs("wwpx")

    lambdaSideEffect()
    lambdaSideEffect()
    println(num)
}

var num = 0

// simple function
private fun add(x: Int, y: Int): Int{
    return x+y
}

// function override
private fun add(x: Double, y: Double): Double{
    return x+y
}

private fun minus(x: Int, y:Int): Int{
    return x-y
}

private fun multiple(x:Int, y:Int): Int{
    return x*y
}

private fun divide(x:Int, y:Int): Int{
    return x/y
}

// no return, use Unit type
private fun sb(name:String="cxk"): Unit{   // void
    println("$name is SB")
}

// with default value
private fun sb1(name: String="cxk"): String{
    return "$name is SB1"
}

// expression function style
private fun desc(age:Int) =
    when (age){
        in 80..100 -> "old"
        in 60..79 -> "little old"
        in 40..59 -> "middle"
        in 20..39 -> "young"
        in 0..19 -> "child"
        else -> "nmsl"
    }

var lambda = {val name="SB"        // auto inference  implicit return
    "nmsl $name"}

// explicit type(String and Int) and parameters(name and age)
var lambda2: (String, Int) -> String = {name, age -> "$name is $age years old"}

// explicit type but implicit return
var lambda3 = {name:String, age:Int -> "$name is $age years old"}

// simplest getLambda
private fun count(name: String): Int{
    return name.count { it == 'n'}  // equals to name.count({it == 'n'})
}

// use inline to save memory
private inline fun highOrderFunc2(name: String, age: Int, func: (String, Int) -> String): String{
    return func(name, age)
}

// use function as parameter
private fun highOrderFunc(name:String, age: Int, func: (String, Int) -> String): String{
    return func(name, age)
}

// function reference, instead of using getLambda, use fun as parameter
private fun functionRef(name:String, func: (String) -> String): Unit{
    println(func(name))
}

// function return function
private fun highOrderFuncR(): (String) -> Unit{
    return {
        name:String ->
        println("$name wcnm")
    }
}

var lambdaSideEffect = {num += 1}  // getLambda with side effect