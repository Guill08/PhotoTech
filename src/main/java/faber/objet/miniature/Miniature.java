package faber.objet.miniature;

import faber.objet.photo.Photo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Miniature {
    private final ImageIcon imageRedimensionnee;
    private final Path  entry;
    private final Photo photo;
       public Miniature(Photo photo) throws IOException {
        this.entry = photo.getFile().toPath();
        this.imageRedimensionnee = creerImageMiniature(photo.getImageIcon());
        this.photo = photo;
       }

    public Path getEntry() {
        return entry;
    }

    public ImageIcon getImageRedimensionnee() {
        return imageRedimensionnee;
    }


    private ImageIcon creerImageMiniature(ImageIcon imageIcon) throws IOException {
        String nomFichier = photo.getHashage();

        String outputImagePath = "data/mini/" + entry.getFileName().toString();
        int scaledWidth = 150;
        int scaledHeight = 150;
        int maxDim = 150;
        int i = 0;
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
        return new ImageIcon("data/mini/" + entry.getFileName().toString());
    }
}
