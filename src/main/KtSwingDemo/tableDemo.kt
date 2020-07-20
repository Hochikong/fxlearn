import javax.swing.*

fun main(){
    genGui()
}

private fun genGui(){
    val rows = listOf(arrayOf("101", "Amit", "670000"),
            arrayOf("102", "Jai", "780000"),
            arrayOf("101", "Sachin", "700000"))
    val data = rows.toTypedArray()
    val column = arrayOf("ID", "NAME", "SALARY")
    val dataTable = JTable(data, column).apply {
        columnSelectionAllowed = true
    }

    val select = dataTable.selectionModel.apply {
        selectionMode = ListSelectionModel.SINGLE_SELECTION
        addListSelectionListener {
            val row = dataTable.selectedRow
            val col = dataTable.selectedColumn
            val data = dataTable.getValueAt(row, col)
            println("$data")
        }
    }


    val sp = JScrollPane(dataTable)
    val frame = JFrame("Table Example").apply {
        add(sp)
        setSize(300, 200)
        isVisible = true
    }


}