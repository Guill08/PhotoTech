/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.champ;

import gs.objet.FiltreRaz;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;
import gs.objet.orderBy.ChampOrderBy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RDEV
 */
public abstract class ChampAbstract {

    protected String champBaseDonnee;
    protected String libelleChamp;
    protected ChampOrderBy champOrderBy= new ChampOrderBy(libelleChamp, champBaseDonnee);
    protected boolean ajouterListeOrderBy=true;

    public boolean isAjouterListeOrderBy() {
        return ajouterListeOrderBy;
    }

    public void setAjouterListeOrderBy(boolean ajouterListeOrderBy) {
        this.ajouterListeOrderBy = ajouterListeOrderBy;
    }
    
    public ChampOrderBy getChampOrderBy() {
        return champOrderBy;
    }

    public String getChampBaseDonnee() {
        return champBaseDonnee;
    }

    public String getLibelleChamp() {
        return libelleChamp;
    }

    public void setLibelleChamp(String libelleChamp) {
        this.libelleChamp = libelleChamp;
    }

    public abstract String getValeurCritere() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval;

    public void addListenerComboBoxCritere(JComboBox comboBoxChoix, FiltreRaz filtreRaz) {
        comboBoxChoix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 filtreRaz.filtrer();
            }
        });
        comboBoxChoix.addMouseListener(new MouseListener() {
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
}
