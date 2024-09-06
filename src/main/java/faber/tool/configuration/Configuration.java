/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.configuration;

/**
 *
 * @author RDEV
 */

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.InputStream;

;

public class Configuration {

    private String nomFichier = "conf/configuration.properties";
    private InputStream input;
    //  private  Properties prop = new Properties();
    private PropertiesConfiguration prop;

    public Configuration() {
        try {
            prop = new PropertiesConfiguration(nomFichier);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

    public Configuration(String nomFichier) {
        this.nomFichier= nomFichier;
        try {
            prop = new PropertiesConfiguration(nomFichier);


        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public  String getPropriete(String propriete) {

        return prop.getString(propriete);
    }
    public  void setPropriete(String propriete, String value) {
        prop.setProperty(propriete, value);

        try {
            prop.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }
}
