package faber.modele.listener;

import faber.modele.Donnees;
import faber.modele.InterfaceDonnees;
import faber.modele.Table;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class ListenerTableMouseMotion implements MouseMotionListener {
    private Donnees donnees;
    private Table table;
    private ArrayList<Integer> collectionNumeroColonne = new ArrayList<Integer>();
    public ListenerTableMouseMotion(Donnees donnees, Table table, ArrayList<Integer> collectionNumeroColonne) {
        this.donnees = donnees;
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
        InterfaceDonnees interfaceDonnees = donnees.get(numeroLigne);
        if ( interfaceDonnees.afficherIconePointeurMain(numeroColonne)) {
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
