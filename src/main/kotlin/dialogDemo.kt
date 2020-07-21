import java.awt.FlowLayout
import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val ta = JTextArea().apply {
        setBounds(40, 100, 20, 20)
        setSize(100, 30)
    }
    val btn = JButton("Click Me").apply {
        setBounds(40, 300, 100, 40)
    }
    val label = JLabel().apply {
        setBounds(200, 300, 100, 40)
    }
    val frame = JFrame("Dialog").apply {
        setSize(500, 500)
        add(btn)
        add(label)
        layout = null
        isVisible = true
    }
    val dialog = JDialog(frame, "Dialog Example", true).apply {
        setSize(300, 300)
        layout = null
    }
    val btn2 = JButton("ok").apply {
        setBounds(40, 50, 30, 40)
        setSize(50, 30)
        addActionListener {
            dialog.isVisible = false
            label.text = ta.text
            ta.text = ""
        }
    }
    btn.addActionListener {
        dialog.isVisible = true
    }
    dialog.add(btn2)
    dialog.add(ta)
}