package editorDemoByEventBus

import com.google.common.eventbus.EventBus
import ktmeta.editorDemoJava.KtTextEditorTips
import java.awt.event.KeyEvent
import javax.swing.AbstractListModel

class EditorTipsGuava(val data: Array<String>, val eb: EventBus) : KtTextEditorTips() {
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
            print(selectValue)
            this.isVisible = false
            if (!jList1.isSelectionEmpty) eb.post(FocusMsg(id, jList1.selectedValue))
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