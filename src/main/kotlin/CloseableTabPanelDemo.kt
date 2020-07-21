import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*

fun main() {
    genGui()
}

fun getTitlePanel(tabbedPane: JTabbedPane, panel: JPanel, title: String): JPanel {
    val titlePanel = JPanel().apply {
        isOpaque = false
    }
    val titleL = JLabel(title).apply {
        border = BorderFactory.createEmptyBorder(0, 0, 0, 5)
    }
    titlePanel.add(titleL)
    val closebtn = JButton("x").apply {

        addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                tabbedPane.remove(panel)
            }
        })
    }
    titlePanel.add(closebtn)
    return titlePanel
}

private fun genGui() {
    val frame = JFrame("Demo").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
    val tabp = JTabbedPane()

//    for (ind in 1..4){
//        val ta = JTextArea(200, 200)
//        val pane = JPanel().apply {
//            isOpaque = false
//            add(ta)
//        }
//        tabp.setTabComponentAt(
//            tabp.indexOfComponent(pane),
//            getTitlePanel(tabp, pane, ind.toString())
//        )
//    }

    val panel = JPanel().apply { add(JTextArea(30, 50)) }
    panel.isOpaque = false
    tabp.add(panel)
    tabp.setTabComponentAt(
        tabp.indexOfComponent(panel),
        getTitlePanel(tabp, panel, "sb")
    )

    frame.add(tabp)
    frame.pack()
    frame.isVisible = true
}