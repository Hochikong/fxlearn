package coroutineTest

import kotlinx.coroutines.*

suspend fun main() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var nextPrintTime = System.currentTimeMillis()
        var i = 0
        while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300)
    println("Stop waiting")
    job.cancelAndJoin()
    println("End of this")
}