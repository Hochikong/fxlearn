import java.lang.IllegalStateException

/*
* This program contains knowledge of exceptions
* */

private fun proficiencyCheck(swordJuggling: Int?){
    swordJuggling ?: throw IllegalStateException("Cannot juggle swords")
}

private fun proficiencyCheck1(swordJuggling: Int?){
    swordJuggling ?: throw MyOwnException("nmslcxk")
}

// user define exception
class MyOwnException(s: String) : IllegalStateException("nmsl")

private fun throwExceptionDemo(){
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if  (isJugglingProficient){
        swordJuggling = 2
    }
    proficiencyCheck1(swordJuggling)
    swordJuggling = swordJuggling!!.plus(1)
    println("You juggle $swordJuggling swords!")
}

private fun tryCatchDemo(){
    try {
        val tmp = (1..10).shuffled().last() == -1
        if (!tmp) {
            throw MyOwnException("getDemo")
        }
    }catch (e: MyOwnException) {
        println(e)
    }
}

fun main() {
    // randomly raises exception
    throwExceptionDemo()
    // try catch
    tryCatchDemo()
    // assert, you can use checkNotNull, require, requireNotNull, error, assert
    checkNotNull(null, {"fuck off"})
}