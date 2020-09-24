import com.formdev.flatlaf.FlatDarculaLaf
import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*

class MainFrame(val enterColor: Color, val exitColor: Color) : TabPane() {
    override fun CloseAllTabsActionPerformed(evt: ActionEvent?) {
        jTabbedPane1.removeAll()
    }

    override fun CreateNewTabActionPerformed(evt: ActionEvent?) {
        val panel = JPanel().apply {
            isOpaque = false
        }
        jTabbedPane1.add(panel)
        jTabbedPane1.setTabComponentAt(
            jTabbedPane1.indexOfComponent(panel),
            getPanel(jTabbedPane1, panel, "new Tab", enterColor, exitColor)
        )
    }
}

fun getPanel(tabbedPane: JTabbedPane, panel: JPanel, title: String, colorenter: Color, colorexit: Color): JPanel {
    val titlePanel = JPanel().apply {
        isOpaque = false
    }
    val titleL = JLabel(title).apply {
        border = BorderFactory.createEmptyBorder(0, 0, 0, 5)
    }
    titlePanel.add(titleL)
    val closebtn = JButton("\uD83D\uDDD9").apply {
        background = colorexit
        border = BorderFactory.createEmptyBorder(2, 2, 2, 2)
    }

    closebtn.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            tabbedPane.remove(panel)
        }

        override fun mouseEntered(e: MouseEvent?) {
            closebtn.background = colorenter
        }

        override fun mouseExited(e: MouseEvent?) {
            closebtn.background = colorexit
        }
    })

    titlePanel.add(closebtn)
    return titlePanel
}

private fun useStyle(styleName: String): String {
    if (styleName == "Nimbus") {
        for (info in UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus" == info.name) {
                UIManager.setLookAndFeel(info.className)
                break
            }
        }
    }
    if (styleName == "Darcula") {
        FlatDarculaLaf.install()
    }
    return styleName
}

fun main() {
    val backgroundExitDarcula = Color(60, 63, 65)
    val backgroundEnterDarcula = Color(78, 82, 84)
    val backgroundExitNimbus = Color(244, 245, 247)
    val backgroundEnterNimbus = Color(167, 188, 207)
    val style = "Darcula"
    val main: MainFrame
    useStyle(style)
    when (style) {
        "Nimbus" -> {
            main = MainFrame(backgroundEnterNimbus, backgroundExitNimbus)
        }
        "Darcula" -> {
            main = MainFrame(backgroundEnterDarcula, backgroundExitDarcula)
        }
        else -> {
            main = MainFrame(backgroundEnterDarcula, backgroundExitDarcula)
        }
    }
    main.initComponents()
    main.isVisible = true
}
