import javax.swing.*

private fun genGui(){
    val label = JLabel()
    label.horizontalAlignment = JLabel.CENTER
    label.setSize(400, 100)

    val languages = listOf<String>("C", "C++", "C#", "Java", "PHP")
    val comboBox = JComboBox(languages.toTypedArray()).apply {
        setBounds(50, 100, 90, 20)
    }

    val btn = JButton("Show").apply {
        setBounds(200, 100, 75, 20)
        addActionListener {
            label.text = "Programming language Selected: ${comboBox.getItemAt(comboBox.selectedIndex)}"
        }
    }

    val frame = JFrame("ComboBox Example").apply {
        add(comboBox)
        add(label)
        add(btn)
        setSize(350, 350)
    }.let {
        it.layout = null
        it.isVisible = true
    }

}

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    genGui()
}