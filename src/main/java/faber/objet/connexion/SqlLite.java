package faber.objet.connexion;

import faber.objet.metaDataFile.HashageFile;
import faber.objet.metaDataFile.MetaDataFile;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlLite {

    public SqlLite(String url) {
        // url = "jdbc:sqlite:my.db";
        //jdbc:sqlite:C:/sqlite/db/chinook.db
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }


}
