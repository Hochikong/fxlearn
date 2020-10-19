package coroutineTest

import kotlinx.coroutines.*

suspend fun main() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        repeat(100) { i ->
            println("Job sleeping $i")
            delay(500)
        }
    }
    delay(1300)
    println("Stop waiting")
    job.cancelAndJoin()
    println("End of this")
}