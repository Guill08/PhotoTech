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

    public int getNiveau() {
        return niveau;
    }

    public PnlListeCategorie getPnlListeCategorieDecendant() {
        return pnlListeCategorieDecendant;
    }

    public void setPnlListeCategorieDecendant(PnlListeCategorie pnlListeCategorieDecendant) {
        this.pnlListeCategorieDecendant = pnlListeCategorieDecendant;
    }

    private void afficherToggleBoutonCategorie(Categorie categorie, int niveau, ButtonGroup bg) {


        BtnCategorie toggleButton = new BtnCategorie(pnlTagFichier, categorie, this);
        bg.add(toggleButton);
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
class BtnCategorie extends JToggleButton {
    private final PnlTagFichier pnlTagFichier;
    private final Categorie categorie;
    private final PnlListeCategorie     pnlListeCategorie;
    private final int niveau;

    public BtnCategorie(PnlTagFichier pnlTagFichier, Categorie categorie,PnlListeCategorie pnlListeCategorie) {
        super();
        this.pnlTagFichier = pnlTagFichier;
        this.categorie = categorie;
        this.pnlListeCategorie = pnlListeCategorie;
        this.niveau = pnlListeCategorie.getNiveau();
        this.setMinimumSize(new Dimension(150, 30));
        this.setMaximumSize(new Dimension(150, 30));
        this.setPreferredSize(new Dimension(150, 30));
        this.setText(categorie.getLibelle());
        initialiserListener();
    }

    private void initialiserListener() {
        this.addActionListener(new ListenerBtnCategorie(categorie,pnlTagFichier,pnlListeCategorie));

    }


}
class ListenerBtnCategorie implements ActionListener {

    private final Categorie categorie;
    private final PnlTagFichier pnlTagFichier;
    private final PnlListeCategorie pnlListeCategorie;
    private final int niveau;

    public ListenerBtnCategorie(Categorie categorie, PnlTagFichier pnlTagFichier, PnlListeCategorie pnlListeCategorie) {
        this.categorie = categorie;
        this.pnlTagFichier = pnlTagFichier;
        this.pnlListeCategorie = pnlListeCategorie;
        this.niveau = pnlListeCategorie.getNiveau();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pnlTagFichier.getCollectionPhoto().size() > 0) {
            ArrayList<Categorie> collectionCategorie = categorie.getCollectionSouSCategories();
              if (collectionCategorie.size() > 0) {
                supprimerPnlListeCategorieSousJacent(pnlTagFichier, this.niveau + 1);
                PnlListeCategorie pnlListeCategorie = new PnlListeCategorie(collectionCategorie, pnlTagFichier, this.niveau + 1);
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
            JOptionPane.showMessageDialog(this.pnlTagFichier, "Merci de saisir un photo !", "Aucune saisie", JOptionPane.WARNING_MESSAGE);
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
}