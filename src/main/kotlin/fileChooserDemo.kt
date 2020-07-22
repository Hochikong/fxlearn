import java.io.File
import javax.swing.*
import com.formdev.flatlaf.FlatDarculaLaf
import java.awt.Font
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.text.Charsets.UTF_8


fun main() {
    FlatDarculaLaf.install()
    genGui()
}

private fun genGui() {
    val open = JMenuItem("Open File").apply {
    }
    val file = JMenu("File").apply {
        add(open)
    }
    val mb = JMenuBar().apply {
        setBounds(0, 0, 800, 20)
        add(file)
    }
    val ta = JTextArea(800, 800).apply {
        font = Font("宋体", Font.BOLD, 14)
        setBounds(0, 20, 800, 800)
    }
    val frame = JFrame("file chooser demo").apply {
        add(mb)
        add(ta)
        setSize(500, 500)
        layout = null
        isVisible = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
    open.addActionListener {
        val fc = JFileChooser().apply {
            currentDirectory = File("D:\\")
            fileSelectionMode = JFileChooser.FILES_ONLY
            fileFilter = FileNameExtensionFilter("Plain text txt", "txt")
            addChoosableFileFilter(FileNameExtensionFilter("YAML yml", "yml"))
            addChoosableFileFilter(FileNameExtensionFilter("JSON json", "json"))
        }
        val i = fc.showOpenDialog(frame)
        if (i == JFileChooser.APPROVE_OPTION) {
            val f = fc.selectedFile
            val path = f.path
            var text = ""
            File(path).forEachLine {
                text += "$it\n"
                ta.text = text
            }
        }
    }
}