import java.awt.Color
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    genGui()
}

private fun genGui() {
    val label = JLabel().apply {
        setSize(400, 100)
        horizontalAlignment = JLabel.CENTER
        isOpaque = true
        background = Color.GREEN
    }
    val cut = JMenuItem("Cut").apply { addActionListener { label.text = "Cut clicked" } }
    val copy = JMenuItem("Copy").apply { addActionListener { label.text = "copy clicked" } }
    val paste = JMenuItem("Paste").apply { addActionListener { label.text = "paste clicked" } }
    val popupmenu = JPopupMenu("Edit").apply {
        add(cut)
        add(copy)
        add(paste)
    }

    val frame = JFrame("popup menu demo").apply {
        add(label)
        add(popupmenu)
        setSize(400, 400)
        layout = null
        isVisible = true
    }

    frame.addMouseListener(
        object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupmenu.show(frame, e.x, e.y)
                }
            }
        }
    )
}