/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributSupplementaire.bean;

import attributSupplementaire.enumChamps.ChampAttributSupplementaire;

/**
 *
 * @author RDEV
 */
public class AttributSupplementaire {

    private String clef; // exemple : sup_Client_geppia, sup_Client_zone_client
    private String idLigneAModifier; // id de la ligne à modifier
    private String nomChampId; // exemple : id_article, id_client,...
    private String tableAs; // exemple : dm2_client_cs, dm1_ville_cs
    private ChampAttributSupplementaire champAttributSupplementaire; // alpha ou date ou numerique ou date ou heure
    
    private  String valeur;
    public AttributSupplementaire(String clef, String nomChampId, String tableAs, ChampAttributSupplementaire champAttributSupplementaire) {
        this.clef = clef;
        this.nomChampId = nomChampId;
        this.tableAs = tableAs;
        this.champAttributSupplementaire = champAttributSupplementaire;
        
    }

    public void setIdLigneAModifier(String idLigneAModifier) {
        this.idLigneAModifier = idLigneAModifier;
    }

    
    public String getClef() {
        return clef;
    }

    public String getIdLigneAModifier() {
        return idLigneAModifier;
    }

    public String getNomChampId() {
        return nomChampId;
    }

    public String getTableAs() {
        return tableAs;
    }

    public ChampAttributSupplementaire getChampAttributSupplementaire() {
        return champAttributSupplementaire;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    
    
    
}
