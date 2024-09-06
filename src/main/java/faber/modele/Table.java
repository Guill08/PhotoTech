/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele;


import faber.modele.renderer.HeaderRenderer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

/**
 *
 * @author guillaume
 */
public class Table extends JTable {

    private boolean isSelectAllForMouseEvent = true;
    private boolean isSelectAllForActionEvent = true;
    private boolean isSelectAllForKeyEvent = true;
    private int nombreColonneMaxi;
    private Color couleurFond;
    private Color couleurPolice;

    private int nombreBoutonAction;
    private DonneesSimple donneesSimple;
    private ModeleTableSimple modeleTable;



    public Table(Integer hauteurLigne, Color couleurFond, Color couleurPolice, int nombreBoutonAction, boolean selectCell) {
        this.nombreBoutonAction = nombreBoutonAction;
        this.couleurFond = couleurFond;
        this.couleurPolice = couleurPolice;

        this.setRowHeight(hauteurLigne);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setGridColor(new Color(0, 0, 0));
        this.setIntercellSpacing(new Dimension(0, 0));
        this.setShowGrid(false);
        this.setSelectAllForEdit(true);
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(selectCell);


    }

/*    @Override
    public String getToolTipText(@NotNull MouseEvent event) {
        String tip = null;
        java.awt.Point p = event.getPoint();
        int rowIndex = rowAtPoint(p);
        int colIndex = columnAtPoint(p);
        if (colIndex == 10) {
            Commande commande = (Commande) collectionCommande.get(rowIndex);
            return commande.getTypologieEnum().toString();
        } else {
            return super.getToolTipText(event);
        }

    }*/

    public Table(Integer hauteurLigne, Color couleurFond, Color couleurPolice, int nombreBoutonAction, boolean selectCell, DonneesSimple donneesSimple) {
        this.nombreBoutonAction = nombreBoutonAction;
        this.couleurFond = couleurFond;
        this.couleurPolice = couleurPolice;
        this.setRowHeight(hauteurLigne);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setGridColor(new Color(0, 0, 0));
        this.setIntercellSpacing(new Dimension(0, 0));
        this.setShowGrid(false);
        this.setSelectAllForEdit(true);
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(selectCell);
        this.donneesSimple=donneesSimple;
        modeleTable = donneesSimple.getModeleTable();
        init();
    }

    public faber.modele.ModeleTableSimple getModeleTable() {
        return modeleTable;
    }

    public void init() {
        this.setModel(modeleTable);
        this.initaliserColonne(modeleTable);
    }
    public void initaliserColonne(ModeleTable tableModel) {
        TableColumn col;
        TableColumnModel tableColumnModel = this.getColumnModel();
        ArrayList<ColonneTable> CollectionChamp = tableModel.getCollectionChamps();
        nombreColonneMaxi = CollectionChamp.size() - 1;
        for (int i = 0; i < tableColumnModel.getColumnCount(); i++) {

            col = tableColumnModel.getColumn(i);
            col.setHeaderRenderer(new HeaderRenderer(CollectionChamp.get(i).getLargeur(), nombreColonneMaxi, couleurFond, couleurPolice));
            col.setPreferredWidth(CollectionChamp.get(i).getLargeur());

        }
    }
    public void initaliserColonne(ModeleTableSimple tableModel) {
        TableColumn col;
        TableColumnModel tableColumnModel = this.getColumnModel();
        ArrayList<ColonneTable> CollectionChamp = tableModel.getCollectionChamps();
        nombreColonneMaxi = CollectionChamp.size() - 1;
        for (int i = 0; i < tableColumnModel.getColumnCount(); i++) {

            col = tableColumnModel.getColumn(i);
            col.setHeaderRenderer(new HeaderRenderer(CollectionChamp.get(i).getLargeur(), nombreColonneMaxi, couleurFond, couleurPolice));
            col.setPreferredWidth(CollectionChamp.get(i).getLargeur());

        }
    }
    public int getNombreColonneMaxi() {
        return nombreColonneMaxi;
    }

    public int getNombreBoutonAction() {
        return nombreBoutonAction;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Border margin = new EmptyBorder(10, 10, 10, 10);
        JComponent jc = (JComponent) super.prepareRenderer(renderer, row, column);

        if (column == 0) {
            jc.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)), margin));
        } else if (column > 0 && column < nombreColonneMaxi) {

            jc.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(0, 0, 0)), margin));
        } else {
            jc.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(0, 0, 0)), margin));
        }
        return jc;

    }

    public void modifierAlignement(int numeroColonne, int codeAlignement) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(codeAlignement);
        this.getColumnModel().getColumn(numeroColonne).setCellRenderer(rightRenderer);
    }

    public Table(ArrayList<ColonneTable> listeColonne, Integer hauteurLigne) {

        this.setRowHeight(hauteurLigne);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col;
        TableColumnModel tableColumnModel = this.getColumnModel();
        for (int i = 0; i < tableColumnModel.getColumnCount(); i++) {
            col = tableColumnModel.getColumn(i);
            col.setPreferredWidth(listeColonne.get(i).getLargeur());
        }

        this.setShowGrid(true);
        this.setBackground(Color.WHITE);
        this.setSelectAllForEdit(true);
        this.setRowSelectionAllowed(true);
    }

    @Override
    public TableColumn getColumn(@NotNull Object identifier) {
        return super.getColumn(identifier);
    }
/**
     * Constructs a <code>RXTable</code> that is initialized with
     * <code>dm</code> as the data model, <code>cm</code> as the column model,
     * and a default selection model.
     *
     * @param dm the data model for the table
     * @param cm the column model for the table
     */
    /**
     * Constructs a <code>RXTable</code> that is initialized with
     * <code>dm</code> as the data model, <code>cm</code> as the column model,
     * and <code>sm</code> as the selection model. If any of the parameters are
     * <code>null</code> this method will initialize the table with the
     * corresponding default model. The <code>autoCreateColumnsFromModel</code>
     * flag is set to false if <code>cm</code> is non-null, otherwise it is set
     * to true and the column model is populated with suitable
     * <code>TableColumns</code> for the columns in <code>dm</code>.
     *
     * @param dm the data model for the table
     * @param cm the column model for the table
     * @param sm the row selection model for the table
     */
    /**
     * Constructs a <code>RXTable</code> with <code>numRows</code> and
     * <code>numColumns</code> of empty cells using
     * <code>DefaultTableModel</code>. The columns will have names of the form
     * "A", "B", "C", etc.
     *
     * @param numRows the number of rows the table holds
     * @param numColumns the number of columns the table holds
     */
    /**
     * Constructs a <code>RXTable</code> to display the values in the
     * <code>Vector</code> of <code>Vectors</code>, <code>rowData</code>, with
     * column names, <code>columnNames</code>. The <code>Vectors</code>
     * contained in <code>rowData</code> should contain the values for that row.
     * In other words, the value of the cell at row 1, column 5 can be obtained
     * with the following code:
     * <p>
     * <
     * pre>((Vector)rowData.elementAt(1)).elementAt(5);</pre>
     * <p>
     * @param rowData the data for the new table
     * @param columnNames names of each column
     */
    /**
     * Constructs a <code>RXTable</code> to display the values in the two
     * dimensional array, <code>rowData</code>, with column names,
     * <code>columnNames</code>. <code>rowData</code> is an array of rows, so
     * the value of the cell at row 1, column 5 can be obtained with the
     * following code:
     * <p>
     * <
     * pre> rowData[1][5]; </pre>
     * <p>
     * All rows must be of the same length as <code>columnNames</code>.
     * <p>
     * @param rowData the data for the new table
     * @param columnNames names of each column
     */
    public Table(final Object[][] rowData, final Object[] columnNames) {
        super(rowData, columnNames);
    }

    public Table() {

    }

    public Table(Integer hauteurLigne) {

        this.setRowHeight(hauteurLigne);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumn col;
        TableColumnModel tableColumnModel = this.getColumnModel();

        this.setShowGrid(true);
        //this.setBackground(Color.WHITE);
        //this.formulairePrincipal=formulairePrincipal;
//        this.getColumnModel().getColumn(5).setCellRenderer(new RendererBoutonTableOF());
//        this.getColumnModel().getColumn(5).setCellEditor(new EditorBoutonTableOF(new JCheckBox()));
        this.setSelectAllForEdit(true);
        this.setRowSelectionAllowed(true);
        //To change body of generated methods, choose Tools | Templates.
    }
//
//  Overridden methods
//

    /*
	 *  Override to provide Select All editing functionality
     */
    public boolean editCellAt(int row, int column, EventObject e) {
        boolean result = super.editCellAt(row, column, e);

        if (isSelectAllForMouseEvent
                || isSelectAllForActionEvent
                || isSelectAllForKeyEvent) {
            selectAll(e);
        }

        return result;
    }

    /*
	 * Select the text when editing on a text related cell is started
     */
    private void selectAll(EventObject e) {
        final Component editor = getEditorComponent();

        if (editor == null
                || !(editor instanceof JTextComponent)) {
            return;
        }

        if (e == null) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  Typing in the cell was used to activate the editor
        if (e instanceof KeyEvent && isSelectAllForKeyEvent) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  F2 was used to activate the editor
        if (e instanceof ActionEvent && isSelectAllForActionEvent) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  A mouse click was used to activate the editor.
        //  Generally this is a double click and the second mouse click is
        //  passed to the editor which would remove the text selection unless
        //  we use the invokeLater()
        if (e instanceof MouseEvent && isSelectAllForMouseEvent) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ((JTextComponent) editor).selectAll();
                }
            });
        }
    }

//
//  Newly added methods
//
    /*
	 *  Sets the Select All property for for all event types
     */
    public void setSelectAllForEdit(boolean isSelectAllForEdit) {
        setSelectAllForMouseEvent(isSelectAllForEdit);
        setSelectAllForActionEvent(isSelectAllForEdit);
        setSelectAllForKeyEvent(isSelectAllForEdit);
    }

    /*
	 *  Set the Select All property when editing is invoked by the mouse
     */
    public void setSelectAllForMouseEvent(boolean isSelectAllForMouseEvent) {
        this.isSelectAllForMouseEvent = isSelectAllForMouseEvent;
    }

    /*
	 *  Set the Select All property when editing is invoked by the "F2" key
     */
    public void setSelectAllForActionEvent(boolean isSelectAllForActionEvent) {
        this.isSelectAllForActionEvent = isSelectAllForActionEvent;
    }

    /*
	 *  Set the Select All property when editing is invoked by
	 *  typing directly into the cell
     */
    public void setSelectAllForKeyEvent(boolean isSelectAllForKeyEvent) {
        this.isSelectAllForKeyEvent = isSelectAllForKeyEvent;
    }

//
//  Static, convenience methods
//
    /**
     * Convenience method to order the table columns of a table. The columns are
     * ordered based on the column names specified in the array. If the column
     * name is not found then no column is moved. This means you can specify a
     * null value to preserve the current order of a given column.
     *
     * @param table the table containing the columns to be sorted
     * @param columnNames an array containing the column names in the order they
     * should be displayed
     */
    public static void reorderColumns(JTable table, Object... columnNames) {
        TableColumnModel model = table.getColumnModel();

        for (int newIndex = 0; newIndex < columnNames.length; newIndex++) {
            try {
                Object columnName = columnNames[newIndex];
                int index = model.getColumnIndex(columnName);
                model.moveColumn(index, newIndex);
            } catch (IllegalArgumentException e) {
            }
        }
    }

}
