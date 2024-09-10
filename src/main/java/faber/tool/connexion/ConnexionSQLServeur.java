/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.connexion;

import faber.tool.alerte.Alerte;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RDEV
 */
public class ConnexionSQLServeur {

    private String url;
    private String user;
    private String pwd;
    private Connection connection = null;


    public ConnexionSQLServeur(String url, String user, String pwd) throws SQLException {
        super();
        this.url = url;
        this.user = user;
        this.pwd = pwd;

       
            this.connection = DriverManager.getConnection(this.url, user, pwd);

      
           
        
       

    }

    public ConnexionSQLServeur(String url) {
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
