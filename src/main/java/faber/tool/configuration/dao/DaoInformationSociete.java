package faber.tool.configuration.dao;

import faber.main.Main;
import faber.tool.configuration.objet.InformationSociete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoInformationSociete {
    public static InformationSociete select() {
        InformationSociete informationSociete = new InformationSociete();


        String requete = "select " +
                "adresse, " +
                "code_postal, " +
                "information_societe, " +
                "telephone_standard, " +
                "numero_intra_comm, " +
                "ville, " +
                "siret, " +
                "capital, " +
                "telephone_fax, " +
                "mail, " +
                "tva, " +
                "chemin_affaire, " +
                "chemin_log, " +
                "chemin_dossier_affaire_modele, " +
                "condition_generale, " +
                "objectif, " +
                "chemin_cgv, " +
                "numero_serie, " +
                "condition_generale_fichier, " +
                "raison_sociale, " +
                "initiales, " +
                "validite_offre, " +
                "logistique  " +
                "from information_societe ";

        Connection connection = Main.getConnexionServeur().getConnection();
        try {
            PreparedStatement pStat = connection.prepareCall(requete);

            ResultSet rs = pStat.executeQuery();
            while (rs.next()) {

                informationSociete.setCheminAffaire(rs.getString("chemin_affaire"));
                informationSociete.setAdresse(rs.getString("adresse"));
                informationSociete.setCodePostal(rs.getString("code_postal"));
                informationSociete.setInformationSociete(rs.getString("information_societe"));
                informationSociete.setTelephoneStandard(rs.getString("telephone_standard"));
                informationSociete.setNumeroIntraComm(rs.getString("numero_intra_comm"));
                informationSociete.setVille(rs.getString("ville"));
                informationSociete.setSiret(rs.getString("siret"));
                informationSociete.setCapital(rs.getString("capital"));
                informationSociete.setTelephoneFax(rs.getString("telephone_fax"));
                informationSociete.setMail(rs.getString("mail"));
                informationSociete.setTva(rs.getString("tva"));
                informationSociete.setCheminLog(rs.getString("chemin_log"));
                informationSociete.setCheminDossierAffaireModele(rs.getString("chemin_dossier_affaire_modele"));
                informationSociete.setConditionGenerale(rs.getString("condition_generale"));
                informationSociete.setObjectif(rs.getDouble("objectif"));
                informationSociete.setCheminCgv(rs.getString("chemin_cgv"));
                informationSociete.setNumeroSerie(rs.getInt("numero_serie"));
                informationSociete.setConditionGeneraleFichier(rs.getString("condition_generale_fichier"));
                informationSociete.setRaisonSociale(rs.getString("raison_sociale"));
                informationSociete.setInitiales(rs.getString("initiales"));
                informationSociete.setValiditeOffre(rs.getString("validite_offre"));
                informationSociete.setLogistique(rs.getString("logistique"));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return informationSociete;

    }
}
