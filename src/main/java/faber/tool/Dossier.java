package faber.tool;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dossier {

    public static void ouvrirExplorer(String chemin) throws IOException {
        Desktop.getDesktop().open(new File(chemin));
    }

    public static String genererCheminDossier(String racine, String... sousDossiers) {
        String valeur = "";
        boolean premiereBoucle = false;
        for (String sousDossier : sousDossiers) {
            if (!premiereBoucle) {
                valeur = racine + "\\" + sousDossier;
                premiereBoucle = true;
            } else {
                valeur = valeur + "\\" + sousDossier;
            }
        }
        return valeur;
    }

    public static String supprimerCaractereInterditNomDossier(String nomFichier) {
        String valeur = "";
        valeur = nomFichier.replaceAll("[^a-zA-Z0-9\\.\\-\\ ]", "_");
        return valeur;
    }

    public static void creerDossierCommande() throws IOException {
  /*      Etat etat = affaire.getEtat();
        Affaire affaireChoisie = affaire.getAffaireBuffer();
        String codeAffaire = affaire.getCode().replace("C", "-C");
        String raisonSocialeClient = Dossier.supprimerCaractereInterditNomDossier(affaire.getClient().getRaisonSociale());
        String dossierCommande = Main.parametreApplication.getDossierCommande().getValeur();
        String cheminDossierRacine = Main.parametreApplication.getCheminDossierRacine().getValeur();
        String anneeEnCours = String.valueOf(affaire.getAnnee());
        String cheminDossierCommande = Dossier.genererCheminDossier(cheminDossierRacine, dossierCommande, anneeEnCours, codeAffaire + " - " + raisonSocialeClient);
        String dossierNomenclature = Main.parametreApplication.getDossierNomenclature().getValeur();
        String cheminDossierNomenclature = Dossier.genererCheminDossier(cheminDossierCommande, dossierNomenclature);
        String dossierRaccourciNomenclature = Main.parametreApplication.getDossierRaccourciNomenclature().getValeur();
        String cheminDossierRaccourciNomenclature = Dossier.genererCheminDossier(cheminDossierRacine, dossierRaccourciNomenclature);
        String cheminFichierRaccourciNomenclature = Dossier.genererCheminDossier(cheminDossierRaccourciNomenclature, codeAffaire + " - " + raisonSocialeClient + ".lnk");
        Dossier.creerDossierAnnee(affaire, dossierCommande);
        Path pathCheminDossierCommande = Paths.get(cheminDossierCommande);
        if (!Files.exists(pathCheminDossierCommande)) {
            try {
                Files.createDirectory(pathCheminDossierCommande);
                affaire.setCheminDossierCommande(cheminDossierCommande);
                affaireChoisie.setCheminDossierCommande(cheminDossierCommande);
                Dossier.copierDossierModele(cheminDossierCommande);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        }*/

    }

    public static void copierDossierModele(String cheminDossierDestination) {
/*        String dossierModele = Main.parametreApplication.getDossierModele().getValeur();
        String cheminDossierRacine = Main.parametreApplication.getCheminDossierRacine().getValeur();
        String cheminDossierModele = Dossier.genererCheminDossier(cheminDossierRacine, dossierModele);
        File dossierOrigine = new File(cheminDossierModele);
        File dossierDestination = new File(cheminDossierDestination);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileUtils.copyDirectory(dossierOrigine, dossierDestination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();*/
    }

    public static void creerDossierAnnee( String dossierCommande) {
/*        String anneeEnCours = String.valueOf(affaire.getAnnee());
        String cheminDossierRacine = Main.parametreApplication.getCheminDossierRacine().getValeur();
        String cheminDossierAnnee = Dossier.genererCheminDossier(cheminDossierRacine, dossierCommande, anneeEnCours);
        Path pathCheminDossierAnnee = Paths.get(cheminDossierAnnee);
        if (!(new File(cheminDossierAnnee).exists())) {
            try {
                Files.createDirectory(pathCheminDossierAnnee);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

//    public static void choisirDossierCommande(Affaire affaire) {
//       String cheminDossierRacine = Main.parametreApplication.getCheminDossierRacine().getValeur();
//        JFileChooser fc = new JFileChooser(new File(cheminDossierRacine));
//        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        fc.setDialogTitle("Choisir un nouveau dossier");
//        fc.setAcceptAllFileFilterUsed(false);
//        int returnVal = fc.showOpenDialog(Main.mainFormulaire);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            String nouveauCheminDossierCommande = fc.getSelectedFile().getAbsolutePath();
//            Path nouveauCheminFichier = Paths.get(nouveauCheminDossierCommande);
//            if (Files.exists(nouveauCheminFichier)) {
//                affaire.setCheminDossierCommande(nouveauCheminDossierCommande);
//                *//*DaoAffaire.update(affaire);*//*
//            }
//        } else {
//            Boite.afficherBoiteAlerte("Erreur", "Ce dossier n'est pas valide ! ", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public static void creerRaccourci(String cheminDossierNomenclature, String cheminDossierRaccourciNomenclature) throws IOException {
//        ShellLink.createLink(cheminDossierNomenclature, cheminDossierRaccourciNomenclature);
//    }
}
