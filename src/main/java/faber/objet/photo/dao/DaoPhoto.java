package faber.objet.photo.dao;

import faber.objet.categorie.Categorie;
import faber.objet.photo.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoPhoto {
    public static void insertCategorie(Connection connection, Photo photo, Categorie categorie) throws SQLException {
        String requete = "INSERT INTO photo_categorie (id_photo, id_categorie) VALUES (?,?)";
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, photo.getHashage());
        preparedStatement.setInt(2, categorie.getId());
        preparedStatement.executeUpdate();

    }
    public static void insert(Connection connection, Photo photo) throws SQLException {
        String requete = "INSERT INTO photo (id,libelle) VALUES (?,?)";
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, photo.getHashage());
        preparedStatement.setString(2, photo.getFile().toPath().getFileName().toString());
        preparedStatement.executeUpdate();

    }

}
