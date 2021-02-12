package editorDemoByEventBus

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import ktmeta.editorDemoJava.KTTextEditorDemo2
import java.awt.Dimension
import javax.swing.event.CaretEvent

class EditorDemoGuava(private val eb: EventBus) : KTTextEditorDemo2() {

    override fun jTextArea1CaretUpdate(evt: CaretEvent?) {
        if (jTextArea1.text.isNotEmpty()) {
            val rectangle = jTextArea1.modelToView(jTextArea1.caretPosition)
            rectangle.y += 15
            val tips = EditorTipsGuava(arrayOf("ABC"), eb)
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
            val tips = EditorTipsGuava(arrayOf("CDE"), eb)
            tips.bounds = rectangle
            tips.size = Dimension(200, 100)
            jTextArea2.add(tips)
            tips.setID("right")
            tips.focus()
        }
    }

    @Subscribe
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
    val eventBus = EventBus()
    val m = EditorDemoGuava(eventBus)
    eventBus.register(m)
    m.isVisible = true
}