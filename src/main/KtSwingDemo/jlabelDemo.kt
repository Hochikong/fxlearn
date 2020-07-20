import javax.swing.*
import com.formdev.flatlaf.FlatIntelliJLaf

private fun guiGen(){
    FlatIntelliJLaf.install()
    val defaultUrl = "www.baidu.com"
    val l1 = JTextField().apply { setBounds(50, 50, 150, 30) }
    val l2 = JLabel("Second Label").apply { setBounds(50, 100, 400, 30) }

    val button = JButton("Click me").apply {
        setBounds(50, 160, 95, 30)

        addActionListener {
            val address = l1.text?.let { if (it.length < 3) defaultUrl else it } ?: defaultUrl
            val ip = java.net.InetAddress.getByName(address).hostAddress
            l2.text = "IP of $address is: $ip"
        }

    }

    val frame = JFrame("Label Example").apply {
        add(l1)
        add(l2)
        add(button)
        setSize(700, 300)
    }.let {
        it.layout = null
        it.isVisible = true
    }
}

fun main() {
    guiGen()
}