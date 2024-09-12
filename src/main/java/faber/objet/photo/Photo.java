package faber.objet.photo;

import faber.objet.miniature.Miniature;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Photo {
    private ImageIcon imageIcon;
    private File file;
    private Miniature miniature;
    public Photo(File file) throws IOException {
        this.file = file;
        this.imageIcon = new ImageIcon(file.getPath());
        this.miniature = new Miniature(imageIcon,file.toPath());

    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public File getFile() {
        return file;
    }

    public Miniature getMiniature() {
        return miniature;
    }


}
