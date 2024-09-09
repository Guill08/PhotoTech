/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.main;
//TODO : article pour test of : 14344635
//TODO : of pour test OF136961000
//TODO : etat of : 0 non lancé 1 lancé 2 commence 3 termine 4 calcule
//TODO : etat op : 0 non commencé 1 commencée 3 terminée


import com.formdev.flatlaf.FlatLightLaf;
import faber.formulaire.mainFormulaire.MainFormulaire;
import faber.objet.connexion.SqlLite;
import faber.objet.metaDataFile.HashageFile;
import faber.objet.metaDataFile.MetaDataFile;
import faber.tool.alerte.Boite;
import faber.tool.configuration.Configuration;
import faber.tool.configuration.dao.DaoConfigurationApplication;
import faber.tool.configuration.objet.ConfigurationApplication;
import faber.tool.connexion.Connexion;
import faber.tool.connexion.ConnexionRest;
import faber.tool.parametre.ParametreApplication;
import gs.modele.ComboBoxModelGS;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;
import org.apache.commons.io.FileUtils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Faker faker = new Faker(new Locale("fr"));
 *
 * @author RDEV
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //couleur bleue : 97c3f3
    //couleur grise Hellomoov : 89 89 103
    //Gris ardoisz16 34 34
    private static Connexion connexionErp;
    private static Connexion connexionServeur;
    private static Connexion connexionVerrouServeur;
    private static Connexion connexionCompteur;
    private static Connexion connexionQualite;
    private static ImageIcon iconAjouter;
    private static ImageIcon iconAjouterListe;
    private static ImageIcon iconEnlever;
    private static ImageIcon iconConsulter;
    private static ImageIcon iconValider;
    private static ImageIcon iconMail;
    private static ImageIcon iconOpen;
    private static ImageIcon iconFermer;
    private static ImageIcon iconSave;
    private static ImageIcon iconInternet;
    private static ImageIcon iconModifier;
    private static ImageIcon iconImprimer;
    private static ImageIcon iconApplication;
    private static ImageIcon iconCout;
    private static ImageIcon iconAction;
    private static ImageIcon iconCause;
    private static ImageIcon iconTabFermerNonSurvole;
    private static ImageIcon iconTabFermerSurvole;
    private static ImageIcon iconCopier;
    private static ImageIcon iconCalcul;
    private static ImageIcon iconRecapitulatif;
    private static ImageIcon iconPoste;
    private static ImageIcon iconDownload;
    private static ImageIcon iconFavori;
    private static ImageIcon iconAlert;
    private static ImageIcon iconQuestion;
    private static ImageIcon iconQuestion48;
    private static ImageIcon iconeCompteur;
    private static ImageIcon iconeHorloge;
    private static ImageIcon iconeUser;
    private static ImageIcon iconeUserSmall;
    private static ImageIcon iconCommentaire;
    private static ImageIcon iconPacman;
    private static Date dateDebutMois;
    private static Date dateFinMois;
    private static ComboBoxModelGS modelcbxModele;
    public static ParametreApplication parametreApplication;
    public static MainFormulaire mainFormulaire;
    public static ConnexionRest connexionRest;




    private static HashMap<String, String> collectionCategorieCout = new HashMap<String, String>();




    public static void main(String[] args) throws Exception {
        Main.initialiserVariablesGlobales();
        Main.initialiserCollections();
      //  Main.intialiserIcones();
        initialiserMainFormulaire();
        MetaDataFile metaDataFile = new MetaDataFile(new File("example.file"));
        metaDataFile.ajouterPopriete("test","Coucou");
        System.out.println(metaDataFile.lirePropriete("test"));
        String sha256Hash = HashageFile.calculateFileHash("example.file", "SHA-256");
        System.out.println("SHA-256: " + sha256Hash);
        SqlLite sqlLite = new SqlLite("jdbc:sqlite:my.db");


    }


    private static void initialiserVariablesGlobales() throws SQLException {
        DateTime dateDuJour = DateTime.now();
        int dernierJour = dateDuJour.dayOfMonth().getMaximumValue();
        int mois = dateDuJour.getMonthOfYear();
        int annee = dateDuJour.getYear();
        dateFinMois = new LocalDate(annee, mois, dernierJour).toDate();
        dateDebutMois = new LocalDate(annee, mois, 1).toDate();
        Configuration configurationCompteur = new Configuration("conf/compteur.properties");
        Configuration configurationGenerale = new Configuration();

        Configuration configurationUtilisateur = new Configuration("confuser/user.properties");
        //codeUtilisateur = configurationUtilisateur.getPropriete("code");



        //  IntelliJTheme.install(Main.class.getResourceAsStream("/arc-theme-orange.theme.json"));


        // responsableDossierTechnique = configurationGenerale.getPropriete("responsableDossierTechnique");

        try {
            /*connexionErp = new Connexion(configurationGenerale.getPropriete("erp.url") + configurationGenerale.getPropriete("erp.base"), configurationGenerale.getPropriete("user"), configurationGenerale.getPropriete("password"));
            connexionQualite = new Connexion(configurationGenerale.getPropriete("qualite.url") + configurationGenerale.getPropriete("qualite.base"), configurationGenerale.getPropriete("user"), configurationGenerale.getPropriete("password"));*/
            connexionServeur = new Connexion(configurationGenerale.getPropriete("serveur.url") + configurationGenerale.getPropriete("serveur.base"), configurationGenerale.getPropriete("user"), configurationGenerale.getPropriete("password"));
            connexionVerrouServeur = new Connexion(configurationGenerale.getPropriete("serveur.url") + configurationGenerale.getPropriete("serveur.base"), configurationGenerale.getPropriete("user"), configurationGenerale.getPropriete("password"));
            connexionRest = new ConnexionRest("WEBSERVICE", "FABER", "Faber2022", "https://svrerp:8443/rest/query/");


            // connexionServeur = new Connexion(configurationGenerale.getPropriete("serveur.url") + configurationGenerale.getPropriete("serveur.base"), configurationGenerale.getPropriete("user"), configurationGenerale.getPropriete("password"));
            // connexionCompteur = new Connexion(configurationCompteur.getPropriete("serveur.url") + configurationCompteur.getPropriete("serveur.base"), configurationCompteur.getPropriete("user"), configurationCompteur.getPropriete("password"));

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
/*        ParametreApplication.ajouterParametre(ParametreApplicationEnum.COUTSUPPLEMENTAIRE);
        ParametreApplication.ajouterParametre(ParametreApplicationEnum.PORTTHEORIQUE);*/
        ParametreApplication.initialiserConfiguration();

        DaoConfigurationApplication.select(connexionServeur);

    }

    public static ConnexionRest getConnexionRest() {
        return connexionRest;
    }

    public static Connexion getConnexionVerrouServeur() {
        return connexionVerrouServeur;
    }

    private static void initialiserMainFormulaire() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //    parametreApplication = new ParametreApplication();
               /* dureeTravailLegaleJournee = Double.valueOf(parametreApplication.getDureeTravailLegaleJournee().getValeur());
                dureeTravailLegaleSemaine = Double.valueOf(parametreApplication.getDureeTravailLegaleSemaine().getValeur());
*/
                try {
                    Main.mainFormulaire = new MainFormulaire();
                    mainFormulaire.setVisible(true);
                    mainFormulaire.setExtendedState(mainFormulaire.getExtendedState() | mainFormulaire.MAXIMIZED_BOTH);
                    String version = mainFormulaire.getMenuItem2().getText();
                    if (!version.equals(ConfigurationApplication.getVersion())) {
                        Boite.afficherBoiteAlerte("Mise à jour disponible", "La mise à jour " + ConfigurationApplication.getVersion() + " est disponible !\nPour mettre l'application à jour, il faut aller dans le menu <Outils>, et cliquer sur <Mettre à jour>.\n Modification(s) apportée(s) : \n" + ConfigurationApplication.getInformationMiseAJour(), JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ErreurCritereManquant erreurCritereManquant) {
                    erreurCritereManquant.printStackTrace();
                } catch (ErreurValeurIncorrecte erreurValeurIncorrecte) {
                    erreurValeurIncorrecte.printStackTrace();
                } catch (ErreurInterval erreurInterval) {
                    erreurInterval.printStackTrace();
                }


            }
        });
    }

    private static void intialiserIcones() {
        Main.iconAjouter = new ImageIcon(Main.class.getResource("/png/add.png"));
        Main.iconAjouterListe = new ImageIcon(Main.class.getResource("/png/add_list.png"));
        Main.iconEnlever = new ImageIcon(Main.class.getClass().getResource("/png/delete.png"));
        Main.iconConsulter = new ImageIcon(Main.class.getClass().getResource("/png/watch.png"));
        Main.iconValider = new ImageIcon(Main.class.getClass().getResource("/png/valider.png"));
        Main.iconMail = new ImageIcon(Main.class.getClass().getResource("/png/mail.png"));
        Main.iconOpen = new ImageIcon(Main.class.getClass().getResource("/png/open.png"));
        Main.iconFermer = new ImageIcon(Main.class.getClass().getResource("/png/close.png"));
        Main.iconSave = new ImageIcon(Main.class.getClass().getResource("/png/save.png"));
        Main.iconModifier = new ImageIcon(Main.class.getClass().getResource("/png/edit.png"));
        Main.iconImprimer = new ImageIcon(Main.class.getClass().getResource("/png/printer24.png"));

        Main.iconTabFermerNonSurvole = new ImageIcon(Main.class.getClass().getResource("/png/close.png"));
        Main.iconTabFermerSurvole = new ImageIcon(Main.class.getClass().getResource("/png/close_rouge.png"));
        Main.iconCopier = new ImageIcon(Main.class.getClass().getResource("/png/copier.png"));
        Main.iconCalcul = new ImageIcon(Main.class.getClass().getResource("/png/calcul.png"));

       // Main.iconRecapitulatif = new ImageIcon(.getSystemResourceAsStream("/png/recapitulatif.png"));
        Main.iconPoste = new ImageIcon(Main.class.getClass().getResource("/png/poste.png"));
        Main.iconDownload = new ImageIcon(Main.class.getClass().getResource("/png/download.png"));
        Main.iconFavori = new ImageIcon(Main.class.getClass().getResource("/png/favori.png"));
        Main.iconAlert = new ImageIcon(Main.class.getClass().getResource("/png/alert.png"));
        Main.iconQuestion = new ImageIcon(Main.class.getClass().getResource("/png/question.png"));
        Main.iconQuestion48 = new ImageIcon(Main.class.getClass().getResource("/png/question_48.png"));
        Main.iconeCompteur = new ImageIcon(Main.class.getClass().getResource("/png/compteur.png"));
        Main.iconeHorloge = new ImageIcon(Main.class.getClass().getResource("/png/horloge.png"));
        Main.iconeUser = new ImageIcon(Main.class.getClass().getResource("/png/user.png"));
        Main.iconeUserSmall = new ImageIcon(Main.class.getClass().getResource("/png/user_small.png"));
        Main.iconCommentaire = new ImageIcon(Main.class.getClass().getResource("/png/commentaire.png"));
        Main.iconPacman = new ImageIcon(Main.class.getClass().getResource("/png/pacman.png"));
    }

    public static ImageIcon getIconPacman() {
        return iconPacman;
    }

    private static void initialiserCollections() throws SQLException {


    }




    private static void viderDossierTemp() {
        try {
            FileUtils.cleanDirectory(new File("etat/temp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getCollectionCategorieCout() {
        return collectionCategorieCout;
    }

    public static void setCollectionCategorieCout(HashMap<String, String> collectionCategorieCout) {
        Main.collectionCategorieCout = collectionCategorieCout;
    }






    public static Connexion getConnexionQualite() {
        return connexionQualite;
    }


    public static Connexion getConnexionCompteur() {
        return connexionCompteur;
    }



    private static void initialiserElementsGraphiques() {

    }

    public static ImageIcon getIconQuestion48() {
        return iconQuestion48;
    }


    public static ImageIcon getIconAlert() {
        return iconAlert;
    }

    public static ImageIcon getIconDownload() {
        return iconDownload;
    }


    public static ImageIcon getIconCause() {
        return iconCause;
    }

    public static ImageIcon getIconAction() {
        return iconAction;
    }

    public static ImageIcon getIconCout() {
        return iconCout;
    }

    public static ImageIcon getIconApplication() {
        return iconApplication;
    }

    public static ImageIcon getIconImprimer() {
        return iconImprimer;
    }

    public static ImageIcon getIconModifier() {
        return iconModifier;
    }

    public static ImageIcon getIconInternet() {
        return iconInternet;
    }

    public static Connexion getConnexionServeur() {
        return connexionServeur;
    }

    public static Connexion getConnexionErp() {
        return connexionErp;
    }

    public static ImageIcon getIconAjouter() {
        return iconAjouter;
    }

    public static ImageIcon getIconEnlever() {
        return iconEnlever;
    }

    public static ImageIcon getIconConsulter() {
        return iconConsulter;
    }

    public static ImageIcon getIconValider() {
        return iconValider;
    }

    public static ImageIcon getIconMail() {
        return iconMail;
    }

    public static ImageIcon getIconOpen() {
        return iconOpen;
    }

    public static ImageIcon getIconFermer() {
        return iconFermer;
    }

    public static ImageIcon getIconTabFermerNonSurvole() {
        return iconTabFermerNonSurvole;
    }

    public static ImageIcon getIconTabFermerSurvole() {
        return iconTabFermerSurvole;
    }

    public static ImageIcon getIconCopier() {
        return iconCopier;
    }


    public static ImageIcon getIconPoste() {
        return iconPoste;
    }

    public static ImageIcon getIconRecapitulatif() {
        return iconRecapitulatif;
    }

    public static ImageIcon getIconCalcul() {
        return iconCalcul;
    }

    public static ImageIcon getIconAjouterListe() {
        return iconAjouterListe;
    }

    public static ImageIcon getIconQuestion() {
        return iconQuestion;
    }

    public static ParametreApplication getParametreApplication() {
        return parametreApplication;
    }

    public static MainFormulaire getMainFormulaire() {
        return mainFormulaire;
    }

    public static ImageIcon getIconSave() {
        return iconSave;
    }

    public static ImageIcon getIconFavori() {
        return iconFavori;
    }

    public static ComboBoxModelGS getModelcbxModele() {
        return modelcbxModele;
    }

    public static ImageIcon getIconeUserSmall() {
        return iconeUserSmall;
    }

}
