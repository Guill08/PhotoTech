package faber.formulaire.pnlListeCategorie;

import faber.formulaire.pnlTagFichier.PnlRechercherFichier;
import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.objet.categorie.Categorie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PnlListeCategorieRecherche extends PnlListeCategorie {


    private final PnlRechercherFichier pnlRechercherFichier;

    public PnlListeCategorieRecherche(PnlRechercherFichier pnlRechercherFichier) {

        this.pnlRechercherFichier = pnlRechercherFichier;
    }

    public PnlListeCategorieRecherche(ArrayList<Categorie> collectionCategorie, PnlRechercherFichier pnlRechercherFichier, int niveau) {
        super(collectionCategorie, pnlRechercherFichier, niveau);
        this.pnlRechercherFichier = pnlRechercherFichier;

    }

    @Override
    protected void afficherToggleBoutonCategorie(Categorie categorie, int niveau, ButtonGroup bg) {
        BtnCategorieRecherche toggleButton = new BtnCategorieRecherche(this.pnlRechercherFichier, categorie, this);
        bg.add(toggleButton);
        add(toggleButton);
    }

}

class BtnCategorieRecherche extends BtnCategorie {

    private final PnlRechercherFichier pnlRechercherFichier;
    private final PnlListeCategorieRecherche pnlListeCategorieRecherche;

    public BtnCategorieRecherche(PnlRechercherFichier pnlRechercherFichier, Categorie categorie, PnlListeCategorieRecherche pnlListeCategorie) {
        super(pnlRechercherFichier, categorie, pnlListeCategorie);
        this.pnlRechercherFichier = pnlRechercherFichier;
        this.pnlListeCategorieRecherche = pnlListeCategorie;
    }

    @Override
    protected void initialiserListener() {
        ListenerBtnCategorieRecherche listenerBtnCategorieRecherche = new ListenerBtnCategorieRecherche(categorie, pnlRechercherFichier, pnlListeCategorieRecherche);
        this.addActionListener(listenerBtnCategorieRecherche);
    }
}

class ListenerBtnCategorieRecherche extends ListenerBtnCategorie {


    private final PnlRechercherFichier pnlRechercherFichier;

    public ListenerBtnCategorieRecherche(Categorie categorie, PnlRechercherFichier pnlRechercherFichier, PnlListeCategorieRecherche pnlListeCategorie) {
        super(categorie, pnlRechercherFichier, pnlListeCategorie);
        this.pnlRechercherFichier = pnlRechercherFichier;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       pnlRechercherFichier.getCollectionCategorie().add(categorie);
    }
}