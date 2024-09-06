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
public class CritereInterval extends Critere {

    public CritereInterval(String libelle, String code, int ordre, String codeSQL) {
        super(libelle, code, ordre, codeSQL);
    }

    @Override
    public String getCodeSQL(String valeurChamp, ChampAbstractText champ) throws ErreurValeurIncorrecte, ErreurInterval {
            String valeur="";
            String tableauValeurChamp[] = valeurChamp.split(" et ");
            if (tableauValeurChamp.length==1){
                throw new ErreurInterval();
            } else {
                String valeur1 = tableauValeurChamp[0];
                String valeur2 = tableauValeurChamp[1]; 
                champ.testerTypeValeur(valeur1);
                champ.testerTypeValeur(valeur2);
                valeur=codeSQL.replace("#1", valeur1).replace("#2", valeur2);
            }
            return valeur; //To change body of generated methods, choose Tools | Templates.
       
        
    }

}
