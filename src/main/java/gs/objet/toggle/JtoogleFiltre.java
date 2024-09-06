package gs.objet.toggle;

import gs.objet.FiltreRaz;
import org.apache.logging.log4j.LogManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
RSI
19/09/2023
11:25
*/
public class JtoogleFiltre extends JToggleButton {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("application");
    //exemple : LOGGER.error( "msg", exception );
    private String requete = "";

    public JtoogleFiltre(String text, Icon icon) {
        super(text, icon);
    }

    public JtoogleFiltre() {
    }

    public String getRequete() {
        return requete;
    }

    public void setRequete(String requete) {
        this.requete = requete;
    }
    public void initialiserListener(FiltreRaz filtreRaz) {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreRaz.filtrer();
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    filtreRaz.raz();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
