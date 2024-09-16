package faber.objet.photo;

import faber.objet.categorie.Categorie;
import faber.objet.metaDataFile.HashageFile;
import faber.objet.metaDataFile.MetaDataFile;
import faber.objet.miniature.Miniature;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Photo {
    private ImageIcon imageIcon;
    private File file;
    private Miniature miniature;
    private final ArrayList<Categorie> collectionMetaDataFile = new ArrayList<Categorie>();
    private String hashage = "";
    public Photo(File file) throws IOException, NoSuchAlgorithmException {
        this.hashage = HashageFile.calculateFileHash(file, "SHA-256");
        this.file = file;
        this.imageIcon = new ImageIcon(file.getPath());
        this.miniature = new Miniature(this);


    }
    public String getHashage() {
        return hashage;
    }

    public ArrayList<Categorie> getCollectionMetaDataFile() {
        return collectionMetaDataFile;
    }

    public void setHashage(String hashage) {
        this.hashage = hashage;
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
