package coroutineTest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JProgressBar
import javax.swing.SwingWorker

fun main() {
    GenGui()
}

class GenGui {

    val jb = JProgressBar(0, 2000).apply {
        setBounds(40, 40, 160, 30)
        value = 0
        isStringPainted = true
    }

    val btn = JButton("Click Me").apply {
        setBounds(40, 90, 100, 30)
        addActionListener {
            CoroutineScope(Dispatchers.IO).launch {
                var index = 0
                while (index <= 2000) {
                    jb.value = index
                    index += 20
                    println(index)
                    delay(100)
                }
            }
        }
    }
    val frame = JFrame("progress bar demo").apply {
        add(jb)
        add(btn)
        setSize(250, 200)
        layout = null
        isVisible = true
    }


    fun iter(start: Int, end: Int) {
        val swWorker = object : SwingWorker<Int, Unit>() {
            override fun doInBackground(): Int {
                var index = start
                while (index <= end) {
                    jb.value = index
                    index += 20
                    println(index)
                    TimeUnit.MILLISECONDS.sleep(100)
                }
                return index
            }

            override fun done() {
                println("All done")
            }
        }

        swWorker.execute()
    }
}