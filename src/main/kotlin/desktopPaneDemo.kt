import java.awt.BorderLayout
import javax.swing.*
import com.formdev.flatlaf.FlatDarculaLaf

fun main() {
    FlatDarculaLaf.install()
    genGui()
}

private fun genGui() {
    val frame = JFrame("Desktop pane example").apply {
        setSize(300, 350)
        isVisible = true
    }
    val dp = CDP1()
    val cp = frame.contentPane.apply {
        add(dp, BorderLayout.CENTER)
    }
    dp.display(dp)
}

class CDP : JDesktopPane() {
    val numFrames = 3
    val xi = 30
    var yi = 30
    fun display(dp: CDP1) {
        for (i in 1..numFrames) {
            val jf = JInternalFrame("Internal Frame $i", true, true, true, true).apply {
                setBounds(xi, yi, 250, 85)
            }
            val c1 = jf.contentPane
            c1.add(JTextArea("EDIT ME"))
            dp.add(jf)
            jf.isVisible = true
            yi += 85
        }
    }
}

