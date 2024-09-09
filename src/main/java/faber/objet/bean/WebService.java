package faber.objet.bean;

import faber.tool.connexion.ConnexionSQLServeur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Base64;

/*
RSI
08/03/2022
17:02
*/
public class WebService {
    final Logger logger = LoggerFactory.getLogger(WebService.class);
//exemple : LOGGER.error( "msg", exception );



    public static   HttpURLConnection appellerWebService(String urlWebService, String json, String type,
                                                 String userWS, String passwordWS, String baseDonneeWS) throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{ new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        URL url = null;
        HttpURLConnection connexion = null;

        try {
            url = new URL(urlWebService);
        } catch (MalformedURLException e1) {

        }

        try {
            connexion = (HttpURLConnection) url.openConnection();

        } catch (IOException e1) {

        }

        String userAuthentification =
                userWS + "@@" + baseDonneeWS + "@@" + "0000" + ":" + passwordWS;
        String basicAuth =
                "Basic " + new String(Base64.getEncoder().encode(userAuthentification.getBytes()));

        connexion.setRequestProperty("Authorization", basicAuth);
        connexion.setRequestMethod(type);
        connexion.setRequestProperty("Accept", "application/json");
        connexion.setRequestProperty("Content-Type", "application/json");
        connexion.setDoInput(true);

        if (json != null && json != "") {

            OutputStream os;
            try {
                connexion.setDoOutput(true);

                os = connexion.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                osw.write(json);
                osw.flush();
                osw.close();
                os.close();
            } catch (IOException e1) {

            }
        }

        if (connexion.getResponseCode() < 200 || connexion.getResponseCode() > 300) {
            String error = "";
            try {
                error =
                        new BufferedReader(new InputStreamReader(connexion.getErrorStream()))
                                .readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new Exception("Erreur impossible à se connecter sur Sylob ==> " + error);
        }
        return connexion;
    }
}
