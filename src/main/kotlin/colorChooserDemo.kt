import java.awt.Color
import javax.swing.*

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    genGui()
}

private fun genGui() {
    val ta = JTextArea().apply { setBounds(10, 10, 300, 200) }
    val frame = JFrame("Color chooser demo").apply {
        add(ta)
        layout = null
        setSize(400, 400)
        isVisible = true
    }
    val b = JButton("Pad color").apply {
        setBounds(200, 250, 100, 30)
        addActionListener {
            val color = JColorChooser.showDialog(frame, "Choose", Color.CYAN)
            ta.background = color
        }
    }
    frame.add(b)
}