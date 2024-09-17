package faber.formulaire.pnlTagFichier;

import faber.formulaire.pnlListeCategorie.PnlListeCategorie;
import faber.formulaire.pnlListeCategorie.PnlListeCategorieRecherche;
import faber.main.Main;
import faber.objet.categorie.Categorie;

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



}
