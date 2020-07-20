import java.awt.event.MouseEvent

class MainFrameTDM(data: Array<Array<String>>) : TableDemo(data){
    override fun MainTableMouseClicked(evt: MouseEvent?) {
        println("Data you selected is ${MainTable.getValueAt(MainTable.selectedRow, MainTable.selectedColumn)}")
    }
}

fun main() {
    val rows = listOf(arrayOf("101", "Amit", "670000"),
            arrayOf("102", "Jai", "780000"),
            arrayOf("101", "Sachin", "700000"))
    val data = rows.toTypedArray()
    val f = MainFrameTDM(data)
    f.initComponents()
    f.isVisible = true
}