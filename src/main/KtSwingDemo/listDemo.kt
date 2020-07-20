import javax.swing.*

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    guiGen()
}

private fun guiGen(){
    val label = JLabel().apply {
        setSize(500, 100)
    }
    val contents1 = listOf<String>("C", "C++", "Java", "PHP")
    val contents2 = listOf<String>("Arduino", "STM32", "Spring", "SB")
    val listShow = JList<String>(contents1.toTypedArray()).apply { setBounds(100, 100, 75, 75) }
    val listShow2 = JList<String>(contents2.toTypedArray()).apply { setBounds(100, 200, 75, 75) }
    val btn = JButton("Show").apply {
        setBounds(200, 150, 80, 30)
        addActionListener {
            var t1:String = ""
            var t2:String = ""
            if (listShow.selectedIndex != -1){
                t1 = "Language is ${listShow.selectedValue}"
            }
            if (listShow2.selectedIndex != -1){
                t2 = "Framework is ${listShow2.selectedValue}"
            }
            label.text = "$t1   $t2"
        }
    }
    val frame = JFrame("List demo").apply {
        add(listShow)
        add(listShow2)
        add(btn)
        add(label)
        setSize(450, 450)
        layout = null
        isVisible = true
    }

}