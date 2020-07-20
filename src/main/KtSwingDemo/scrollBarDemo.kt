import javax.swing.*

fun main() {
    genGui()
}

private fun genGui(){
    val label = JLabel().apply {
        horizontalAlignment = JLabel.CENTER
        setSize(400, 100)
    }

    val scrollBar = JScrollBar().apply {
        setBounds(100, 100, 50, 110)
        addAdjustmentListener {
            label.text = "Vertical Scollbar value is: ${this.value}"
        }
    }

    val frame = JFrame("ScrollBar example").apply {
        add(label)
        add(scrollBar)
        setSize(400, 400)
        layout = null
        isVisible = true
    }

}