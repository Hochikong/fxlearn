import java.awt.BorderLayout
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*

fun main() {
    genGui()
}

private fun genGui() {
    val path = "C:\\Users\\ckhoi\\IdeaProjects\\fxlearn\\src\\main\\resources\\girl2.jpg"
    val img = ImageIO.read(File(path))
    val rawHeight = img.height
    val rawWidth = img.width
    val newHeight = 500
    val newWidth = (rawWidth.toDouble() / rawHeight.toDouble()) * newHeight
    println("$rawWidth $rawHeight")
    val l = JLabel().apply {
        icon =
            ImageIcon(ImageIcon(img).image.getScaledInstance(newWidth.toInt(), newHeight, java.awt.Image.SCALE_SMOOTH))
    }
//    val sp = JScrollPane().apply {
//        horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
//        verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
//        viewport.add(l, null)
//    }
    val frame = JFrame("image demo").apply {
        setSize(400, 400)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
    frame.contentPane.add(l, BorderLayout.CENTER)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}