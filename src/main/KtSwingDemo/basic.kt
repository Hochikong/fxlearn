import javax.swing.*

fun main() {
    frameConstruct()
}

private fun frameConstruct(){
    val button = JButton("Click me").apply { setBounds(130, 100, 100, 40) }
    val frame = JFrame().apply {
        add(button)
        setSize(400, 500)
    }.let {
        it.layout = null
        it.isVisible = true
    }
}