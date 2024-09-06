/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele.renderer;

import org.apache.logging.log4j.LogManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 *
 * @author rdev
 */
public class HeaderRenderer extends JLabel implements TableCellRenderer {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(HeaderRenderer.class.getName());
    private int largeur;
    private int nombreMaxiColonne;
    private Color couleurFond = Color.WHITE;
    private Color couleurPolice = Color.BLACK;

    public HeaderRenderer(int largeur, int nombreMaxiColonne) {
        this.largeur = largeur;
        this.nombreMaxiColonne = nombreMaxiColonne;
    }

    public HeaderRenderer(int largeur, int nombreMaxiColonne, Color couleurFond, Color couleurPolice) {
        this.largeur = largeur;
        this.nombreMaxiColonne = nombreMaxiColonne;
        this.couleurFond = couleurFond;
        this.couleurPolice = couleurPolice;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setOpaque(true);
        this.setFont(new Font("Tahoma", Font.BOLD, 11));
        this.setForeground(couleurPolice);
        setPreferredSize(new Dimension(largeur, 30));
        setText(value.toString());
        //setBorder(BorderFactory.createLineBorder(new Color(240,240,240), 2));
        Border margin = new EmptyBorder(10, 10, 10, 10);
        if (column == 0) {
            setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)), margin));
        } else {
            if (column < nombreMaxiColonne) {
                setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, new Color(0, 0, 0)), margin));
            } else {
                setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(0, 0, 0)), margin));
            }

        }

        setBackground(couleurFond);

        return this;
    }
}
