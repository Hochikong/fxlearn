fun main() {
    val int:Int = 2147483647 // largest value
    val double:Double = 5.56666
    val s2i:Int = "2344".toInt()
    val s2d:Double? = "4.5".toDoubleOrNull()
    val s2d1:Double? = "".toDoubleOrNull()

    println("$int, $double, $s2i, $s2d, $s2d1")
}