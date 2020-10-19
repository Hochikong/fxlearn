package coroutineTest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    CoroutineScope(Dispatchers.IO).launch {
        println("ID: ${Thread.currentThread().id}")
    }
    println("Main id: ${Thread.currentThread().id}")
    delay(2000)
}