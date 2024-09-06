/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.champ;

import gs.objet.FiltreRaz;
import gs.objet.critere.Critere;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;
import gs.objet.orderBy.ChampOrderBy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RDEV
 */
public abstract class ChampAbstractText extends ChampAbstract {

    final static public Integer ISNUMERIC = 1;
    final static public Integer ISTEXT = 0;
    protected JTextField jTextField;
    protected JComboBox comboBoxCritere;
    protected FiltreRaz filtreRaz;
    protected JButton btnSuppressionFiltre;

    public ChampAbstractText(String libelleChamp, JTextField jTextField, JComboBox comboBoxCritere, String champBaseDonnee, FiltreRaz filtreRaz, JButton btnSuppressionFiltre) {
        champOrderBy.setLibelle(libelleChamp);
        champOrderBy.setChampSQL(champBaseDonnee);
        this.btnSuppressionFiltre = btnSuppressionFiltre;
        this.jTextField = jTextField;
        this.comboBoxCritere = comboBoxCritere;
        super.champBaseDonnee = "lower("+champBaseDonnee+")";
        super.libelleChamp = libelleChamp;
        this.filtreRaz = filtreRaz;

    }

    public void initialiserListener() {
        initialiserActionListener(jTextField, filtreRaz);
        initialiserMouseListener(jTextField, filtreRaz);
        addListenerComboBoxCritere(comboBoxCritere, filtreRaz);
    }

    private  void initialiserMouseListener(JTextField jTextField, FiltreRaz filtreRaz) {
        btnSuppressionFiltre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jTextField.setBackground(new Color(255, 255, 255));
                filtreRaz.raz();
            }
        });
        jTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {


                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private static void initialiserActionListener(JTextField jTextField, FiltreRaz filtreRaz) {
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreRaz.filtrer();
                JTextField txtFieldWhereSQL = (JTextField) e.getSource();
                //txtFieldWhereSQL.setBackground(new Color(255, 190, 190));
            }
        });
    }

    public ChampAbstractText(String champBaseDonnee) {

        this.champBaseDonnee = champBaseDonnee;

    }

    public ChampOrderBy getChampOrderBy() {
        return champOrderBy;
    }
    
    public String getValeurCritere() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
        String valeurCritere = "";
        String valeurChamp = jTextField.getText().trim().toLowerCase();
        Critere critere = (Critere) comboBoxCritere.getSelectedItem();
        if (!valeurChamp.equals("") && critere == null) {
            throw new ErreurCritereManquant();
        } else {

            if (!valeurChamp.equals("") && critere != null) {
                String tableauValeurChamp[] = valeurChamp.split(" \\(ou\\) ");

                for (int i = 0; i < tableauValeurChamp.length; i++) {
                    if (i == 0) {
                        valeurCritere = champBaseDonnee + critere.getCodeSQL(tableauValeurChamp[i], this);
                    } else {
                        valeurCritere = valeurCritere + " or " + champBaseDonnee + critere.getCodeSQL(tableauValeurChamp[i], this);
                    }
                }
                jTextField.setBackground(new Color(255, 190, 190));
                return "(" + valeurCritere + ")";
            } else {
                return "";
            }
        }

    }

    public abstract void testerTypeValeur(String valeur) throws ErreurValeurIncorrecte;

}
