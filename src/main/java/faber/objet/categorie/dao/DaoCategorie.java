package faber.objet.categorie.dao;

import faber.objet.categorie.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCategorie {
    public static ArrayList<Categorie> select(Connection connection, int niveau) throws SQLException {
        PreparedStatement preparedStatement = null;
        ArrayList<Categorie> collectionCategorie = new ArrayList<>();
        String requete = "select id,code,libelle,niveau,id_categorie_sup  from categorie where niveau = ?";
        preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, niveau);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Categorie categorie = new Categorie(resultSet.getString("code"), resultSet.getString("libelle"));
            collectionCategorie.add(categorie);
            categorie.setCollectionSouSCategories(DaoCategorie.selectSousCategorie(connection,1,categorie));

        }

        return collectionCategorie;
    }
    public static ArrayList<Categorie> selectSousCategorie(Connection connection, int niveau, Categorie categorie) throws SQLException {
        PreparedStatement preparedStatement = null;
        ArrayList<Categorie> collectionCategorie = categorie.getCollectionSouSCategories();
        String requete = "select id,code,libelle,niveau,id_categorie_sup  from categorie where niveau = ? and id_categorie_sup = ?";
        preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, niveau);
        preparedStatement.setInt(2, categorie.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Categorie sousCategorie = new Categorie(resultSet.getString("code"), resultSet.getString("libelle"));
            collectionCategorie.add(sousCategorie);
            sousCategorie.setCollectionSouSCategories(DaoCategorie.selectSousCategorie(connection,niveau+1,sousCategorie));

        }

        return collectionCategorie;
    }


}
