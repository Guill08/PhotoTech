package faber.formulaire;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.objet.miniature.Miniature;
import faber.objet.photo.Photo;

import javax.swing.*;
import java.awt.*;

public class PnlMiniature extends JPanel {

    private final Miniature miniature;
    private final PnlTagFichier pnlTagFichier;
    private final JLabel lblMiniature = new JLabel();
    private final JToggleButton btnMiniature = new JToggleButton();
    private final ImageIcon imageIconRedimensionnee;


    public PnlMiniature(LayoutManager layout, Photo photo, PnlTagFichier pnlTagFichier) {
        super(layout);

        this.miniature = photo.getMiniature();
        this.pnlTagFichier = pnlTagFichier;

        this.imageIconRedimensionnee = miniature.getImageRedimensionnee();
        lblMiniature.setIcon(imageIconRedimensionnee);

        this.add(lblMiniature, BorderLayout.CENTER);
        this.add(btnMiniature, BorderLayout.SOUTH);
        btnMiniature.setText("Selectionner");
        initialiserListener(btnMiniature);
    }

    private void initialiserListener(JToggleButton btnMiniature) {
        btnMiniature.addActionListener(new ActionListener(btnMiniature));

    }

    class ActionListener implements java.awt.event.ActionListener {
        JToggleButton btnMiniature;

        public ActionListener(JToggleButton btnMiniature) {
            this.btnMiniature = btnMiniature;
        }

        public ActionListener() {
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (btnMiniature.isSelected()) {
                PnlMiniature.this.pnlTagFichier.getCollectionPnlMiniature().add(PnlMiniature.this);
            } else {
                PnlMiniature.this.pnlTagFichier.getCollectionPnlMiniature().remove(PnlMiniature.this);
            }
        }
    }

}
