package faber.tool.configuration.dao;

import faber.tool.configuration.objet.ConfigurationApplication;
import faber.tool.connexion.Connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoConfigurationApplication {


    public static void select(Connexion connexionServeur) throws SQLException {
        String requete = "Select * from update_version ";
        Connection connection = connexionServeur.getConnection();
        Statement stat = connection.createStatement();
        ResultSet rs = stat.executeQuery(requete);
        while (rs.next()) {
            ConfigurationApplication.setCheminDossierMaj(rs.getString("chemin_dossier_maj"));
            ConfigurationApplication.setVersion(rs.getString("version"));
            ConfigurationApplication.setInformationMiseAJour(rs.getString("information_mise_a_jour"));
        }
        rs.close();
        stat.close();
    }
}

