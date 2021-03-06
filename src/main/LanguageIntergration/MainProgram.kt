import javax.swing.UIManager
import com.formdev.flatlaf.FlatLightLaf
import com.formdev.flatlaf.FlatDarculaLaf
import java.awt.event.ActionEvent
import javax.swing.JFrame

class MainFrame : MyForm(){
    var withEOF:Boolean = false
    val EOF = "\n"
    override fun EOFCheckBoxActionPerformed(evt: ActionEvent?) {
        withEOF = EOFCheckBox.isSelected
    }

    override fun ResetBTNActionPerformed(evt: ActionEvent?) {
        InputArea.text = ""
        OutputArea.text = ""
    }

    override fun SummitBTNActionPerformed(evt: ActionEvent?) {
        if (withEOF){
            OutputArea.text = "${OutputArea.text} $EOF${InputArea.text} $EOF"
        }else{
            OutputArea.text = "${OutputArea.text} ${InputArea.text}"
        }
        InputArea.text = ""
    }
}


fun main() {
    try {
        for (info in UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus" == info.name) {
                UIManager.setLookAndFeel(info.className)
                break
            }
        }
    } catch (e: Exception) {
        FlatLightLaf.install()
    }
    // FlatLightLaf.install()
    // FlatDarculaLaf.install()
    val c = MainFrame()
    c.isVisible = true
}