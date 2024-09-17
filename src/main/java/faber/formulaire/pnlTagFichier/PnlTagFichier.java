/*
 * Created by JFormDesigner on Tue Sep 10 13:20:11 CEST 2024
 */

package faber.formulaire.pnlTagFichier;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import faber.formulaire.pnlMiniature.PnlMiniature;
import faber.formulaire.pnlListeCategorie.*;
import faber.main.Main;
import faber.objet.categorie.Categorie;
import faber.objet.photo.Photo;
import faber.objet.photo.dao.DaoPhoto;
import net.miginfocom.swing.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlTagFichier extends JPanel {
    private HashMap<Integer, PnlListeCategorie> collectionPnlListeCategorie = new HashMap<Integer, PnlListeCategorie>();
    private ArrayList<Photo> collectionPhoto = new ArrayList<Photo>();
    private ArrayList<Categorie> collectionCategorieSelectionnees = new ArrayList<Categorie>();

    public PnlTagFichier() {
        initComponents();
        initialiserPnlCategorie();
    }

    protected void initialiserPnlCategorie() {
        PnlListeCategorie panel1 = new PnlListeCategorie(Main.collectionCategorie, this, 0);
        panel1.afficherToggleBoutonCategorie();

        chargerPhoto();
    }

    public ArrayList<Categorie> getCollectionCategorieSelectionnees() {
        return collectionCategorieSelectionnees;
    }

    public ArrayList<Photo> getCollectionPhoto() {
        return collectionPhoto;
    }

    public HashMap<Integer, PnlListeCategorie> getCollectionPnlListeCategorie() {
        return collectionPnlListeCategorie;
    }

    public JPanel getPnlPnlListeCategorie() {
        return pnlListeCategorie;
    }

    public void createUIComponents() {
        btnValiderTag = new JButton();
        btnValiderTag.setText("Valider");


        // TODO: add custom component creation code here
    }

    private void chargerPhoto() {
        Path path = Paths.get("data");
        /**/
        Component component = Box.createRigidArea(new Dimension(60, 0));

/*        pnlListePhoto.add(Box.createRigidArea(new Dimension(60,0)));
        JLabel label2 = new JLabel("test2");
        pnlListePhoto.add(label2);
        pnlListePhoto.add(Box.createRigidArea(new Dimension(60,0)));
        JLabel label3 = new JLabel("test3");
        pnlListePhoto.add(label3);*/
        int maxDim = 150;
        int i = 0;
        // Try-with-resources to ensure the DirectoryStream is closed
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                File file = entry.toFile();
                if (!file.isDirectory()) {

                    Photo photo = new Photo(file);
                    pnlListePhoto.add(new PnlMiniature(new BorderLayout(), photo, this));
                    pnlListePhoto.add(Box.createRigidArea(new Dimension(60, 0)));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void button1(ActionEvent e) {
        for (Photo photo : collectionPhoto) {
            try {
                DaoPhoto.insert(Main.getConnectionSqlLite(),photo);
                for (Categorie categorie : collectionCategorieSelectionnees) {
                    DaoPhoto.insertCategorie(Main.getConnectionSqlLite(),photo,categorie);

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        pnlListeCategorie = new JPanel();
        scrollPane1 = new JScrollPane();
        pnlListePhoto = new JPanel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== pnlListeCategorie ========
        {
            pnlListeCategorie.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));
        }
        add(pnlListeCategorie, BorderLayout.PAGE_START);

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(300, 300));
            scrollPane1.setMaximumSize(new Dimension(300, 300));

            //======== pnlListePhoto ========
            {
                pnlListePhoto.setMaximumSize(new Dimension(300, 300));
                pnlListePhoto.setPreferredSize(new Dimension(300, 300));
                pnlListePhoto.setMinimumSize(new Dimension(300, 300));
                pnlListePhoto.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
            scrollPane1.setViewportView(pnlListePhoto);
        }
        add(scrollPane1, BorderLayout.CENTER);

        //---- btnValiderTag ----
        btnValiderTag.setText("Appliquer");
        btnValiderTag.addActionListener(e -> button1(e));
        add(btnValiderTag, BorderLayout.PAGE_END);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel pnlListeCategorie;
    private JScrollPane scrollPane1;
    private JPanel pnlListePhoto;
    private JButton btnValiderTag;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
