 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package gs.objet;

 import gs.modele.ComboBoxModelGS;
 import gs.objet.champ.ChampAbstract;
 import gs.objet.critere.CollectionCritere;
 import gs.objet.critere.Critere;
 import gs.objet.critere.CritereInterval;
 import gs.objet.erreur.ErreurCritereManquant;
 import gs.objet.erreur.ErreurInterval;
 import gs.objet.erreur.ErreurValeurIncorrecte;
 import gs.objet.orderBy.ChampOrderBy;
 import gs.objet.orderBy.SensOrdre;
 import gs.objet.toggle.JtoogleFiltre;

 import javax.swing.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.ArrayList;

 /**
  * @author RDEV
  */
 @SuppressWarnings("unchecked")
 public class WhereSQL extends ArrayList<ChampAbstract> {

     private SensOrdre croissant = new SensOrdre("Croissant", "");
     private SensOrdre deCroissant = new SensOrdre("Décroissant", "DESC");
     private ArrayList listeOrderBy = new ArrayList<ChampOrderBy>();
     private ArrayList listeSensOrdre = new ArrayList<SensOrdre>();
     private ArrayList<JtoogleFiltre> listeBoutonFiltre = new ArrayList<JtoogleFiltre>();
     private JComboBox cbxSensOrdre;
     private JComboBox cbxChampOrderBy;
     private static Critere contientString;
     private static Critere commenceParString;
     private static Critere superieurNumeric;
     private static Critere superieurDate;
     private static Critere egalNumeric;
     private static Critere egalString = new Critere("égal à", "1", 2, "='#1'");
     private static Critere differentString = new Critere("different de", "1", 2, "<>'#1'");
     private static Critere egalNumericListe;
     private static Critere egalBooleanListe;
     private static Critere differentBooleanListe;

     public WhereSQL(JComboBox<SensOrdre> cbxSensOrdre, JComboBox<ChampOrderBy> cbxChampOrderBy) {
         this.cbxSensOrdre = cbxSensOrdre;
         this.cbxChampOrderBy = cbxChampOrderBy;

         listeSensOrdre.add(croissant);
         listeSensOrdre.add(deCroissant);
         ComboBoxModelGS modeleSensOrdre = new ComboBoxModelGS(listeSensOrdre);
         this.cbxSensOrdre.setModel(modeleSensOrdre);
         ComboBoxModelGS modeleChampOrderBy = new ComboBoxModelGS(listeOrderBy);
         this.cbxChampOrderBy.setModel(modeleChampOrderBy);

     }

     public WhereSQL() {
     }

     public static Critere getEgalString() {
         return egalString;
     }

     public static Critere getDifferentString() {
         return differentString;
     }

     public void ajouterListenerCbxTrierParSens(FiltreRaz filtreRaz) {
         cbxSensOrdre.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 filtreRaz.filtrer();
             }
         });
         cbxChampOrderBy.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 filtreRaz.filtrer();
             }
         });
     }

     public static Critere getEgalNumeric() {
         return egalNumeric;
     }

     public static Critere getContientString() {
         return contientString;
     }

     public static Critere getSuperieurNumeric() {
         return superieurNumeric;
     }

     public static Critere getSuperieurDate() {
         return superieurDate;
     }

     public SensOrdre getCroissant() {
         return croissant;
     }

     public SensOrdre getDeCroissant() {
         return deCroissant;
     }

     @Override
     public boolean add(ChampAbstract e) {
         if (e.isAjouterListeOrderBy()) {
             listeOrderBy.add(e.getChampOrderBy());
         }

         return super.add(e);


         //To change body of generated methods, choose Tools | Templates.
     }

     public static Critere getEgalNumericListe() {
         return egalNumericListe;
     }

     public static CollectionCritere getCollectionCritereString() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere contientString = new Critere("contient", "0", 1, " like '%#1%'");
         WhereSQL.contientString = contientString;
         collectionCritere.add(contientString);
         collectionCritere.add(new Critere("égal à", "1", 2, "='#1'"));
         collectionCritere.add(new Critere("commence par", "2", 3, " like '#1%'"));
         collectionCritere.add(new Critere("se termine par", "3", 4, " like '%#1'"));
         collectionCritere.add(new CritereInterval("compris entre", "4", 5, " BETWEEN '#1' AND '#2'"));
         collectionCritere.add(new Critere("supérieur ou égal à ", "5", 6, ">= '#1'"));
         collectionCritere.add(new Critere("inférieur ou égal à ", "6", 7, "<= '#1'"));

         return collectionCritere;
     }
     public static CollectionCritere getCollectionCritereStringOrdonnee() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere commenceParString = new Critere("commence par", "2", 3, " like '#1%'");
         WhereSQL.commenceParString = commenceParString;
         Critere contientString = new Critere("contient", "0", 1, " like '%#1%'");
         collectionCritere.add(commenceParString);
         collectionCritere.add(new Critere("égal à", "1", 2, "='#1'"));
         collectionCritere.add(contientString);


         return collectionCritere;
     }
     public static CollectionCritere getCollectionCritereListeString() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere egalString = new Critere("égal à", "1", 2, "='#1'");
         Critere differentString = new Critere("different de", "1", 2, "<>'#1'");
         WhereSQL.egalString = egalString;
         WhereSQL.differentString = differentString;
         collectionCritere.add(egalString);
         collectionCritere.add(differentString);


         return collectionCritere;
     }

     public static CollectionCritere getCollectionCritereListeStringOld() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere contientString = new Critere("contient", "0", 1, " like '%#1%'");
         WhereSQL.contientString = contientString;
         collectionCritere.add(new Critere("contient", "0", 1, " like '%#1%'"));
         collectionCritere.add(new Critere("égal à", "1", 2, "='#1'"));
         collectionCritere.add(new Critere("commence par", "2", 3, " like '#1%'"));
         collectionCritere.add(new Critere("se termine par", "3", 4, " like '%#1'"));
         collectionCritere.add(new Critere("supérieur ou égal à ", "5", 6, ">= '#1'"));
         collectionCritere.add(new Critere("inférieur ou égal à ", "6", 7, "<= '#1'"));

         return collectionCritere;
     }

     public static CollectionCritere getCollectionCritereListeNumeric() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere egalNumericListe = new Critere("égal à", "1", 2, "=#1");
         WhereSQL.egalNumericListe = egalNumericListe;
         collectionCritere.add(WhereSQL.egalNumericListe);

         return collectionCritere;
     }

     public static CollectionCritere getCollectionCritereListBoolean() {
         CollectionCritere collectionCritere = new CollectionCritere();
         Critere egalBooleanListe = new Critere("égal à", "1", 1, "='#1'");
         Critere differentBooleanListe = new Critere("différent de", "1", 1, "<>'#1'");
         WhereSQL.egalBooleanListe = egalBooleanListe;
         WhereSQL.differentBooleanListe = differentBooleanListe;
         collectionCritere.add(WhereSQL.egalBooleanListe);
         collectionCritere.add(WhereSQL.differentBooleanListe);
         return collectionCritere;
     }

     public static CollectionCritere getCollectionCritereNumeric() {
         Critere egalNumeric = new Critere("égal à", "1", 2, "=#1");
         WhereSQL.egalNumeric = egalNumeric;
         CollectionCritere collectionCritere = new CollectionCritere();
         collectionCritere.add(egalNumeric);
         collectionCritere.add(new CritereInterval("compris entre", "4", 5, " BETWEEN #1 AND #2"));
         Critere superieurNumeric = new Critere("supérieur ou égal à ", "5", 6, ">= #1");
         WhereSQL.superieurNumeric = superieurNumeric;
         collectionCritere.add(superieurNumeric);
         collectionCritere.add(new Critere("inférieur ou égal à ", "6", 7, "<= #1"));

         return collectionCritere;
     }

     public static CollectionCritere getCollectionCritereDate() {
         CollectionCritere collectionCritere = new CollectionCritere();
         collectionCritere.add(new Critere("égal à", "1", 2, "='#1'"));
         collectionCritere.add(new CritereInterval("compris entre", "4", 5, " BETWEEN '#1' AND '#2'"));
         Critere superieurDate = new Critere("supérieur ou égal à ", "5", 6, ">= '#1'");
         WhereSQL.superieurDate = superieurDate;
         collectionCritere.add(superieurDate);
         collectionCritere.add(new Critere("inférieur ou égal à ", "6", 7, "<= '#1'"));

         return collectionCritere;
     }

     public String creerClauseOrderBy() {
         String clauseOrderBy = "";

         ChampOrderBy champOrderBy = (ChampOrderBy) cbxChampOrderBy.getSelectedItem();
         SensOrdre sensOrdre = (SensOrdre) cbxSensOrdre.getSelectedItem();

         if (champOrderBy != null || sensOrdre != null) {
             clauseOrderBy = champOrderBy.getClauseSQL() + " " + sensOrdre.getClauseSQL();
         }

         return clauseOrderBy;
     }

     public String creerClauseWhereSQL() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
         String valeur = "";
         String valeurCritere = "";

         int j = 0;
         for (int i = 0; i < this.size(); i++) {
             ChampAbstract champAbstract = this.get(i);
             valeurCritere = champAbstract.getValeurCritere();
             if (!valeurCritere.equals("") && !valeurCritere.equals("0")) {
                 if (j == 0) {
                     valeur = valeurCritere;

                 } else {
                     valeur = valeur + " and " + valeurCritere;
                 }
                 j++;
             }
         }
         String valeurBoutonFiltre = "";
         for (int i = 0; i < listeBoutonFiltre.size(); i++) {
             JtoogleFiltre jtoogleFiltre = listeBoutonFiltre.get(i);

             if (jtoogleFiltre.isSelected()) {
                 if (valeurBoutonFiltre.equals("")) {
                     valeurBoutonFiltre = jtoogleFiltre.getRequete();

                 } else {
                     valeurBoutonFiltre = valeurBoutonFiltre + " and " + jtoogleFiltre.getRequete();
                 }
             }


         }
         if (valeur.equals("") ) {
             if (valeurBoutonFiltre.equals("")) {
                 return "";
             } else {
                 return valeurBoutonFiltre;
             }
         } else if (valeurBoutonFiltre.equals("")){
             return valeur;
         } else {
             return valeur + " and " + valeurBoutonFiltre;
         }


     }

     public static Critere getCommenceParString() {
         return commenceParString;
     }

     public void ajouterFiltreBouton(JtoogleFiltre jButton){
        this.listeBoutonFiltre.add(jButton);
     }


     public static Critere getEgalBooleanListe() {
         return egalBooleanListe;
     }

     public static Critere getDifferentBooleanListe() {
         return differentBooleanListe;
     }

 }
