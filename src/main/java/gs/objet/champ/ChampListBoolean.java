/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.champ;

import gs.modele.ComboBoxModelGS;
import gs.objet.ChoixListeInterface;
import gs.objet.FiltreRaz;
import gs.objet.WhereSQL;
import gs.objet.critere.Critere;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class ChampListBoolean extends ChampAbstract {

    
    protected JComboBox comboBoxCritere;
    protected JComboBox comboBoxChoix;
    protected FiltreRaz filtreRaz;
    public ChampListBoolean(String libelleChamp,JComboBox<ChoixListeInterface> comboBoxChoix, JComboBox comboBoxCritere, String champBaseDonnee,FiltreRaz filtreRaz) {
        super.champBaseDonnee = champBaseDonnee;
        super.libelleChamp=libelleChamp;
        this.comboBoxChoix = comboBoxChoix;
        this.comboBoxCritere = comboBoxCritere;
        this.filtreRaz=filtreRaz;
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereListBoolean());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);
        addListenerComboBoxCritere(comboBoxChoix, filtreRaz);
        addListenerComboBoxCritere(comboBoxCritere, filtreRaz);
        comboBoxCritere.setSelectedItem(WhereSQL.getEgalBooleanListe());
        super.setAjouterListeOrderBy(false);
    }

    @Override
    public String getValeurCritere() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
        String valeurCritere = "";
        String valeur = (String) comboBoxChoix.getSelectedItem();
        String valeurChamp ="";
        if (valeur != null) {
            switch(valeur){
                case "Oui":
                    valeurChamp="true";
                    break;
                case "Non":
                    valeurChamp="false";
                    break;
                default:
                    valeurChamp="true";
                    break;
            }
                       
            Critere critere = (Critere) comboBoxCritere.getSelectedItem();
            if (!valeurChamp.equals("") && critere == null) {
                throw new ErreurCritereManquant();
            } else {
                return  "(" +champBaseDonnee +critere.getCodeSQL(valeurChamp) + ")";
            }
        } else {
            return "";
        }
    }
}
