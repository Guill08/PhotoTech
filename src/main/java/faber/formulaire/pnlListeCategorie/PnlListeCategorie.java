/*
 * Created by JFormDesigner on Tue Sep 10 16:34:18 CEST 2024
 */

package faber.formulaire.pnlListeCategorie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.main.Main;
import faber.objet.categorie.Categorie;
import faber.objet.photo.Photo;
import faber.objet.photo.dao.DaoPhoto;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlListeCategorie extends JPanel {
    private ArrayList<Categorie> collectionCategorie = new ArrayList<>();
    private PnlTagFichier pnlTagFichier;
    private PnlListeCategorie pnlListeCategorieDecendant;
    private int niveau;

    public PnlListeCategorie() {
        initComponents();
    }

    public PnlListeCategorie(ArrayList<Categorie> collectionCategorie, PnlTagFichier pnlTagFichier, int niveau) {
        this.collectionCategorie = collectionCategorie;
        this.pnlTagFichier = pnlTagFichier;
        this.pnlTagFichier.getCollectionPnlListeCategorie().put(niveau, this);
        this.niveau = niveau;
        initComponents();
        ButtonGroup bg = new ButtonGroup();
        for (Categorie categorie : collectionCategorie) {

            afficherToggleBoutonCategorie(categorie, niveau, bg);
        }
        pnlTagFichier.getPnlPnlListeCategorie().add(this, "cell " + String.valueOf(niveau + 1) + " 0");
        pnlTagFichier.repaint();
        pnlTagFichier.revalidate();
    }

    public PnlListeCategorie getPnlListeCategorieDecendant() {
        return pnlListeCategorieDecendant;
    }

    public void setPnlListeCategorieDecendant(PnlListeCategorie pnlListeCategorieDecendant) {
        this.pnlListeCategorieDecendant = pnlListeCategorieDecendant;
    }

    private void afficherToggleBoutonCategorie(Categorie categorie, int niveau, ButtonGroup bg) {


        JToggleButton toggleButton = new JToggleButton();
        bg.add(toggleButton);
        toggleButton.setMinimumSize(new Dimension(150, 30));
        toggleButton.setMaximumSize(new Dimension(150, 30));
        toggleButton.setPreferredSize(new Dimension(150, 30));
        toggleButton.setText(categorie.getLibelle());
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnlTagFichier.getCollectionPhoto().size() > 0) {
                    ArrayList<Categorie> collectionCategorie = categorie.getCollectionSouSCategories();
                    int niveau = collectionCategorie.get(0).getNiveau();
                    if (collectionCategorie.size() > 0) {
                        supprimerPnlListeCategorieSousJacent(pnlTagFichier, PnlListeCategorie.this.niveau + 1);
                        PnlListeCategorie pnlListeCategorie = new PnlListeCategorie(collectionCategorie, pnlTagFichier, PnlListeCategorie.this.niveau + 1);
                    }
                    for (Photo photo : pnlTagFichier.getCollectionPhoto()) {
                        photo.getCollectionMetaDataFile().add(categorie);
                        try {
                            DaoPhoto.insertCategorie(Main.getConnectionSqlLite(),photo,categorie);
                            DaoPhoto.insert(Main.getConnectionSqlLite(),photo);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(PnlListeCategorie.this.pnlTagFichier, "Merci de saisir un photo !", "Aucune saisie", JOptionPane.WARNING_MESSAGE);
                }


            }

            private void supprimerPnlListeCategorieSousJacent(PnlTagFichier pnlTagFichier, int niveau) {
                HashMap<Integer, PnlListeCategorie> collectionPnlListeCategorie = pnlTagFichier.getCollectionPnlListeCategorie();
                for (int i = 0; i <= collectionPnlListeCategorie.size() - 1; i++) {
                    if (i >= niveau) {
                        PnlListeCategorie pnlListeCategorie = collectionPnlListeCategorie.get(i);
                        pnlTagFichier.remove(pnlListeCategorie);
                        pnlTagFichier.repaint();
                        pnlTagFichier.revalidate();
                    }


                }
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
