import javax.swing.*

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    genGui()
}

private fun genGui(){
    val ta = JTextArea().apply {
        setBounds(5, 5, 360, 320)
    }

    val cut = JMenuItem("cut").apply { addActionListener { ta.cut() } }
    val copy = JMenuItem("copy").apply { addActionListener { ta.copy() } }
    val paste = JMenuItem("paste").apply { addActionListener { ta.paste() } }
    val selectAll = JMenuItem("selectAll").apply { addActionListener { ta.selectAll() } }

    val file = JMenu("Menu")
    val edit = JMenu("Edit").apply {
        add(cut)
        add(copy)
        add(paste)
        add(selectAll)
    }
    val help = JMenu("Help")
    val mb = JMenuBar().apply {
        add(file)
        add(edit)
        add(help)
    }

    val frame = JFrame("Menubar demo").apply {
        add(mb)
        add(ta)
        setSize(400 ,400)
        jMenuBar = mb
        layout = null
        isVisible = true
    }
}