/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

import org.jdatepicker.JDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RDEV
 */
public class DatePickerGS implements ComposantGraphique {
    private JDatePicker picker;
    private LienObject lienObjet;
 
    public DatePickerGS(JDatePicker picker) {
        this.picker = picker;
        this.picker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienObjet.modifierObject();
            }
        });
    }
    
    
    
    @Override
    public void updateComposant() {
        this.lienObjet.modifierComposant();
    }

    public void setPicker(JDatePicker picker) {
        this.picker = picker;
    }

    public void setLienObjet(LienObject lienObjet) {
        this.lienObjet = lienObjet;
    }
    
}
