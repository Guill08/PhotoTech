package faber.formulaire.pnlListeCategorie;

import faber.formulaire.pnlTagFichier.PnlRechercherFichier;
import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.objet.categorie.Categorie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PnlListeCategorieRecherche extends PnlListeCategorie {


    public PnlListeCategorieRecherche(ArrayList<Categorie> collectionCategorie, PnlTagFichier pnlRechercherFichier, int niveau) {
        super(collectionCategorie, pnlRechercherFichier, niveau);
        this.pnlTagFichier.getCollectionPnlListeCategorie().put(niveau, this);
    }

    @Override
    public void afficherToggleBoutonCategorie() {

        ButtonGroup bg = new ButtonGroup();
        for (Categorie categorie : collectionCategorie) {
            BtnCategorieRecherche toggleButton = new BtnCategorieRecherche(this.pnlTagFichier, categorie, this);
            toggleButton.initialiserListener();
            bg.add(toggleButton);
            add(toggleButton);
        }
        this.pnlTagFichier.getPnlPnlListeCategorie().add(this, "cell " + String.valueOf(niveau + 1) + " 0");
        this.pnlTagFichier.repaint();
        this.pnlTagFichier.revalidate();

    }

}

class BtnCategorieRecherche extends BtnCategorie {


    public BtnCategorieRecherche(PnlTagFichier pnlRechercherFichier, Categorie categorie, PnlListeCategorie pnlListeCategorie) {
        super(pnlRechercherFichier, categorie, pnlListeCategorie);
        definirDimension(categorie);

    }

    @Override
    protected void initialiserListener() {
        ListenerBtnCategorieRecherche listenerBtnCategorieRecherche = new ListenerBtnCategorieRecherche(categorie, (PnlRechercherFichier) pnlTagFichier, (PnlListeCategorieRecherche) pnlListeCategorie);
        this.addActionListener(listenerBtnCategorieRecherche);
    }
}

class ListenerBtnCategorieRecherche extends ListenerBtnCategorie {


    public ListenerBtnCategorieRecherche(Categorie categorie, PnlTagFichier pnlRechercherFichier, PnlListeCategorie pnlListeCategorie) {
        super(categorie, pnlRechercherFichier, pnlListeCategorie);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Categorie> collectionSouSCategories = categorie.getCollectionSouSCategories();
        if (collectionSouSCategories.size() > 0) {
            super.supprimerPnlListeCategorieSousJacent(super.pnlTagFichier, this.niveau + 1);
            PnlListeCategorieRecherche pnlListeCategorie = new PnlListeCategorieRecherche(collectionSouSCategories, (PnlRechercherFichier) super.pnlTagFichier, this.niveau + 1);
            pnlListeCategorie.afficherToggleBoutonCategorie();
        }
        PnlRechercherFichier pnlRechercherFichier = (PnlRechercherFichier) super.pnlTagFichier;
        pnlRechercherFichier.getCollectionCategorie().add(categorie);
        pnlRechercherFichier.setCategorieSelectionnee(categorie);

    }
}