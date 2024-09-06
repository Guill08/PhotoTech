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
public class ErreurCritereManquant extends Exception{

    public ErreurCritereManquant() {
       
        Boite.afficherBoiteAlerte("Donnée manquante !", "Le critére n'est pas renseigné !", JOptionPane.ERROR_MESSAGE);
        
    }
    
}
