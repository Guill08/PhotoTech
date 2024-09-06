/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author guillaume
 */
@SuppressWarnings("unchecked")
public class ModeleTableSimple extends AbstractTableModel {

    private ArrayList<ColonneTable> collectionChamps;

    private DonneesSimple donneesSimple;

    public ModeleTableSimple(Donnees donnees) {
        this.collectionChamps = donnees.getCollectionColonneTable();
        this.donneesSimple = donneesSimple;
    }
    public ModeleTableSimple(DonneesSimple donneesSimple) {
        this.collectionChamps = donneesSimple.getCollectionColonneTable();
        this.donneesSimple = donneesSimple;
    }
    public ArrayList<ColonneTable> getCollectionChamps() {
        return collectionChamps;
    }

    @Override

    public int getRowCount() {
        return donneesSimple.size();
    }

    @Override
    public int getColumnCount() {
        return collectionChamps.size();

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;

        return donneesSimple.getValueAt(rowIndex, columnIndex);

    }

    @Override
    public String getColumnName(int column) {
        return collectionChamps.get(column).getNom();

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class classe = String.class;

        return donneesSimple.getColumnClass(columnIndex);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Boolean valeur = false;
        return donneesSimple.isCellEditable(rowIndex, columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        donneesSimple.setValueAt(aValue, rowIndex, columnIndex);

    }
}
