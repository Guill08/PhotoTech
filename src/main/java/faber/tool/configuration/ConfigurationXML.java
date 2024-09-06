/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RDEV
 */
public class ConfigurationXML {

    private static String nomFichier = "configuration.xml";
    private static Properties prop;

    public static String getPropriete(String propriete) {
        try {
            if (prop == null) {
                File file = new File(nomFichier);
                FileInputStream fileInput = new FileInputStream(file);
                prop = new Properties();
                try {
                    prop.loadFromXML(fileInput);
                    fileInput.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConfigurationXML.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                //input = new FileInputStream(nomFichier);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigurationXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prop.getProperty(propriete);
    }
}
