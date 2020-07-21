import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode

fun main() {
    JFrame.setDefaultLookAndFeelDecorated(true)
    genGui()
}

private fun genGui() {
    val style = DefaultMutableTreeNode("Style")

    val styleSub = listOf("color", "font").map { DefaultMutableTreeNode(it) }
    listOf("red", "blue", "black", "green").map { DefaultMutableTreeNode(it) }.map { styleSub[0].add(it) }
    styleSub.map { style.add(it) }

    val tree = JTree(style)
    val frame = JFrame("Tree demo").apply {
        add(tree)
        setSize(200, 200)
        isVisible = true
    }
}