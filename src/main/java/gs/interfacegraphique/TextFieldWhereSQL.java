/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.interfacegraphique;

import gs.objet.FiltreRaz;

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
public class TextFieldWhereSQL extends JTextField {

    private FiltreRaz filtreRaz;

    public TextFieldWhereSQL() {
    }



    public TextFieldWhereSQL(FiltreRaz filtreRaz) {
        this.filtreRaz = filtreRaz;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreRaz.filtrer();
                JTextField txtFieldWhereSQL = (TextFieldWhereSQL) e.getSource();
                //txtFieldWhereSQL.setBackground(new Color(255, 190, 190));
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    filtreRaz.raz();
                    JTextField txtFieldWhereSQL = (TextFieldWhereSQL) e.getSource();
                    txtFieldWhereSQL.setText("");
                    txtFieldWhereSQL.setBackground(new Color(255, 255, 255));
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
