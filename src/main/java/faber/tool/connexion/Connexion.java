/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.connexion;



import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RDEV
 */
public class Connexion {

    private String url;
    private String user;
    private String pwd;
    private Connection connection = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(Connexion.class.getName());
    public Connexion(String url, String user, String pwd) throws SQLException {
        super();
        this.url = url;
        this.user = user;
        this.pwd = pwd;

            this.connection = DriverManager.getConnection(this.url, user, pwd);

      
           
        
       

    }

    public Connexion(String url) {
        super();
        this.url = url;

        try {

            this.connection = DriverManager.getConnection(this.url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public String toString() {
        return url;

    }

}
