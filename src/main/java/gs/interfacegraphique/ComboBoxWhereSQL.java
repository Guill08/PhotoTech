/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.interfacegraphique;

import gs.objet.FiltreRaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RDEV
 */
public class ComboBoxWhereSQL extends JComboBox {

    private FiltreRaz filtreRaz;

    public ComboBoxWhereSQL(FiltreRaz filtreRaz) {
        this.filtreRaz = filtreRaz;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // filtreRaz.filtrer();
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    filtreRaz.raz();
                    JComboBox comboBoxWhereSQL = (JComboBox) e.getSource();
                  comboBoxWhereSQL.setSelectedItem(null);
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

    public ComboBoxWhereSQL() {
    }

}
