package faber.modele;

import faber.modele.renderer.Rendu;

import java.util.ArrayList;
@SuppressWarnings("unchecked")
public abstract class DonneesSimple <E> extends ArrayList{
    protected ArrayList<ColonneTable> collectionColonneTable = new ArrayList<ColonneTable>();
    protected ModeleTableSimple modeleTable;
    protected ArrayList<Integer> collectionNumeroColonne = new ArrayList<Integer>();

    public DonneesSimple() {
        modeleTable = new ModeleTableSimple(this);
    }
    public void mettreAJourTable() {
        modeleTable.fireTableDataChanged();
    }
    public void addIcone(int numeroColonne, Rendu rendu,Table table) {
        table.getColumnModel().getColumn(numeroColonne).setCellRenderer(rendu);
        this.collectionNumeroColonne.add(numeroColonne);
    }
    @Override
    public E get(int index) {
        return (E) super.get(index);
    }

    public ModeleTableSimple getModeleTable() {
        return modeleTable;
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
