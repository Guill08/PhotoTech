/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RDEV
 */
public class JComboBoxGS extends JComboBox<Object> implements ComposantGraphique{

    private LienObject lienObjet;
    private AbstractEtatObject abstractEtatObject;
    private boolean toujourReadOnly;
    public static final boolean TOUJOUR_READ_ONLY = true;
    public static final boolean PAS_TOUJOUR_READ_ONLY = false;
    public static final boolean READ_ONLY = false;
    public static final boolean NO_READ_ONLY = true;

    
    
    public JComboBoxGS(AbstractEtatObject abstractEtatObject, boolean toujourReadOnly) {
       
        this.abstractEtatObject = abstractEtatObject;
        addActionPerformed();
        if(toujourReadOnly){
            this.setEnabled(false);
        } else {
            this.setEnabled(abstractEtatObject.isIsReadOnly());
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
    public JComboBoxGS() {
        addActionPerformed();
    }

    
    
    @Override
    public void updateComposant() {
        lienObjet.modifierComposant();
    }

    public void setLienObjet(LienObject lienObjet) {
        this.lienObjet = lienObjet;
    }
    
}
