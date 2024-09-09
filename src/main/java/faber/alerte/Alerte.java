/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faber.alerte;


import faber.tool.connexion.ConnexionSQLServeur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class Alerte {

    final Logger logger = LoggerFactory.getLogger(Alerte.class);
    public static void afficherAlerteErreur(String message,Logger LOGGER,String nomClasse ){

        LOGGER.error(message,nomClasse,LOGGER);
        Boite.afficherBoiteAlerte("Erreur", message, JOptionPane.ERROR_MESSAGE);
    }
}
