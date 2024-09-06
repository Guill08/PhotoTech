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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RDEV
 */
public class ChampListString extends ChampAbstract {

    
    protected JComboBox comboBoxCritere;
    protected JComboBox comboBoxChoix;
    protected FiltreRaz filtreRaz;
    protected JButton btnSuppressionFiltre;
    public ChampListString(String libelleChamp,JComboBox<ChoixListeInterface> comboBoxChoix, JComboBox comboBoxCritere, String champBaseDonnee,FiltreRaz filtreRaz,JButton btnSuppressionFiltre) {
        super.champBaseDonnee = champBaseDonnee;
        super.libelleChamp=libelleChamp;
        this.comboBoxChoix = comboBoxChoix;
        this.comboBoxCritere = comboBoxCritere;
        this.btnSuppressionFiltre = btnSuppressionFiltre;
        this.filtreRaz=filtreRaz;
        ComboBoxModelGS modeleComboBoxCritere = new ComboBoxModelGS(WhereSQL.getCollectionCritereListeString());
        this.comboBoxCritere.setModel(modeleComboBoxCritere);

    }
    public void initialiserListener() {
        btnSuppressionFiltre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreRaz.raz();

                comboBoxChoix.setSelectedItem(null);
            }
        });
        addListenerComboBoxCritere(comboBoxChoix, filtreRaz);
        addListenerComboBoxCritere(comboBoxCritere, filtreRaz);
        comboBoxCritere.setSelectedItem(WhereSQL.getEgalString());
    }
    @Override
    public String getValeurCritere() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
        String valeurCritere = "";
        ChoixListeInterface choixListeInterface = (ChoixListeInterface) comboBoxChoix.getSelectedItem();
        if (choixListeInterface != null) {
            String valeurChamp = choixListeInterface.getIdListe();
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
