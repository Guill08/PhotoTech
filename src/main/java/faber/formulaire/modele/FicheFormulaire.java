/*
 * Created by JFormDesigner on Thu Jul 11 15:55:35 CEST 2019
 {
                    panel3.setLayout(new BorderLayout());
                }
                pnlMain.add(panel3, BorderLayout.CENTER);
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
public class FicheFormulaire extends JDialog {
    public FicheFormulaire(Window owner) {
        super(owner);
        initComponents();
        btnFermer.setIcon(Main.getIconFermer());
        btnEnregistrer.setIcon(Main.getIconSave());
    }

    public JButton getBtnEnregistrer() {
        return btnEnregistrer;
    }

    public JButton getBtnFermer() {
        return btnFermer;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrolling = new JScrollPane();
        pnlMain = new JPanel();
        pnlPiedFormulaire = new JPanel();
        btnFermer = new JButton();
        btnEnregistrer = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrolling ========
        {
            scrolling.setPreferredSize(new Dimension(800, 45));

            //======== pnlMain ========
            {
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
            scrolling.setViewportView(pnlMain);
        }
        contentPane.add(scrolling, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    protected JScrollPane scrolling;
    protected JPanel pnlMain;
    private JPanel pnlPiedFormulaire;
    protected JButton btnFermer;
    protected JButton btnEnregistrer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
