/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

/**
 *
 * @author RDEV
 */
public class JTextFieldGS extends JTextField implements ComposantGraphique {

    private LienObject lienObjet;
    private AbstractEtatObject abstractEtatObject;
    private boolean toujourReadOnly;
    public static final boolean TOUJOUR_READ_ONLY = true;
    public static final boolean PAS_TOUJOUR_READ_ONLY = false;
    public static final boolean READ_ONLY = false;
    public static final boolean NO_READ_ONLY = true;

    public JTextFieldGS() {
        addActionPerformed();
        //addChangeListener();
        addFocusListener();
    }

    public JTextFieldGS(AbstractEtatObject abstractEtatObject, boolean toujourReadOnly) {
        //addActionPerformed();
       // addFocusListener();
       // addKeyListener();
        addChangeListener();
        this.abstractEtatObject = abstractEtatObject;

        if (toujourReadOnly) {
            this.setEditable(false);
        } else {
            this.setEditable(abstractEtatObject.isIsReadOnly());
        }

    }

    private void addActionPerformed() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lienObjet.modifierObject();
            }
        });
    }

    private void addKeyListener() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int codeKey = e.getKeyCode();
                if ((codeKey != 10) && !(codeKey >= 16 && codeKey <= 18) && !(codeKey >= 112 && codeKey <= 123) && !(codeKey >= 33 && codeKey <= 40) && (codeKey != 155)) {
                    abstractEtatObject.setIsModify(true);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void addFocusListener() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

                lienObjet.modifierObject();

            }
        });

    }

    private void addChangeListener() {
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lienObjet.modifierObject();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lienObjet.modifierObject();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lienObjet.modifierObject();
            }
        });
    }

    public void updateComposant() {
        lienObjet.modifierComposant();
    }

    public void setLienObjet(LienObject lienObjet) {
        this.lienObjet = lienObjet;
    }

}
