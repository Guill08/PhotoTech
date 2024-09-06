/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.orderBy;

/**
 *
 * @author RDEV
 */
public class SensOrdre {
    private String libelle;
    private String clauseSQL;

    public SensOrdre(String libelle, String clauseSQL) {
        this.libelle = libelle;
        this.clauseSQL = clauseSQL;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getClauseSQL() {
        return clauseSQL;
    }

    public void setClauseSQL(String clauseSQL) {
        this.clauseSQL = clauseSQL;
    }

    @Override
    public String toString() {
        return  libelle ;
    }
    
}
