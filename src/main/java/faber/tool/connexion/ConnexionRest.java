package faber.tool.connexion;

import org.apache.logging.log4j.LogManager;

import java.util.Base64;

/*
RSI
15/02/2024
09:21
*/
public class ConnexionRest {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("application");
    private String user;
    private String baseDonnees;
    private String password;
    private String url;
    private String userAuthentification;
    private String basicAuth;


    public ConnexionRest(String user, String baseDonnees, String password,String url) {
        this.user = user;
        this.baseDonnees = baseDonnees;
        this.password = password;
        this.url = url;


    }

    //exemple : LOGGER.error( "msg", exception );
    public String getUserAuthentification() {
        userAuthentification = user + "@@" + baseDonnees + "@@" + "0000" + ":" + password;
        basicAuth = "Basic " + new String(Base64.getEncoder().encode(userAuthentification.getBytes()));
        return basicAuth;
    }


    public String getUrl() {
        return url;
    }
}
