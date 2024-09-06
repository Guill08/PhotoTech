/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.champ;

import gs.modele.ComboBoxModelGS;
import gs.objet.FiltreRaz;
import gs.objet.WhereSQL;
import gs.objet.erreur.ErreurValeurIncorrecte;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import java.util.Date;

/**
 *
 * @author RDEV
 */
public class ChampTextDate extends ChampAbstractText {

    public ChampTextDate(String libelleChamp,JTextField jTextField, JComboBox comboBoxCritere, String champBaseDonnee, FiltreRaz filtreRaz) {
        super(libelleChamp,jTextField, comboBoxCritere, champBaseDonnee,  filtreRaz, new JButton());
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereDate());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);
        this.comboBoxCritere.setSelectedItem(WhereSQL.getSuperieurDate());
    }

    @Override
    public void testerTypeValeur(String valeur) throws ErreurValeurIncorrecte {

        try {
            //        try {
            testerFormatDate(valeur);
//        } catch (ParseException ex) {
//            
//        }
        } catch (Exception ex) {
           throw new ErreurValeurIncorrecte("une date valide ! (ex : 01/06/17)");
        }

    }

    private void testerFormatDate(String valeurTest)  throws Exception{
        Boolean valeur = true;
        Date date;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dob = formatter.parseDateTime(valeurTest);
//        DateFormat df = new SimpleDateFormat("dd/mm/YY");
//        date = df.parse(valeurTest);
       
        
    }
}
