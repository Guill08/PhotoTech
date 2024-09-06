/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributSupplementaire.dao;

import attributSupplementaire.bean.AttributSupplementaire;
import attributSupplementaire.enumChamps.ChampAttributSupplementaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RDEV
 */
public class DaoAttributSupplementaire {

    private static void update(AttributSupplementaire attributSupplementaire, Connection connection) throws SQLException {

        String requete = "";

        requete = "UPDATE " + attributSupplementaire.getTableAs() + "  SET " + attributSupplementaire.getChampAttributSupplementaire() + "='" + attributSupplementaire.getValeur() + "' WHERE " + attributSupplementaire.getNomChampId() + "='" + attributSupplementaire.getIdLigneAModifier()
                + "' and clef='" + attributSupplementaire.getClef() + "';";

        //System.out.println(requete);
        Statement statment = connection.createStatement();
        statment.executeUpdate(requete);
        statment.close();
    }

    private static boolean testerExistanceAS(AttributSupplementaire attributSupplementaire, Connection connection) throws SQLException {
        boolean valeur = false;
        String requete = "SELECT alpha FROM " + attributSupplementaire.getTableAs() + " WHERE " + attributSupplementaire.getNomChampId() + "='" + attributSupplementaire.getIdLigneAModifier()
                + "' and clef='" + attributSupplementaire.getClef() + "'";
        Statement statment = connection.createStatement();
        ResultSet rs = statment.executeQuery(requete);
        while (rs.next()) {
            valeur = true;
        }
        rs.close();
        statment.close();
        return valeur;
    }

    private static void insert(AttributSupplementaire attributSupplementaire, Connection connection) throws SQLException {
        String requete;
        String champAInitialiser = "";
        String valeurChampAInitialiser = "''";
        if (attributSupplementaire.getChampAttributSupplementaire().equals(ChampAttributSupplementaire.ALPHA)) {
            champAInitialiser = ChampAttributSupplementaire.NUMERIQUE.toString();
            valeurChampAInitialiser="'0.0000'";
        } else if(attributSupplementaire.getChampAttributSupplementaire().equals(ChampAttributSupplementaire.NUMERIQUE) ){
            champAInitialiser = ChampAttributSupplementaire.ALPHA.toString();
            
        } else if (attributSupplementaire.getChampAttributSupplementaire().equals(ChampAttributSupplementaire.DATE) ||attributSupplementaire.getChampAttributSupplementaire().equals(ChampAttributSupplementaire.HEURE) ){
            champAInitialiser = ChampAttributSupplementaire.NUMERIQUE.toString() + "," + ChampAttributSupplementaire.ALPHA.toString();
             valeurChampAInitialiser="'0.0000',''";
        }
        requete = "INSERT INTO " + attributSupplementaire.getTableAs() + " (" + attributSupplementaire.getChampAttributSupplementaire() + ",clef," + attributSupplementaire.getNomChampId() + "," + champAInitialiser + ") VALUES ('" + attributSupplementaire.getValeur() + "','" + attributSupplementaire.getClef() + "','" + attributSupplementaire.getIdLigneAModifier() + "'," + valeurChampAInitialiser +");";
        Statement statment = connection.createStatement();
        statment.executeUpdate(requete);
        statment.close();
    }

    public static void updateInsert(AttributSupplementaire attributSupplementaire, Connection connection) throws SQLException {
        if (testerExistanceAS(attributSupplementaire, connection)) {
            DaoAttributSupplementaire.update(attributSupplementaire, connection);
        } else {
            DaoAttributSupplementaire.insert(attributSupplementaire, connection);
        }
    }
}
