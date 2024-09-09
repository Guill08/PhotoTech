package faber.tool.rest;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import faber.tool.connexion.ConnexionRest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/*
RSI
14/02/2024
07:31
*/
public class Rest<E extends InterfaceRestPostTraitement> {

    //exemple : LOGGER.error( "msg", exception );

    private TrustManager[] trustAllCerts;
    private SSLContext sc;
    private HostnameVerifier allHostsValid = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    private OkHttpClient client;
    private Request request;
    private Response response;
    private String basicAuth;
    private String userAuthentification;
    private Moshi moshi = new Moshi.Builder().build();


    public Rest(ConnexionRest connexionRest, String codeRequete, String parametre) throws NoSuchAlgorithmException, KeyManagementException {
        initialiserConfigurationSSL();
        basicAuth = connexionRest.getUserAuthentification();
        initialiserClientOKhttp();
        initialiserRequete(connexionRest.getUrl(), codeRequete, parametre);
    }

    public void postTraitement(InterfaceRestPostTraitement interfaceRestPostTraitement) {
        interfaceRestPostTraitement.postTraitement();

    }

    public ArrayList<E> factory(Class classe) {
        ArrayList<E> collection = traiterJson(classe);
        return collection;
    }

    public ArrayList<E> factory(Class classe, Object object, BindingGroup bindingGroup) {
        ArrayList<E> collection = traiterJson(classe);
        mettreAjourBinding(object, bindingGroup, collection);
        return collection;
    }

    @NotNull
    private ArrayList<E> traiterJson(Class classe) {
        ArrayList<E> collection = new ArrayList<E>();
        try {
            response = client.newCall(request).execute();

            JSONObject json = new JSONObject(response.body().string());
            JSONArray jsonArray = json.getJSONArray("resultatQueryWS");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonNiveau1 = jsonArray.getJSONObject(i);
                JSONObject jsonNiveau2 = jsonNiveau1.getJSONObject("ligneResultatWS");
                JsonAdapter<E> jsonAdapter = moshi.adapter(classe);
                E e = jsonAdapter.fromJson(jsonNiveau2.toString());
                e.postTraitement(jsonNiveau2);
                collection.add(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return collection;
    }

    private static <E> void mettreAjourBinding(Object object, BindingGroup bindingGroup, ArrayList<E> collection) {
        if (collection.size() == 1) {
            for (Binding binding : bindingGroup.getBindings()) {
                binding.unbind();
                if (binding.getTargetObject().equals(object)) {
                    binding.setSourceObject(collection.get(0));
                }
                binding.bind();
            }
        }
    }

    private void initialiserRequete(String url, String codeRequete, String parametre) {
        String separateurParametre = "";
        if (!parametre.isEmpty()) {
            separateurParametre = "&";
        }
        request = new Request.Builder().url(url + codeRequete + "/" + "resultat?structureDonnee=2" + separateurParametre + parametre).get()
                .addHeader("Authorization", basicAuth)
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    private void initialiserClientOKhttp() {
        client = new OkHttpClient.Builder().hostnameVerifier(allHostsValid).sslSocketFactory(sc.getSocketFactory(), new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }).build();
    }

    private void initialiserConfigurationSSL() throws NoSuchAlgorithmException, KeyManagementException {
        trustAllCerts = new TrustManager[]{new X509TrustManager() {
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
        }};

        sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
    }


}
