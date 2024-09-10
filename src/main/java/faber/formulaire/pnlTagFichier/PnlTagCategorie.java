/*
 * Created by JFormDesigner on Tue Sep 10 13:20:11 CEST 2024
 */

package faber.formulaire.pnlTagFichier;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlTagCategorie extends JPanel {
    public PnlTagCategorie() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
        label3 = new JLabel();
        comboBox3 = new JComboBox();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[178,fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("text");
        add(label1, "cell 0 0");
        add(comboBox1, "cell 1 0");

        //---- label2 ----
        label2.setText("text");
        add(label2, "cell 0 1");
        add(comboBox2, "cell 1 1");

        //---- label3 ----
        label3.setText("text");
        add(label3, "cell 0 2");
        add(comboBox3, "cell 1 2");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JLabel label3;
    private JComboBox comboBox3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
