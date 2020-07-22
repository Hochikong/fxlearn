import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.*
import javax.swing.border.LineBorder

fun main() {
    genGui()
}

private fun genGui() {
    val l = JLabel("Label").apply { preferredSize = Dimension(1000, 1000) }
    val ta = JTextArea()
    val sp = JScrollPane(l).apply {
        horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        viewportBorder = LineBorder(Color.RED)
        viewport.add(ta, null)
    }
    val frame = JFrame().apply {
        add(sp, BorderLayout.CENTER)
        setSize(200, 150)
        isVisible = true
    }
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}