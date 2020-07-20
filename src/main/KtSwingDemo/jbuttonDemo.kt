import javax.swing.*

private fun guiConstructor(){
    val textField = JTextField().apply {
        setBounds(50, 50, 150, 20)
    }
    val button = JButton("Click me").apply {
        setBounds(50, 100, 95, 30)
        addActionListener { textField.text = "Welcome to Swing" }
    }

    val frame = JFrame("Button Example").apply {
        setSize(400, 400)
        add(button)
        add(textField)
    }.let {
        it.layout = null
        it.isVisible = true
    }

}

fun main() {
    guiConstructor()
}