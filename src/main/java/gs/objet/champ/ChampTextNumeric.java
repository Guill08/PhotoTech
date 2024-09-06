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
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class ChampTextNumeric extends ChampAbstractText{
    
    public ChampTextNumeric(String libelleChamp,JTextField jTextField, JComboBox comboBoxCritere, String champBaseDonnee, FiltreRaz filtreRaz,JButton btnSuppressionFiltre) {
        super(libelleChamp,jTextField, comboBoxCritere, champBaseDonnee,filtreRaz, btnSuppressionFiltre);
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereNumeric());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);
        this.comboBoxCritere.setSelectedItem(WhereSQL.getEgalNumeric());
    }

    @Override
    public void testerTypeValeur(String valeur) throws ErreurValeurIncorrecte  {
       if (!NumberUtils.isParsable(valeur)) {
            throw new ErreurValeurIncorrecte("un nombre !");
          
       }
    }
    
}
