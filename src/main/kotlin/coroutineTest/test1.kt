package coroutineTest

import kotlin.coroutines.*

fun main() {
    val continuation = suspend {
        println("In coroutine")
        5
    }.createCoroutine(object : Continuation<Int> {
        override fun resumeWith(result: Result<Int>) {
            println("Coroutine End: $result")
        }

        override val context: CoroutineContext = EmptyCoroutineContext
    })
    // create but launch by myself
    continuation.resume(Unit)

    // launch coroutine immediately
    suspend {
        println("In coroutine 2")
        "cxk"
    }.startCoroutine(object : Continuation<String> {
        override fun resumeWith(result: Result<String>) {
            println("Coroutine End $result")
        }

        override val context: CoroutineContext
            get() = EmptyCoroutineContext
    })
}