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
public class ErreurValeurIncorrecte extends Exception{

    public ErreurValeurIncorrecte(String type) {
        Boite.afficherBoiteAlerte("Valeur incorrecte !","La valeur saisie doit être " + type, JOptionPane.ERROR_MESSAGE);
       
    }

   
    
}
