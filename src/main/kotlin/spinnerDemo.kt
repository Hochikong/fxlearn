import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val label = JLabel().apply {
        horizontalAlignment = JLabel.CENTER
        setSize(250, 100)
    }

    val spinner = SpinnerNumberModel(5, 0, 10, 1)
    val spin = JSpinner(spinner).apply {
        setBounds(100, 100, 50, 30)
        addChangeListener {
            label.text = "Value: $value"
        }
    }

    val frame = JFrame("Spinner Example").apply {
        add(spin)
        add(label)
        setSize(300, 300)
        layout = null
        isVisible = true
    }
}