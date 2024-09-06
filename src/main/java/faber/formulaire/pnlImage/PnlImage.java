package faber.formulaire.pnlImage;

import org.apache.logging.log4j.LogManager;

import javax.swing.*;
import java.awt.*;

/*
rsi
06/04/2022
16:47
*/
public class PnlImage extends JComponent {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("application");
    //exemple : LOGGER.error( "msg", exception );
    private Image image;

    public PnlImage() {
    }

    public void updateImage(Image image ) {
        this.setImage(image);
        this.revalidate();
        this.repaint();
    }

    public PnlImage(Image image) {
        this.image = image;
        /*BufferedImage bImage = new BufferedImage(100,100,BufferedImage.TYPE_CUSTOM);
        bImage.*/
        this.setPreferredSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public void paintComponent(Graphics g) {


        g.drawImage(image, 0, 0, null);
    }
}
