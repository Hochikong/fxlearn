import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

fun main() {
    // genGui()
    OPE()
}

private fun genGui(){
    val frame = JFrame("OptionPane Demo")
//    JOptionPane.showMessageDialog(frame, "Hello Welcome")
//    JOptionPane.showMessageDialog(frame, "Something Warning", "Alert", JOptionPane.WARNING_MESSAGE)
//    JOptionPane.showMessageDialog(frame, "Warning", "Info", JOptionPane.QUESTION_MESSAGE)
    JOptionPane.showInputDialog(frame, "Enter your name", "Name")
}

class OPE internal constructor(): WindowAdapter(){
    var f = JFrame("Main")
    init {
        f.addWindowListener(this)
        f.setSize(300, 300)
        f.layout = null
        f.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        f.isVisible = true
    }

    override fun windowClosing(e: WindowEvent?) {
        val a = JOptionPane.showConfirmDialog(f, "Are you sure?")
        if (a == JOptionPane.YES_OPTION){
            f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        }
    }
}
