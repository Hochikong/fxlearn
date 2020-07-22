import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val tbtn = JToggleButton("Click me").apply { setBounds(40, 200, 100, 50) }

    val label = JLabel().apply {
        setBounds(40, 30, 200, 60)
        text = "initial"
    }

    val frame = JFrame("toggle btn demo").apply {
        setSize(400, 400)
        add(tbtn)
        add(label)
        layout = null
        isVisible = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    tbtn.addActionListener {
        if (tbtn.isSelected) {
            label.text = "You select this"
        } else {
            label.text = "Nothing"
        }
    }
}