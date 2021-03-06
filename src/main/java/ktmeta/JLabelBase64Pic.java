package ktmeta;

import com.formdev.flatlaf.FlatIntelliJLaf;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JFileChooser.FILES_ONLY;

/**
 * @author ckhoi
 */
public class JLabelBase64Pic extends javax.swing.JFrame {

    /**
     * Creates new form JLabelBase64Pic
     */
    public JLabelBase64Pic() {
        initComponents();
        this.chooser = new JFileChooser();
        this.chooser.setFileSelectionMode(FILES_ONLY);
        this.chooser.setAcceptAllFileFilterUsed(false);
        this.chooser.addChoosableFileFilter(new FileTypeFilter(".png", "PNG"));
        this.chooser.addChoosableFileFilter(new FileTypeFilter(".jpg", "JPEG"));
        this.setLocationRelativeTo(null);
        this.preview = new JLabelBase64PicDialog(this, "Enlarge Preview", true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        LoadPic = new javax.swing.JButton();
        Enlarge = new javax.swing.JButton();
        Show = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoadPic.setText("Load Pic");
        LoadPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadPicActionPerformed(evt);
            }
        });

        Enlarge.setText("Enlarge Pic");
        Enlarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnlargeActionPerformed(evt);
            }
        });

        Show.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ShowComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(LoadPic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Enlarge)
                                .addContainerGap(446, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LoadPic)
                                        .addComponent(Enlarge))
                                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>

    private void LoadPicActionPerformed(java.awt.event.ActionEvent evt) {
        int returnValue = this.chooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File fi = this.chooser.getSelectedFile();
                System.out.println("File is: " + fi.getName());
                byte[] imgContent = FileUtils.readFileToByteArray(fi);
                this.encodedString = Base64.getEncoder().encodeToString(imgContent);

                ByteArrayInputStream inputStream = new ByteArrayInputStream(imgContent);
                BufferedImage bufImage = ImageIO.read(inputStream);
                Image dimg = bufImage.getScaledInstance(this.Show.getWidth(), this.Show.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dimg);

                this.Show.setIcon(icon);

            } catch (IOException ex) {
                Logger.getLogger(JLabelBase64Pic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ShowComponentResized(java.awt.event.ComponentEvent evt) {
        if (this.encodedString != null) {
            try {
                byte[] decodedBytes = Base64.getDecoder().decode(this.encodedString);
                ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
                BufferedImage bufImage = ImageIO.read(inputStream);
                Image dimg = bufImage.getScaledInstance(this.Show.getWidth(), this.Show.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dimg);
                this.Show.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(JLabelBase64Pic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void EnlargeActionPerformed(ActionEvent evt) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(this.encodedString);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
            BufferedImage bufImage = ImageIO.read(inputStream);
            ImageIcon icon = new ImageIcon(bufImage);
            this.preview.displayPreview(icon);
            this.preview.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JLabelBase64Pic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatIntelliJLaf.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JLabelBase64Pic().setVisible(true);
            }
        });
    }

    private JFileChooser chooser;
    private String encodedString;
    private JLabelBase64PicDialog preview;


    // Variables declaration - do not modify
    private javax.swing.JButton Enlarge;
    private javax.swing.JButton LoadPic;
    private javax.swing.JLabel Show;
    // End of variables declaration
}

class FileTypeFilter extends FileFilter {
    private String extension;
    private String description;

    public FileTypeFilter(String extension, String desc) {
        this.extension = extension;
        this.description = desc;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        return f.getName().toLowerCase().endsWith(extension);
    }

    @Override
    public String getDescription() {
        return description + String.format(" (*%s)", extension);
    }
}
