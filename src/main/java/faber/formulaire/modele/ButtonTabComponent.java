package faber.formulaire.modele;


import faber.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Component to be used as tabComponent; Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
public class ButtonTabComponent extends JPanel {

    protected final JTabbedPane pane;

    protected ImageIcon iconClosens = Main.getIconTabFermerNonSurvole();
    protected ImageIcon iconCloses = Main.getIconTabFermerSurvole();
    protected ImageIcon iconTitre = Main.getIconTabFermerSurvole();
    protected boolean fermturePossible;
    protected InterfaceActionSurFermetureTab interfaceActionSurFermetureTab;
    protected JLabel lblClose = new JLabel();

    public ButtonTabComponent(final JTabbedPane pane, ImageIcon iconTitre, boolean fermturePossible, InterfaceActionSurFermetureTab interfaceActionSurFermetureTab, String textToolTip) {
        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.fermturePossible = fermturePossible;
        this.iconTitre = iconTitre;
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        setOpaque(false);

        //make JLabel read titles from JTabbedPane
        JLabel label = new JLabel() {
            public String getText() {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }


        };
        this.interfaceActionSurFermetureTab = interfaceActionSurFermetureTab;
        JLabel lblFind = new JLabel();
        lblFind.setPreferredSize(new Dimension(18, 18));
        lblFind.setIcon(iconTitre);
        add(lblFind);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(label);

        lblClose.setIcon(iconClosens);
        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        //JLabel button = new TabButton();
        addListenerLblClose();
        if (fermturePossible) {
            add(lblClose);
            lblClose.setToolTipText(textToolTip);
        }


        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    protected void addListenerLblClose() {
        lblClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int i = pane.indexOfTabComponent(ButtonTabComponent.this);
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

    private class TabButton extends JLabel implements ActionListener {

        public TabButton() {
            int size = 8;

            //setIcon(iconDelete);
            setPreferredSize(new Dimension(size, size));
            setToolTipText("close this tab");
            //Make the button looks the same for all Laf's
            // setUI(new BasicButtonUI());
            //Make it transparent
            // setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            //   setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            //  setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            //   addActionListener(this);

        }

        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(ButtonTabComponent.this);
            if (i != -1) {
                pane.remove(i);
            }
        }

        //we don't want to update UI for this button
        public void updateUI() {
        }

        //paint the cross
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
//            Graphics2D g2 = (Graphics2D) g.create();
//            int delta = 0;
//            //shift the image for pressed buttons
//            g2.setStroke(new BasicStroke(2));
//            if (this.getModel().isRollover()) {
//                g2.setColor(new Color(199,79,80));
//                g2.fillRect(0, 0, getWidth(), getHeight());
//                g2.setColor(Color.WHITE);
//
//
//            }
//
//            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
//            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
//            g2.dispose();
        }
    }

    private final MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            JLabel component = (JLabel) e.getComponent();
            component.setIcon(iconCloses);
//            if (component instanceof AbstractButton) {
//                AbstractButton button = (AbstractButton) component;
//                button.setBorderPainted(false);
//            }
        }

        public void mouseExited(MouseEvent e) {
            JLabel component = (JLabel) e.getComponent();
            component.setIcon(iconClosens);
//            if (component instanceof AbstractButton) {
//                AbstractButton button = (AbstractButton) component;
//                button.setBorderPainted(false);
//            }
        }
    };
}
