package editorDemoByEventBus

import ktmeta.editorDemoJava.KtTextEditorDemo
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.awt.Dimension
import javax.swing.event.CaretEvent

class EditorDemo : KtTextEditorDemo() {
    init {
        EventBus.getDefault().register(this)
    }

    private val tips = EditorTips(arrayOf("ABC"))

    override fun KtjTextArea1CaretUpdate(evt: CaretEvent?) {
        if (jTextArea1.text.isNotEmpty()) {
            val rectangle = jTextArea1.modelToView(jTextArea1.caretPosition)
            rectangle.y += 15
            tips.bounds = rectangle
            tips.size = Dimension(200, 100)
            jTextArea1.add(tips)
            tips.focus()
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun onEventReceive(msg: FocusMsg) {
        jTextArea1.text = msg.message
        jTextArea1.requestFocus()
        tips.isVisible = false
    }
}

fun main() {
    val m = EditorDemo()
    m.isVisible = true
}