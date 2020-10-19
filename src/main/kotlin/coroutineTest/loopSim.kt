package coroutineTest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // blocking()
    coroutineV()
}

fun coroutineV() {
    var i = 0;
    while (true) {
        println("Assume this is a main thread like EDT in swing but with coroutine") // line 16
        CoroutineScope(Dispatchers.Default).launch {   // line 17
            // cost time work
            delay(5000)
            println("Exit coroutine")
        }
        // when the code run at line 16, then 17 will be suspend (run on others thread) and directly run the line 23
        println("current in coroutine $i \n")  // line 23
        i += 1
    }
}

fun blocking() {
    var i = 0;
    while (true) {
        println("Assume this is a main thread like EDT in swing")
        println("Block the main thread")
        // assume time cost work
        Thread.sleep(5000)
        println("No block anymore")

        println("current $i \n")
        i += 1
    }
}