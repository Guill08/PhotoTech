package faber.imageClipBoard;

import faber.formulaire.pnlImage.PnlImage;
import org.apache.logging.log4j.LogManager;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
rsi
07/04/2022
13:20
*/
public class ImageClipBoard {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("application");
    //exemple : LOGGER.error( "msg", exception );
    private PnlImage pnlImage;
    private Image imageRedim;
    public ImageClipBoard(PnlImage pnlImage) {
        this.pnlImage = pnlImage;
    }

    public Image getImageFromClipboard()
    {
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
        {
            try
            {
                BufferedImage image =  (BufferedImage) transferable.getTransferData(DataFlavor.imageFlavor);
                pnlImage.setMinimumSize(new Dimension(image.getWidth(),image.getHeight()));
                pnlImage.setMaximumSize(new Dimension(image.getWidth(),image.getHeight()));
                pnlImage.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
                imageRedim=image.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_DEFAULT);
                return imageRedim;
            }
            catch (UnsupportedFlavorException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
        }
        return null;
    }
}
