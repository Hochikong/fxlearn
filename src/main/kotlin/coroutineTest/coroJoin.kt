package coroutineTest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking(Dispatchers.IO) {
        val job1 = launch {
            for (i in 0..10) {
                println("normal launch $i ${Thread.currentThread().name} ####")
                delay(100)
            }
        }

        val job2 = launch {
            for (i in 0..10) {
                println("normal launch $i ${Thread.currentThread().name} ----")
                delay(100)
            }
        }

        // just like Thread.join()
        job1.join()
        job2.join()

        println("all job done")
    }
}