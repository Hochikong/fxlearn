fun main() {
    // all extensions are static methods in java

    val userName = "Jack"
    println(userName.addHello())
    // subclass can access
    userName.easyPrint()
    // generic type extension
    println("extension .....")
    userName.easyPrint2().addHello().easyPrint()
    println()
    val shit3 = "shit you shit him sdad lwwe; dsf shit"
    println(shit3.countShit)
    println()
    val nullableStr: String? = null
    nullableStr printWithDefault "this is default content"
}


// String is receiver
// use extent function to avoid inherit
fun String.addHello() = "Hello $this"
val String.countShit
    get() = count {"s".contains(it)}
fun Any.easyPrint() = println(this)

fun <T> T.easyPrint2(): T{
    println(this)
    return this
}

// extension on nullable type
infix fun String?.printWithDefault(default: String) = println(this ?: default)


// about `apply`
/*inline fun <T> T.apply(block: T.() -> Unit): T{
    block()
    return this
}*/
