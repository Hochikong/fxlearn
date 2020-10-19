package editorDemoByEventBus

import ktmeta.editorDemoJava.KtTextEditorTips
import org.greenrobot.eventbus.EventBus
import java.awt.event.KeyEvent
import javax.swing.AbstractListModel

class EditorTips(val data: Array<String>) : KtTextEditorTips() {
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
            if (!jList1.isSelectionEmpty) EventBus.getDefault().post(FocusMsg(id, jList1.selectedValue))
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

class FocusMsg(val id: String, val message: String)