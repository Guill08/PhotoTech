/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.erreur;

import gs.alerte.Boite;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class ErreurInterval extends Exception{
    public ErreurInterval() {
        Boite.afficherBoiteAlerte("Expression incorrecte !","Les deux valeurs doivent être séparèes par l'expression \" et \"", JOptionPane.ERROR_MESSAGE);        
    }
}
