import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val ta = JTextArea(200, 200)
    val p1 = JPanel().apply {
        add(ta)
    }
    val p2 = JPanel()
    val p3 = JPanel()
    val tp = JTabbedPane().apply {
        setBounds(50, 50, 400, 200)
        add("main", p1)
        add("visit", p2)
        add("help", p3)
    }
    val btn = JButton("Click me").apply {
        setBounds(50, 300, 100, 50)
        addActionListener {
            tp.add("new pane", JPanel())
        }
    }

    val frame = JFrame("Tab pane demo").apply {
        add(tp)
        add(btn)
        setSize(400, 400)
        layout = null
        isVisible = true
    }
}