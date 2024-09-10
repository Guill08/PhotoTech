/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faber.alerte;


import faber.tool.connexion.ConnexionSQLServeur;


import javax.swing.*;
import java.util.logging.Logger;

/**
 *
 * @author RDEV
 */
public class Alerte {

    public static void afficherAlerteErreur(String message, Logger LOGGER, String nomClasse ){


        Boite.afficherBoiteAlerte("Erreur", message, JOptionPane.ERROR_MESSAGE);
    }
}
