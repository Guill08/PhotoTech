package faber.formulaire.pnlListeCategorie;

import faber.formulaire.pnlTagFichier.PnlRechercherFichier;
import faber.objet.categorie.Categorie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PnlListeCategorieRecherche extends PnlListeCategorie {


    private final PnlRechercherFichier pnlRechercherFichier;



    public PnlListeCategorieRecherche(ArrayList<Categorie> collectionCategorie, PnlRechercherFichier pnlRechercherFichier, int niveau) {
        super();
        this.collectionCategorie = collectionCategorie;
        this.pnlRechercherFichier = pnlRechercherFichier;
        this.pnlRechercherFichier.getCollectionPnlListeCategorie().put(niveau, this);
        this.niveau = niveau;

        // supeafficherToggleBoutonCategorier(collectionCategorie, pnlRechercherFichier, niveau);
        afficherToggleBoutonCategorie();

    }

    @Override
    protected void afficherToggleBoutonCategorie() {

        ButtonGroup bg = new ButtonGroup();
        for (Categorie categorie : collectionCategorie) {
            BtnCategorieRecherche toggleButton = new BtnCategorieRecherche(this.pnlRechercherFichier, categorie, this);
            toggleButton.initialiserListener();
            bg.add(toggleButton);
            add(toggleButton);
        }
        pnlRechercherFichier.getPnlPnlListeCategorie().add(this, "cell " + String.valueOf(niveau + 1) + " 0");
        pnlRechercherFichier.repaint();
        pnlRechercherFichier.revalidate();

    }

}

class BtnCategorieRecherche extends BtnCategorie {

    private final PnlRechercherFichier pnlRechercherFichier;
    private final PnlListeCategorieRecherche pnlListeCategorieRecherche;

    public BtnCategorieRecherche(PnlRechercherFichier pnlRechercherFichier, Categorie categorie, PnlListeCategorieRecherche pnlListeCategorie) {
        super(pnlRechercherFichier, categorie, pnlListeCategorie);
        this.pnlRechercherFichier = pnlRechercherFichier;
        this.pnlListeCategorieRecherche = pnlListeCategorie;
        definirDimension(categorie);

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