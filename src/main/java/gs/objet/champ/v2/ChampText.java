package gs.objet.champ.v2;

import gs.objet.champ.v2.interfaceInitComposant.InterfaceInitComposant;
import gs.objet.champ.v2.interfaceListener.InterfaceListener;
import org.apache.commons.lang3.math.NumberUtils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class ChampText extends JTextField {
    private InterfaceListener listener;
    private JTextField textFieldSuivant;
    private JTextField textFieldPrecedent;
    private String bakupValeur = "0";
    private boolean valeurEstModifiee = false;
    private boolean miseEnforme = true;
    private static int precision = 1;
    private boolean activerFocusListener = true;

    public ChampText() {
    }

    public ChampText(InterfaceListener listener, InterfaceInitComposant<String> interfaceInitComposant) {
        this.listener = listener;
        this.setText(interfaceInitComposant.initialserComposant());
        this.addFocusListener(new FocusListenerChampText(this));
        this.addActionListener(new ActionListenerChampText(this));
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==38){
                    textFieldPrecedent.requestFocus();
                }
                if (e.getKeyCode()==40){
                    textFieldSuivant.requestFocus();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
       // modifierToucheChangementFocus();
    }

    public void setTextFieldPrecedent(JTextField textFieldPrecedent) {
        this.textFieldPrecedent = textFieldPrecedent;
    }

    private void modifierToucheChangementFocus(){
        Set keys = this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
        Set newKeys = new HashSet(keys);
        newKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newKeys);
    }
    public void setActiverFocusListener(boolean activerFocusListener) {
        this.activerFocusListener = activerFocusListener;
    }

    public boolean isActiverFocusListener() {
        return activerFocusListener;
    }

    public void setTextFieldSuivant(JTextField textFieldSuivant) {
        this.textFieldSuivant = textFieldSuivant;
    }

    @Override
    public String getText() {
        String valeur = super.getText();
        return valeur;
    }

    @Override
    public void setText(String t) {
        if (!miseEnforme) {
            bakupValeur = t;
        }
        miseEnforme = false;
        super.setText(t);
    }

    private void executerAction() {
        String valeur = this.getText();
        Double valeurTypeDouble = Double.valueOf(valeur);
        Double backupValeurDouble = Double.valueOf(bakupValeur);
        if (NumberUtils.isParsable(valeur)) {
            listener.actionListener();
            this.setBackground(new Color(255, 255, 255));

        } else {
            this.setBackground(new Color(255, 230, 230));
        }
        this.selectAll();
        bakupValeur = valeur;
    //   System.out.println("action");

    }


    private class ActionListenerChampText implements ActionListener {
        ChampText jTextField;

        public ActionListenerChampText(ChampText jTextField) {
            this.jTextField = jTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField.setActiverFocusListener(false);
            jTextField.executerAction();
            jTextField.miseEnFormeValeur();
            textFieldSuivant.requestFocus();

        }
    }

    private class FocusListenerChampText implements FocusListener {
        private ChampText jTextField;

        public FocusListenerChampText(ChampText jTextField) {
            this.jTextField = jTextField;
        }

        @Override
        public void focusGained(FocusEvent e) {

            jTextField.selectAll();

        }

        @Override
        public void focusLost(FocusEvent e) {

            if (!e.isTemporary()) {
                if (jTextField.isActiverFocusListener()) {
                    jTextField.miseEnFormeValeur();
                    jTextField.executerAction();
                } else {
                    jTextField.setActiverFocusListener(true);
                }

            }
        }

    }

    public void miseEnFormeValeur() {

        BigDecimal valeur = new BigDecimal(this.getText()).setScale(ChampText.precision, RoundingMode.UP);
        this.setText(valeur.toPlainString());
        miseEnforme = true;

    }

    public static int getPrecision() {
        return precision;
    }

    public static void setPrecision(int precision) {
        ChampText.precision = precision;
    }
}
