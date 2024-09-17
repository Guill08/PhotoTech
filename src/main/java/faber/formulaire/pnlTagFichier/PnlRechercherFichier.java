package faber.formulaire.pnlTagFichier;

import faber.formulaire.pnlListeCategorie.PnlListeCategorie;
import faber.formulaire.pnlListeCategorie.PnlListeCategorieRecherche;
import faber.formulaire.pnlMiniature.PnlMiniature;
import faber.main.Main;
import faber.objet.categorie.Categorie;
import faber.objet.photo.Photo;
import faber.objet.photo.dao.DaoPhoto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class PnlRechercherFichier extends PnlTagFichier {
    private ArrayList<Categorie> collectionCategorie = new ArrayList<Categorie>();
    public PnlRechercherFichier() {

    }

    @Override
    protected void initialiserPnlCategorie() {
        PnlListeCategorieRecherche panel1 = new PnlListeCategorieRecherche(Main.collectionCategorie, this, 0);
        panel1.afficherToggleBoutonCategorie();
    }

    public ArrayList<Categorie> getCollectionCategorie() {
        return collectionCategorie;
    }

    @Override
    protected void button1(ActionEvent e) {
        chargerPhoto();
    }

    @Override
    protected void chargerPhoto() {
        try {
            DaoPhoto.select(Main.getConnectionSqlLite(), collectionCategorie,this.collectionPhoto);
            for (Photo photo : collectionPhoto) {
                pnlListePhoto.add(new PnlMiniature(new BorderLayout(), photo, this));
                pnlListePhoto.add(Box.createRigidArea(new Dimension(60, 0)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
