import java.awt.BorderLayout
import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val jb = JButton("File")
    val tb = JToolBar().apply {
        isRollover = true
        add(jb)
        addSeparator()
        add(JButton("Edit"))
        add(JComboBox(arrayOf("OP1", "OP2", "OP3", "OP4")))
    }
    val frame = JFrame("Toolbar demo").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(450, 450)
    }
    val contentPane = frame.contentPane
    contentPane.add(tb, BorderLayout.NORTH)
    val ta = JTextArea("sdabdajsdakdakjdabjwbdwqbqkjdqb")
    val sp = JScrollPane(ta)
    contentPane.add(sp, BorderLayout.WEST)
    frame.isVisible = true
}