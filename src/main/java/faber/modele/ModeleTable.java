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
public class ModeleTable extends AbstractTableModel {

    private ArrayList<ColonneTable> collectionChamps;
    private faber.modele.Donnees donnees;
    private faber.modele.DonneesSimple donneesSimple;
    @SuppressWarnings("unchecked")
    public ModeleTable(Donnees donnees) {
        this.collectionChamps = donnees.getCollectionColonneTable();
        this.donnees = donnees;
    }
    public ModeleTable(DonneesSimple donneesSimple) {
        this.collectionChamps = donneesSimple.getCollectionColonneTable();
        this.donneesSimple = donneesSimple;
    }
    public ArrayList<ColonneTable> getCollectionChamps() {
        return collectionChamps;
    }

    @Override
    public int getRowCount() {
        return donnees.size();
    }

    @Override
    public int getColumnCount() {
        return collectionChamps.size();

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;

        return donnees.getValueAt(rowIndex, columnIndex);

    }

    @Override
    public String getColumnName(int column) {
        return collectionChamps.get(column).getNom();

    }
    @SuppressWarnings("unchecked")
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class classe = String.class;

        return donnees.getColumnClass(columnIndex);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Boolean valeur = false;
        return donnees.isCellEditable(rowIndex, columnIndex);
    }
    @SuppressWarnings("unchecked")
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        donnees.setValueAt(aValue, rowIndex, columnIndex);

    }
}
