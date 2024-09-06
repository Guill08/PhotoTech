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
public class ChampOrderBy {
    private String libelle;
    private String champSQL;
    private String clauseSQL;

    public ChampOrderBy() {
    }
    
    public ChampOrderBy(String libelle, String champSQL) {
        this.libelle = libelle;
        this.clauseSQL = " order by " + champSQL;
    }

    public String getChampSQL() {
        return champSQL;
    }

    public void setChampSQL(String champSQL) {
        
        this.champSQL = champSQL;
        this.clauseSQL = " order by " + champSQL;
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
        return libelle ;
    }
    
    
}
