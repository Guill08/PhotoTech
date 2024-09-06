/*
 * Created by JFormDesigner on Mon Jan 04 16:58:00 CET 2021
 */

package faber.formulaire.modele;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Guillaume SUPPIN
 */
public class FrmDialogue extends JDialog {
    public FrmDialogue(Window owner) {
        super(owner);
        initComponents();
    }



    public JButton getBtnFermer() {
        return btnFermer;
    }

    public void ajouterPanelPrincipal(JPanel pnlPrincipal){
        pnlMain.add(pnlPrincipal, BorderLayout.CENTER);
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

    public void setPnlMain(JPanel pnlMain) {
        this.pnlMain = pnlMain;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        pnlMain = new JPanel();
        pnlBarreBouton = new JPanel();
        btnFermer = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== pnlMain ========
            {
                pnlMain.setLayout(new BorderLayout());
            }
            dialogPane.add(pnlMain, BorderLayout.CENTER);

            //======== pnlBarreBouton ========
            {
                pnlBarreBouton.setBorder(new EmptyBorder(12, 0, 0, 0));
                pnlBarreBouton.setLayout(new MigLayout(
                    "insets 0,hidemode 3,gap 0 0",
                    // columns
                    "[grow,right]" +
                    "[80:n,fill]",
                    // rows
                    "0[fill]"));

                //---- btnFermer ----
                btnFermer.setText("Fermer");
                btnFermer.setMargin(new Insets(0, 0, 0, 0));
                btnFermer.setPreferredSize(new Dimension(72, 25));
                btnFermer.setMinimumSize(new Dimension(72, 25));
                btnFermer.setMaximumSize(new Dimension(72, 25));
                pnlBarreBouton.add(btnFermer, "cell 1 0,alignx right,growx 0");
            }
            dialogPane.add(pnlBarreBouton, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel pnlMain;
    private JPanel pnlBarreBouton;
    private JButton btnFermer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
