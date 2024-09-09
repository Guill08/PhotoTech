/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool;


import faber.tool.connexion.ConnexionSQLServeur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.Nullable;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author RDEV
 */
public class Outils {
    final Logger logger = LoggerFactory.getLogger(Outils.class);


    public static DateTime SqlDateTodateTimeNull(@Nullable Date dateSql) {
        DateTime dt = null;
        if (dateSql != null) {
            dt = new DateTime(dateSql.getTime());
        }


        return dt;
    }

    public static Double transformerStringEnDouble(String valeurString) {
        Double valeur = 0d;
        if (valeurString.equals("")) {
            return 0d;
        } else {
            return valeur;
        }
    }

    public static boolean transformerStringEnBooleen(String valeurString) {
        if (valeurString.equals("0") || valeurString.equals("") || valeurString == null) {
            return false;
        } else {
            return true;
        }
    }


    public static String miseEnFormeDate(int nombre) {
        String valeur = "";
        if (nombre <= 9) {
            valeur = "0" + String.valueOf(nombre);
        } else {
            valeur = String.valueOf(nombre);
        }

        return valeur;

    }

    public static DateTime stringToDateTime(String txt) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime date = formatter.parseDateTime(txt);
        return date;
    }

    public static String dateTimeToString(DateTime date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date.toDate());
    }

    public static int findIdAutoIncrement(PreparedStatement pStat, int numeroColonne) throws SQLException {
        int valeur = 0;
        ResultSet rs = pStat.getGeneratedKeys();
        while (rs.next()) {
            valeur = rs.getInt(numeroColonne);
        }
        return valeur;
    }

    public static Date dateTimeToSqlDate(DateTime dt) {
        Date dateSql = new Date(dt.toDate().getTime());

        return dateSql;
    }

    public static DateTime SqlDateTodateTime(@Nullable Date dateSql) {
        DateTime dt = null;
        if (dateSql != null) {
            dt = new DateTime(dateSql.getTime());
        }


        return dt;
    }

    public static BigDecimal creerBigDecimal(double valeur, int precision) {
        BigDecimal bg = new BigDecimal(valeur);
        bg = bg.setScale(precision, RoundingMode.HALF_UP);
        return bg;
    }

    public static BigDecimal formaterBigDecimal(BigDecimal valeur) {
        valeur = valeur.setScale(0, RoundingMode.UP);
        valeur = valeur.setScale(1);
        return valeur;
    }

    public static String convertirValeurNullString(@Nullable String valeurATester, String valeurRemplacement) {
        String valeur = valeurRemplacement;
        if (valeurATester != null) {
            return valeurATester;
        } else {
            return valeurRemplacement;
        }

    }

    public static int mettreFormatMilliseconde(Double temps) {
        double tempsEnSeconde = 3600 * temps * 1000;
        int tempsEnSecondeInt = (int) tempsEnSeconde;
        return tempsEnSecondeInt;
    }


}
