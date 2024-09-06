package faber.modele;

import java.util.ArrayList;

public abstract class ModeleDonnees {
    protected ArrayList<ColonneTable> collectionColonneTable = new ArrayList<ColonneTable>();
    protected ModeleTableSimple2 modeleTable;
    protected ArrayList<Integer> collectionNumeroColonne = new ArrayList<Integer>();
    protected ArrayList collection;
    protected TableSimple2 table;

    public ModeleDonnees(ArrayList collection) {
        this.collection=collection;
        modeleTable = new ModeleTableSimple2(this);
    }

    public ModeleTableSimple2 getModeleTable() {
        return modeleTable;
    }

    public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public abstract Boolean isCellEditable(int rowIndex, int columnIndex);

    public abstract Class<?> getColumnClass(int columnIndex);

    public abstract ArrayList<ColonneTable> getCollectionColonneTable();

    public abstract boolean afficherIconePointeurMain(int row);
    public ArrayList<Integer> getCollectionNumeroColonne() {
        return collectionNumeroColonne;
    }

    public ArrayList<?> getCollection() {
        return collection;
    }
    public int getSize(){
        return collection.size();
    }

    public TableSimple2 getTable() {
        return table;
    }

    public void setTable(TableSimple2 table) {
        this.table = table;
    }
}
