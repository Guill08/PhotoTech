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
public class ModeleTableSimple2 extends AbstractTableModel {

    private ArrayList<ColonneTable> collectionChamps;

    private ModeleDonnees modeleDonnees;


    public ModeleTableSimple2(ModeleDonnees modeleDonnees) {
        this.collectionChamps = modeleDonnees.getCollectionColonneTable();
        this.modeleDonnees = modeleDonnees;
    }
    public ArrayList<ColonneTable> getCollectionChamps() {
        return collectionChamps;
    }

    @Override

    public int getRowCount() {
        return modeleDonnees.getSize();
    }

    @Override
    public int getColumnCount() {
        return collectionChamps.size();

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;

        return modeleDonnees.getValueAt(rowIndex, columnIndex);

    }

    @Override
    public String getColumnName(int column) {
        return collectionChamps.get(column).getNom();

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class classe = String.class;

        return modeleDonnees.getColumnClass(columnIndex);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Boolean valeur = false;
        return modeleDonnees.isCellEditable(rowIndex, columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        modeleDonnees.setValueAt(aValue, rowIndex, columnIndex);

    }
}
