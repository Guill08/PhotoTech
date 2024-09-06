package gs.objet;

import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;
import org.apache.logging.log4j.LogManager;

/*
RSI
10/10/2023
10:32
*/
public class WhereSQLManuel extends WhereSQL{
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("application");
//exemple : LOGGER.error( "msg", exception );

    @Override
    public String creerClauseWhereSQL() throws ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
        return " commande.code like '%'";
    }

    @Override
    public String creerClauseOrderBy() {
        return "";
    }
}
