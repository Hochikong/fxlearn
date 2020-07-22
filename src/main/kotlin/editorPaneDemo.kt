import javax.swing.JEditorPane
import javax.swing.JFrame

private fun genGui() {
    val mf = JFrame("jeditor pane demo").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(400, 400)
    }
    val mp = JEditorPane()
    mp.contentType = "text/python"
    mp.text = """
        def run(x,y):
            print(x+y)
    """.trimIndent()
    mf.contentPane = mp
    mf.isVisible = true
}

fun main() {
    genGui()
}

