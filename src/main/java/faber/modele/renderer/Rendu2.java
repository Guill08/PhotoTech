/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele.renderer;

import faber.modele.ModeleDonnees;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author RDEV
 */
public class Rendu2 extends DefaultTableCellRenderer {

    private String texteAfficher = "";
    private ImageIcon icon;
    private ModeleDonnees donnees;

    public Rendu2(String texteAfficher, ImageIcon icon, ModeleDonnees donnees) {
        this.texteAfficher = texteAfficher;
        this.icon = icon;
        this.donnees = donnees;


    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lbl = new JLabel();

        if (donnees.afficherIconePointeurMain(column)) {
            this.setIcon(icon);
            this.setBackground(new Color(255, 255, 255));
            this.setToolTipText(texteAfficher);
            return this;
        } else {
           return lbl;
       }
    }
}