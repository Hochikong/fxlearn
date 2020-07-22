import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPasswordField

object ToolTipExample {
    @JvmStatic
    fun main(args: Array<String>) {
        val f = JFrame("Password Field Example")
        //Creating PasswordField and label
        val value = JPasswordField()
        value.setBounds(100, 100, 100, 30)
        value.toolTipText = "Enter your Password"
        val l1 = JLabel("Password:")
        l1.setBounds(20, 100, 80, 30)
        //Adding components to frame
        f.add(value)
        f.add(l1)
        f.setSize(300, 300)
        f.layout = null
        f.isVisible = true
    }
}