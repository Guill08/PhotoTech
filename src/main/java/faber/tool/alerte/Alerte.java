/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faber.tool.alerte;


import org.apache.logging.log4j.LogManager;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class Alerte {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Alerte.class.getName());
    public static void afficherAlerteErreur(String message,Exception ex,org.apache.logging.log4j.Logger LOGGER,String nomClasse ){
        LOGGER.error(message,nomClasse,ex);
        Boite.afficherBoiteAlerte("Erreur", message, JOptionPane.ERROR_MESSAGE);
    }
}
