package faber.formulaire.modele;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonTabComponentFeuilleCalcul extends ButtonTabComponent {
    public ButtonTabComponentFeuilleCalcul(JTabbedPane pane, ImageIcon iconTitre, boolean fermturePossible, InterfaceActionSurFermetureTab interfaceActionSurFermetureTab, String textToolTip) {
        super(pane, iconTitre, fermturePossible, interfaceActionSurFermetureTab, textToolTip);
    }

    @Override
    protected void addListenerLblClose() {

        lblClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int i = pane.indexOfTabComponent(ButtonTabComponentFeuilleCalcul.this);
                    if (i != -1) {
                        interfaceActionSurFermetureTab.actionSurFermetureTab(pane, i);

                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel component = (JLabel) e.getComponent();
                component.setIcon(iconCloses);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel component = (JLabel) e.getComponent();
                component.setIcon(iconClosens);
            }
        });

    }
}

