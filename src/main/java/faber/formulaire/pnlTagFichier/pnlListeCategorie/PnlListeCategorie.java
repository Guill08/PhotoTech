/*
 * Created by JFormDesigner on Tue Sep 10 16:34:18 CEST 2024
 */

package faber.formulaire.pnlTagFichier.pnlListeCategorie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.main.Main;
import faber.objet.categorie.Categorie;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlListeCategorie extends JPanel {
    private ArrayList<Categorie> collectionCategorie = new ArrayList<>();
    private  PnlTagFichier pnlTagFichier;

    public PnlListeCategorie() {
        initComponents();
    }

    public PnlListeCategorie(ArrayList<Categorie> collectionCategorie, PnlTagFichier pnlTagFichier, int niveau) {
        this.collectionCategorie = collectionCategorie;
        this.pnlTagFichier = pnlTagFichier;
        initComponents();
        for (Categorie categorie : collectionCategorie) {
            afficherToggleBoutonCategorie(categorie,niveau+1);

        }
        pnlTagFichier.add(this, "cell " + String.valueOf(niveau+1)+" 0");
        pnlTagFichier.repaint();
        pnlTagFichier.revalidate();
    }

    private void afficherToggleBoutonCategorie(Categorie categorie, int niveau) {


        JToggleButton toggleButton = new JToggleButton();
        toggleButton.setMinimumSize(new Dimension(150, 30));
        toggleButton.setMaximumSize(new Dimension(150, 30));
        toggleButton.setPreferredSize(new Dimension(150, 30));
        toggleButton.setText(categorie.getLibelle());
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Categorie>collectionCategorie = categorie.getCollectionSouSCategories();
                int niveau = collectionCategorie.get(0).getNiveau();
                PnlListeCategorie pnlListeCategorie = new PnlListeCategorie(collectionCategorie,pnlTagFichier,niveau);
           /*     for (Categorie categorie1 : collectionCategorie) {
                   pnlTagFichier.add(PnlListeCategorie.this, "cell " + String.valueOf(niveau+1 )+" 0");

                   afficherToggleBoutonCategorie(categorie1, categorie1.getNiveau());
                }*/
            }
        });
        add(toggleButton);

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
