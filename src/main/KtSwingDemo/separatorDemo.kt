import java.awt.GridLayout
import javax.swing.*

fun main() {
    genGui()
}

private fun genGui(){
    val l1 = JLabel("Above separator")
    val sep = JSeparator()
    val l2 = JLabel("Below separator")
    val frame = JFrame().apply {
        add(l1)
        add(sep)
        add(l2)
        setSize(400, 100)
        isVisible = true
        layout = GridLayout(0, 1)
    }
}