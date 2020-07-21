import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val slider = JSlider(JSlider.HORIZONTAL, 0, 50, 25).apply {
        minorTickSpacing = 2
        majorTickSpacing = 10
        paintTicks = true
        paintLabels = true
    }

    val panel = JPanel().apply {
        add(slider)
    }

    val frame = JFrame("Slider demo").apply {
        add(panel)
    }
    frame.pack()
    frame.isVisible = true
}