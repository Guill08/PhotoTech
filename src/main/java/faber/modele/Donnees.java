/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele;


import faber.modele.listener.ListenerTableMouseMotion;
import faber.modele.renderer.Rendu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

/**
 * @author RDEV
 */
public abstract class Donnees extends ArrayList<InterfaceDonnees> {

    protected ArrayList<ColonneTable> collectionColonneTable = new ArrayList<ColonneTable>();
    protected ModeleTable modeleTable;
    protected Table table;
    protected MouseAdapter mouseAdapter;
    protected ArrayList<Integer> collectionNumeroColonne = new ArrayList<Integer>();

    public Donnees(Table table) {
        init(table);

    }

    public void init(Table table) {

        modeleTable = new ModeleTable(this);
        this.table = table;
        this.table.setModel(modeleTable);
        this.table.initaliserColonne(modeleTable);
        this.mouseAdapter = mouseAdapter;
        this.table.addMouseMotionListener(new ListenerTableMouseMotion(this,table,collectionNumeroColonne));

//        this.table.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                int numeroColonne = table.columnAtPoint(e.getPoint());
//                int numeroLigne = table.rowAtPoint(e.getPoint());
//
//                if (testerSiChangerTypeCurseur(numeroColonne)) {
                    table.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                } else {
//                    table.setCursor(new Cursor(0));
//                }
//            }
//        });
    }

    ;

    private boolean testerSiChangerTypeCurseur(int numeroColonne) {
        boolean valeur;
        if (collectionNumeroColonne.contains(numeroColonne)) {
            valeur = true;
        } else {
            valeur = false;
        }


        return valeur;
    }

    public Donnees() {

    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        init(table);
    }

    public ModeleTable getModeleTable() {
        return modeleTable;
    }

    public MouseAdapter getMouseAdapter() {
        return mouseAdapter;
    }

    public void setModeleTable(ModeleTable modeleTable) {

        this.modeleTable = modeleTable;
    }

    public void setMouseAdapter(MouseAdapter mouseAdapter) {
        this.mouseAdapter = mouseAdapter;
        table.addMouseListener(this.mouseAdapter);
    }
    public void mettreAJourTable() {
        modeleTable.fireTableDataChanged();
    }

    public void addIcone(int numeroColonne, Rendu rendu) {
        table.getColumnModel().getColumn(numeroColonne).setCellRenderer(rendu);
        this.collectionNumeroColonne.add(numeroColonne);
    }
    public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public abstract Boolean isCellEditable(int rowIndex, int columnIndex);

    public abstract Class<?> getColumnClass(int columnIndex);

    public abstract ArrayList<ColonneTable> getCollectionColonneTable();

    public ArrayList<Integer> getCollectionNumeroColonne() {
        return collectionNumeroColonne;
    }

}
