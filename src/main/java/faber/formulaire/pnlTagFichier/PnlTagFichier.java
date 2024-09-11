/*
 * Created by JFormDesigner on Tue Sep 10 13:20:11 CEST 2024
 */

package faber.formulaire.pnlTagFichier;

import javax.swing.*;
import faber.formulaire.pnlTagFichier.pnlListeCategorie.*;
import faber.main.Main;
import net.miginfocom.swing.*;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlTagFichier extends JPanel {

    public PnlTagFichier() {
        initComponents();
        createUIComponents();
    }

    private void createUIComponents() {
        PnlListeCategorie panel1 = new PnlListeCategorie(Main.collectionCategorie,this,0);
     //   add(panel1, "cell 1 0");
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[178,fill]",
            // rows
            "[]"));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
