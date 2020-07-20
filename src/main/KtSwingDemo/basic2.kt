import javax.swing.*

fun createAndShowGui(){
    JFrame.setDefaultLookAndFeelDecorated(true)
    val frame = JFrame("HelloWorldSwing")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val label = JLabel("Hello World")
    frame.contentPane.add(label)
    frame.pack()
    frame.isVisible = true
}

private val swi = Runnable { createAndShowGui() }

fun main(args: Array<String>) {
    javax.swing.SwingUtilities.invokeLater(swi)
}