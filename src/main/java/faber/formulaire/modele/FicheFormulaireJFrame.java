/*
 * Created by JFormDesigner on Thu Feb 11 13:46:33 CET 2021
 */

package faber.formulaire.modele;

import faber.main.Main;
import faber.tool.alerte.Boite;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Guillaume SUPPIN
 */
public class FicheFormulaireJFrame extends JFrame {
    public FicheFormulaireJFrame() {
        initComponents();
        btnFermer.setIcon(Main.getIconFermer());
        btnEnregistrer.setIcon(Main.getIconSave());
        this.setIconImage(Main.getIconApplication().getImage());
    }

    public JButton getBtnFermer() {
        return btnFermer;
    }

    public JButton getBtnEnregistrer() {
        return btnEnregistrer;
    }
    public void verifierEtatBoutonEnregistrerAvantFermeture(){
        boolean boutonEnregistrerActiver =this.getBtnEnregistrer().isEnabled();
        boolean boutonEnregistrerVisible =this.getBtnEnregistrer().isVisible();
        if(boutonEnregistrerVisible) {
            if (boutonEnregistrerActiver) {
                int valeurBoite = Boite.afficherBoiteDialogue("Confirmation", "Souhaitez-vous fermer cette offre sans enregistrer les modifications ?", JOptionPane.YES_NO_OPTION);
                switch (valeurBoite) {
                    case 0:
                        fermerFormulaire();
                        break;
                }
            } else {
                fermerFormulaire();
            }
        } else {
            fermerFormulaire();
        }

    }
    public void fermerFormulaire(){

        this.dispose();

    }
    protected void ajouterPanelPrincipal(JPanel pnlPrincipal){
        pnlMain.add(pnlPrincipal, BorderLayout.CENTER);
    }
    protected void ajouterPanelPrincipal(JTabbedPane pnlPrincipal){
        pnlMain.add(pnlPrincipal, BorderLayout.CENTER);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        pnlMain = new JPanel();
        pnlPiedFormulaire = new JPanel();
        btnFermer = new JButton();
        btnEnregistrer = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== pnlMain ========
        {
            pnlMain.setMinimumSize(new Dimension(800, 600));
            pnlMain.setPreferredSize(new Dimension(800, 600));
            pnlMain.setLayout(new BorderLayout());

            //======== pnlPiedFormulaire ========
            {
                pnlPiedFormulaire.setLayout(new MigLayout(
                    "insets 0,hidemode 3",
                    // columns
                    "[0,fill]" +
                    "[285,fill]rel" +
                    "[grow,fill]" +
                    "[0,fill]",
                    // rows
                    "rel[30,grow,fill]" +
                    "[0]"));

                //---- btnFermer ----
                btnFermer.setText("Fermer");
                btnFermer.setIcon(new ImageIcon(getClass().getResource("/png/close.png")));
                btnFermer.setMaximumSize(new Dimension(100, 30));
                btnFermer.setMinimumSize(new Dimension(100, 30));
                btnFermer.setPreferredSize(new Dimension(100, 30));
                pnlPiedFormulaire.add(btnFermer, "cell 1 0,growx");

                //---- btnEnregistrer ----
                btnEnregistrer.setText("Enregistrer");
                btnEnregistrer.setIcon(new ImageIcon(getClass().getResource("/png/save.png")));
                btnEnregistrer.setMaximumSize(new Dimension(120, 30));
                btnEnregistrer.setMinimumSize(new Dimension(120, 30));
                btnEnregistrer.setPreferredSize(new Dimension(120, 30));
                pnlPiedFormulaire.add(btnEnregistrer, "cell 2 0,alignx right,growx 0");
            }
            pnlMain.add(pnlPiedFormulaire, BorderLayout.SOUTH);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    public JPanel getPnlMain() {
        return pnlMain;
    }

    public JPanel getPnlPiedFormulaire() {
        return pnlPiedFormulaire;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    protected JPanel pnlMain;
    protected JPanel pnlPiedFormulaire;
    protected JButton btnFermer;
    protected JButton btnEnregistrer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
