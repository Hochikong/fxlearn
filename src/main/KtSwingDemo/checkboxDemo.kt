import javax.swing.*

fun main() {
    guiGen()
}

private fun guiGen(){
    val rb1 = JRadioButton("Male").apply {
        setBounds(100, 50, 100, 30)
    }
    val rb2 = JRadioButton("Female").apply {
        setBounds(100, 100, 100, 30)
    }
    val btnGroup = ButtonGroup().apply {
        add(rb1)
        add(rb2)
    }
    val btn = JButton("Click").apply{
        setBounds(100, 150, 80, 30)
        addActionListener {
            if (rb1.isSelected){
                JOptionPane.showMessageDialog(this, "You are Male.")
            }
            if (rb2.isSelected){
                JOptionPane.showMessageDialog(this, "You are Female.")
            }
        }
    }

    val frame = JFrame("RadioDemo").apply {
        add(rb1)
        add(rb2)
        add(btn)
        setSize(300, 300)
    }.let {
        it.layout = null
        it.isVisible = true
    }

}