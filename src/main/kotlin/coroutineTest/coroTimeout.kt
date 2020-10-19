package coroutineTest

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() {
    runBlocking { getDBConnection() }
}

suspend fun getDBConnection() {
    withTimeout(1300) {
        repeat(1000) { i ->
            println("Im getting connection $i")
            delay(500)
        }
    }
}