import java.awt.event.ActionEvent
import javax.swing.*
import com.formdev.flatlaf.FlatIntelliJLaf

class MainFrame : Test2() {
    override fun CreateNewTabActionPerformed(evt: ActionEvent?) {
        val panel = JPanel().apply {
            isOpaque = false
        }
        jTabbedPane1.add(panel)
        jTabbedPane1.setTabComponentAt(
            jTabbedPane1.indexOfComponent(panel),
            getTitlePanel(jTabbedPane1, panel, "new Tab")
        )
    }
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

fun main() {
    FlatIntelliJLaf.install()
    val main = MainFrame()
    main.initComponents()
    main.isVisible = true
}
