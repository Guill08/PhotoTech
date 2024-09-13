package faber.formulaire.pnlListeCategorie;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.objet.categorie.Categorie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PnlListeCategorieRecherche extends PnlListeCategorie {

    public PnlListeCategorieRecherche() {

    }

    public PnlListeCategorieRecherche(ArrayList<Categorie> collectionCategorie, PnlTagFichier pnlTagFichier, int niveau) {
        super(collectionCategorie, pnlTagFichier, niveau);
    }

    @Override
    protected void afficherToggleBoutonCategorie(Categorie categorie, int niveau, ButtonGroup bg) {
        BtnCategorieRecherche toggleButton = new BtnCategorieRecherche(pnlTagFichier, categorie, this);
        bg.add(toggleButton);
        add(toggleButton);
    }

}

class BtnCategorieRecherche extends BtnCategorie {


    public BtnCategorieRecherche(PnlTagFichier pnlTagFichier, Categorie categorie, PnlListeCategorie pnlListeCategorie) {
        super(pnlTagFichier, categorie, pnlListeCategorie);
    }

    @Override
    protected void initialiserListener() {
        ListenerBtnCategorieRecherche listenerBtnCategorieRecherche = new ListenerBtnCategorieRecherche(categorie, pnlTagFichier, pnlListeCategorie);
        this.addActionListener(listenerBtnCategorieRecherche);
    }
}

class ListenerBtnCategorieRecherche extends ListenerBtnCategorie {


    public ListenerBtnCategorieRecherche(Categorie categorie, PnlTagFichier pnlTagFichier, PnlListeCategorie pnlListeCategorie) {
        super(categorie, pnlTagFichier, pnlListeCategorie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("test");
    }
}