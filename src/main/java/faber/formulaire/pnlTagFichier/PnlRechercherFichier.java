package faber.formulaire.pnlTagFichier;

import faber.formulaire.pnlListeCategorie.PnlListeCategorie;
import faber.formulaire.pnlListeCategorie.PnlListeCategorieRecherche;
import faber.main.Main;

public class PnlRechercherFichier extends PnlTagFichier{
    public PnlRechercherFichier() {
    }

    @Override
    public void createUIComponents() {
        PnlListeCategorieRecherche panel1 = new PnlListeCategorieRecherche(Main.collectionCategorie, this, 0);
    }

}
