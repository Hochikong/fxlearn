package editorDemoByEventBus

import ktmeta.editorDemoJava.KTTextEditorDemo2
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.awt.Dimension
import javax.swing.event.CaretEvent

class EditorDemo2 : KTTextEditorDemo2() {
    init {
        EventBus.getDefault().register(this)
    }


    override fun jTextArea1CaretUpdate(evt: CaretEvent?) {
        if (jTextArea1.text.isNotEmpty()) {
            val rectangle = jTextArea1.modelToView(jTextArea1.caretPosition)
            rectangle.y += 15
            val tips = EditorTips(arrayOf("ABC"))
            tips.bounds = rectangle
            tips.size = Dimension(200, 100)
            jTextArea1.add(tips)
            tips.setID("left")
            tips.focus()
        }
    }

    override fun jTextArea2CaretUpdate(evt: CaretEvent?) {
        if (jTextArea2.text.isNotEmpty()) {
            val rectangle = jTextArea2.modelToView(jTextArea2.caretPosition)
            rectangle.y += 15
            val tips = EditorTips(arrayOf("CDE"))
            tips.bounds = rectangle
            tips.size = Dimension(200, 100)
            jTextArea2.add(tips)
            tips.setID("right")
            tips.focus()
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun onEventReceive(msg: FocusMsg) {
        if (msg.id == "left") {
            jTextArea1.text = msg.message
            jTextArea1.requestFocus()
        }
        if (msg.id == "right") {
            jTextArea2.text = msg.message
            jTextArea2.requestFocus()
        }
    }
}

fun main() {
    val m = EditorDemo2()
    m.isVisible = true
}