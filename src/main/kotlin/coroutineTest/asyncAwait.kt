package coroutineTest

import kotlinx.coroutines.*

fun main() {
    val scope = MainScope()
    val job = scope.launch(Dispatchers.IO) {
        val def = async {
            delay(500)
            "cxk"
        }
        println(def.await())
    }
    println("Skip me")
    println(job.isCompleted)
    println("My name is")
}