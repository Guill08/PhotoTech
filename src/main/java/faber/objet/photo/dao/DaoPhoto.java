package faber.objet.photo.dao;

import faber.objet.categorie.Categorie;
import faber.objet.miniature.Miniature;
import faber.objet.photo.Photo;

import javax.swing.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static void select(Connection connection, ArrayList<Categorie> collectionCategorie, ArrayList<Photo> collectionPhoto,Categorie categorie) throws SQLException {
        String where = genererWhere(categorie);

        String requete = "SELECT photo.id,photo.libelle FROM photo " +
                "INNER JOIN photo_categorie ON photo.id = photo_categorie.id_photo " +
                "WHERE " + where + " GROUP BY 1,2";
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Photo photo = new Photo();
            photo.setHashage(resultSet.getString("id"));
            photo.setLibelle(resultSet.getString("libelle"));
            File file = new File("data/mini/" + photo.getHashage());
            Miniature miniature = new Miniature(new ImageIcon(file.getPath()), photo);
            photo.setMiniature(miniature);
            collectionPhoto.add(photo);
        }
    }

    private static String genererWhere(Categorie categorie) {
        StringBuilder where = new StringBuilder();
        where.append("photo_categorie.id_categorie =");

        where.append(categorie.getId());


        return where.toString();
    }

    private static String genererWhere(ArrayList<Categorie> collectionCategorie) {
        StringBuilder where = new StringBuilder();
        where.append("photo_categorie.id_categorie IN (");
        int i = 0;
        int nombreCategorie = collectionCategorie.size();

        for (Categorie categorie : collectionCategorie) {
            where.append(categorie.getId());
            if (i++ < nombreCategorie - 1) {
                where.append(",");
            }
        }

        return where.append(")").toString();
    }


}
