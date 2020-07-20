/*
* This program is a showcase of parameters type, when, if else, range, string formatting
* */
import java.lang.Math.pow

fun main(args: Array<String>) {
    val health = -1;
    val status = when {
        health > 70 -> "Good"
        health in 51..69 -> "Normal"  // contains 51 and 69
        health in 31..50 -> "Weak"
        health in 0..30 -> "Bad"
        else -> "UNKNOWN"
    }

    val blessed = true
    val buffs = if (blessed) "Blessed" else "Nothing"

    var totalStrength = 0
    totalStrength = if (buffs == "Blessed"){
        pow(100.0, 2.0).toInt()
    }else{
        pow(100.0, 0.5).toInt()
    }

    println("Your status is ${if (status != "UNKNOWN") status else "not known"}")
    println("Your buffs is $buffs")
    println("Your strength is $totalStrength")
}