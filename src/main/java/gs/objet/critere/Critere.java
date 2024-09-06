/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.objet.critere;

import gs.objet.champ.ChampAbstractText;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;

/**
 *
 * @author RDEV
 */
public class Critere {

    protected String libelle;
    protected String code;
    protected int ordre;
    protected String codeSQL;

    public Critere(String libelle, String code, int ordre, String codeSQL) {
        this.libelle = libelle;
        this.code = code;
        this.ordre = ordre;
        this.codeSQL = codeSQL;
    }

    @Override
    public String toString() {
        return libelle;
    }

    public String getCodeSQL(String valeurChamp, ChampAbstractText champ) throws ErreurValeurIncorrecte, ErreurInterval {
        champ.testerTypeValeur(valeurChamp);
        return codeSQL.replace("#1", valeurChamp);
    }

    public String getCodeSQL(String valeurChamp) throws ErreurValeurIncorrecte, ErreurInterval {
        return   codeSQL.replace("#1", valeurChamp);
    }

}
