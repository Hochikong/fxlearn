package coroutineTest

import kotlinx.coroutines.*

fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        coroWrapper()
    }
    println("End of main")
    Thread.sleep(6000)
}

fun getName(): String = "${Thread.currentThread().id}"

suspend fun coroWrapper() {
    val job = CoroutineScope(Dispatchers.Default).async {
        delay(5000)
        // getName's return as return value of job
        getName()
    }
    println(job.await())
}