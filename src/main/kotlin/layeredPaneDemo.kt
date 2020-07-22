import java.awt.Color
import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val frame = JFrame("layered pane demo").apply {
        setSize(200, 200)
        isVisible = true
        layout = null
    }
    val lp = frame.layeredPane
    val top = JButton().apply {
        background = Color.WHITE
        setBounds(20, 20, 50, 50)
    }
    val middle = JButton().apply {
        background = Color.RED
        setBounds(40, 40, 50, 50)
    }
    val bottom = JButton().apply {
        background = Color.CYAN
        setBounds(60, 60, 50, 50)
    }
    lp.add(bottom, 1)
    lp.add(middle, 2)
    lp.add(top, 3)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}