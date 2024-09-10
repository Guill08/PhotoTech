/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.parametre.dao;

import faber.main.Main;
import faber.tool.connexion.ConnexionSQLServeur;
import faber.tool.parametre.ParametreApplicationEnum;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RDEV
 */
public class DaoParametreApplication {



    public static void select(HashMap<ParametreApplicationEnum, String> collectionParametre) throws SQLException {
        Connection connection = Main.getConnexionServeur().getConnection();

        for (Map.Entry mapParametre : collectionParametre.entrySet()) {
            ParametreApplicationEnum parametreApplicationEnum = (ParametreApplicationEnum) mapParametre.getKey();
            String requete = "select libelle,valeur from configuration where libelle =?";
            PreparedStatement pStat = connection.prepareCall(requete);
            pStat.setString(1,parametreApplicationEnum.toString());
            ResultSet rs = pStat.executeQuery();
            String valeur = "";
            while (rs.next()) {
                valeur = rs.getString("valeur");
            }
            collectionParametre.put(parametreApplicationEnum, valeur);
            rs.close();
            pStat.close();
        }
    }

}
