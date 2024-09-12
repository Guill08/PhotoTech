/*
 * Created by JFormDesigner on Tue Sep 10 13:20:11 CEST 2024
 */

package faber.formulaire.pnlTagFichier;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import faber.formulaire.pnlTagFichier.pnlListeCategorie.*;
import faber.main.Main;
import net.miginfocom.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rsi@BAZEILLES.local
 */
public class PnlTagFichier extends JPanel {
    private HashMap<Integer, PnlListeCategorie> collectionPnlListeCategorie = new HashMap<Integer, PnlListeCategorie>();

    public PnlTagFichier() {
        initComponents();
        createUIComponents();
    }

    public HashMap<Integer, PnlListeCategorie> getCollectionPnlListeCategorie() {
        return collectionPnlListeCategorie;
    }

    public JPanel getPnlPnlListeCategorie() {
        return pnlPnlListeCategorie;
    }

    private void createUIComponents() {

        PnlListeCategorie panel1 = new PnlListeCategorie(Main.collectionCategorie, this, 0);
        //   add(panel1, "cell 1 0");
        chargerPhoto();

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
                String inputImagePath = entry.toAbsolutePath().toString();
                String outputImagePath = "\\mini\\" + entry.getFileName().toString();
                int scaledWidth = 150;
                int scaledHeight = 150;
                // Lire l'image d'entrée
                File inputFile = new File(entry.toAbsolutePath().toString());
                BufferedImage inputImage = ImageIO.read(inputFile);
                // Calculer les nouvelles dimensions tout en conservant le ratio d'aspect
                int originalWidth = inputImage.getWidth();
                int originalHeight = inputImage.getHeight();
                int newWidth = originalWidth;
                int newHeight = originalHeight;

                if (originalWidth > originalHeight) {
                    newWidth = maxDim;
                    newHeight = (maxDim * originalHeight) / originalWidth;
                } else {
                    newHeight = maxDim;
                    newWidth = (maxDim * originalWidth) / originalHeight;
                }
                // Crée une nouvelle image redimensionnée
                BufferedImage outputImage = new BufferedImage(newWidth, newHeight, inputImage.getType());

                // Dessiner l'image redimensionnée
                Graphics2D g2d = outputImage.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
                g2d.dispose();
                // Extraire l'extension du fichier à partir du chemin de sortie
                String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

                // Écrire l'image redimensionnée dans le fichier de sortie
                ImageIO.write(outputImage, formatName, new File(outputImagePath));


                // ImageIcon imageIcon = new ImageIcon(entry.toAbsolutePath().toString());
                ImageIcon imageIcon = new ImageIcon("\\mini\\" + entry.getFileName().toString());
                JLabel label1 = new JLabel(imageIcon);
                pnlListePhoto.add(label1);
                pnlListePhoto.add(Box.createRigidArea(new Dimension(60, 0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        pnlPnlListeCategorie = new JPanel();
        scrollPane1 = new JScrollPane();
        pnlListePhoto = new JPanel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== pnlPnlListeCategorie ========
        {
            pnlPnlListeCategorie.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));
        }
        add(pnlPnlListeCategorie, BorderLayout.PAGE_START);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel pnlPnlListeCategorie;
    private JScrollPane scrollPane1;
    private JPanel pnlListePhoto;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
