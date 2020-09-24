import bibliothek.gui.dock.common.CControl
import java.awt.Color
import java.awt.GridLayout
import javax.swing.JFrame
import bibliothek.gui.dock.common.CLocation
import bibliothek.gui.dock.common.DefaultSingleCDockable
import bibliothek.gui.dock.common.SingleCDockable
import javax.swing.JPanel

fun create(title: String, color: Color): SingleCDockable {
    val panel = JPanel().apply {
        isOpaque = true
        background = color
    }
    return DefaultSingleCDockable(title, title, panel)
}

fun genGUI() {
    val frame = JFrame().apply { defaultCloseOperation = JFrame.EXIT_ON_CLOSE }
    val control = CControl(frame)
    frame.layout = GridLayout(1, 1)
    frame.add(control.contentArea)

    val red = create("Red", Color.RED)
    val green = create("Green", Color.GREEN)
    val blue = create("Blue", Color.BLUE)

    control.addDockable(red)
    control.addDockable(green)
    control.addDockable(blue)

    red.isVisible = true

    green.setLocation(CLocation.base().normalSouth(0.4))
    green.isVisible = true

    blue.setLocation(CLocation.base().normalEast(0.3))
    blue.isVisible = true

    frame.setBounds(20, 20, 400, 400)
    frame.isVisible = true
}

fun main() {
    genGUI()
}
