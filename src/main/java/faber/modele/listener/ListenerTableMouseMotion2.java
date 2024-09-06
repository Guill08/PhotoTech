package faber.modele.listener;

import faber.modele.ModeleDonnees;
import faber.modele.Table;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class ListenerTableMouseMotion2 implements MouseMotionListener {
    private ModeleDonnees modeleDonnees;
    private Table table;
    private ArrayList<Integer> collectionNumeroColonne = new ArrayList<Integer>();
    public ListenerTableMouseMotion2(ModeleDonnees modeleDonnees, Table table, ArrayList<Integer> collectionNumeroColonne) {
        this.modeleDonnees = modeleDonnees;
        this.table=table;
        this.collectionNumeroColonne = collectionNumeroColonne;

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int numeroColonne = table.columnAtPoint(e.getPoint());
        int numeroLigne = table.rowAtPoint(e.getPoint());
        if ( modeleDonnees.afficherIconePointeurMain(numeroColonne)) {
//            if (testerSiChangerTypeCurseur(numeroColonne)  ) {
                table.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                table.setCursor(new Cursor(0));
            }
//        }


    }

    private boolean testerSiChangerTypeCurseur(int numeroColonne) {
        boolean valeur;
        if (collectionNumeroColonne.contains(numeroColonne)) {
            valeur = true;
        } else {
            valeur = false;
        }
        return valeur;
    }
}
