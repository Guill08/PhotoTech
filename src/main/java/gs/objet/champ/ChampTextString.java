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

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class ChampTextString extends ChampAbstractText {

   /* public ChampTextString(String libelleChamp,JTextField jTextField, JComboBox comboBoxCritere, String champBaseDonnee,FiltreRaz filtreRaz) {
        super(libelleChamp,jTextField, comboBoxCritere, champBaseDonnee, filtreRaz);
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereString());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);
        this.comboBoxCritere.setSelectedItem(WhereSQL.getContientString());
    }*/

    public ChampTextString(String libelleChamp,JTextField jTextField, JComboBox comboBoxCritere, String champBaseDonnee,FiltreRaz filtreRaz,JButton btnSuppressionFiltreNumeroCommande) {
        super(libelleChamp,jTextField, comboBoxCritere, champBaseDonnee, filtreRaz,btnSuppressionFiltreNumeroCommande);
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereString());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);
        this.comboBoxCritere.setSelectedItem(WhereSQL.getContientString());
    }

    @Override
    public void testerTypeValeur(String valeur) throws ErreurValeurIncorrecte {
        
    }

 

  
    

}
