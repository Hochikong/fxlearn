package editorDemoByEventBus

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ktmeta.editorDemoJava.KTTextEditorDemo2
import ktmeta.editorDemoJava.KtTextEditorTips
import org.greenrobot.eventbus.EventBus
import java.awt.Dimension
import java.awt.event.KeyEvent
import javax.swing.AbstractListModel
import javax.swing.event.CaretEvent

class EditorDemoCoroutine : KTTextEditorDemo2() {
    init {
        EventBus.getDefault().register(this)
    }


    override fun jTextArea1CaretUpdate(evt: CaretEvent?) {
        if (jTextArea1.text.isNotEmpty()) {
            val rectangle = jTextArea1.modelToView(jTextArea1.caretPosition)
            rectangle.y += 15
            CoroutineScope(Dispatchers.IO).launch {
                val tips = EditorTipsCoroutine(arrayOf("ABC"))
                tips.bounds = rectangle
                tips.size = Dimension(200, 100)
                jTextArea1.add(tips)
                tips.setID("left")
                tips.focus()
            }
        }
    }

    override fun jTextArea2CaretUpdate(evt: CaretEvent?) {
        if (jTextArea2.text.isNotEmpty()) {
            val rectangle = jTextArea2.modelToView(jTextArea2.caretPosition)
            rectangle.y += 15
            CoroutineScope(Dispatchers.IO).launch {
                val tips = EditorTipsCoroutine(arrayOf("CDE"))
                tips.bounds = rectangle
                tips.size = Dimension(200, 100)
                jTextArea2.add(tips)
                tips.setID("right")
                tips.focus()
            }
        }
    }

    inner class EditorTipsCoroutine(val data: Array<String>) : KtTextEditorTips() {
        init {
            jList1.model = object : AbstractListModel<String>() {
                override fun getSize(): Int {
                    return data.size
                }

                override fun getElementAt(index: Int): String {
                    return data[index]
                }
            }
        }

        override fun KtjList1KeyReleased(evt: KeyEvent?) {
            if (evt?.keyCode == KeyEvent.VK_ENTER) {
                print("Hit enter")
                if (!jList1.isSelectionEmpty) onEventReceive(FocusMsg(id, jList1.selectedValue))
                this.id = ""
                print(selectValue)
                this.isVisible = false
            }
        }

        fun focus() {
            jList1.requestFocus()
        }

        private var id: String = ""
        fun setID(id: String) {
            this.id = id
        }
    }

    fun onEventReceive(msg: FocusMsg) {
        if (msg.id == "left") {
            jTextArea1.text = jTextArea1.text + "\n" + msg.message
            jTextArea1.requestFocus()
        }
        if (msg.id == "right") {
            jTextArea2.text = jTextArea2.text + "\n" + msg.message
            jTextArea2.requestFocus()
        }
    }
}

fun main() {
    val m = EditorDemo2()
    m.isVisible = true
}