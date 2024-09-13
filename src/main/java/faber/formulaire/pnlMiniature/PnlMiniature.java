package faber.formulaire.pnlMiniature;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.objet.metaDataFile.HashageFile;
import faber.objet.miniature.Miniature;
import faber.objet.photo.Photo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class PnlMiniature extends JPanel {

    private final Miniature miniature;
    private final Photo photo;
    private final PnlTagFichier pnlTagFichier;
    private final JLabel lblMiniature = new JLabel();
    private final JToggleButton btnMiniature = new JToggleButton();
    private final ImageIcon imageIconRedimensionnee;


    public PnlMiniature(LayoutManager layout, Photo photo, PnlTagFichier pnlTagFichier) {
        super(layout);

        this.miniature = photo.getMiniature();
        this.photo = photo;
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
                PnlMiniature.this.pnlTagFichier.getCollectionPhoto().add(photo);
                try {
                    photo.setHashage(HashageFile.calculateFileHash(photo.getFile().getPath(),"SHA-256"));
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                PnlMiniature.this.pnlTagFichier.getCollectionPhoto().remove(photo);
            }
        }
    }

}
