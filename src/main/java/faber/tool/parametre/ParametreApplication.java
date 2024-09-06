package faber.tool.parametre;


import faber.tool.parametre.dao.DaoParametreApplication;

import java.sql.SQLException;
import java.util.HashMap;

public class ParametreApplication  {


    protected static HashMap<ParametreApplicationEnum,String> collectionParametre = new HashMap<ParametreApplicationEnum,String>();



    public static void initialiserConfiguration() throws SQLException {
        DaoParametreApplication.select(collectionParametre);
    }




    public static HashMap<ParametreApplicationEnum, String> getCollectionParametre() {
        return collectionParametre;
    }

    public static void ajouterParametre(ParametreApplicationEnum parametreApplicationEnum) {
        collectionParametre.put(parametreApplicationEnum, "");
    }
    public static String getValeur(ParametreApplicationEnum parametreApplicationEnum) {
        return  collectionParametre.get(parametreApplicationEnum);
    }

}


