package gs.interfacegraphique;

import gs.objet.FiltreRaz;
import gs.objet.WhereSQL;
import gs.objet.champ.ChampTextDate;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Mon Jul 17 15:46:33 CEST 2017
 */



/**
 * @author Guillaume SUPPIN
 */
public class NewJFormDesignerForm extends JFrame implements FiltreRaz{
    private WhereSQL test;
    private  ComboBoxModel modeleChoix ;
    public NewJFormDesignerForm() {
        
        
        initComponents();
        test= new WhereSQL(ordre,champOrdre);


        test.add(new ChampTextDate("Date",textField3, comboBox3, "champBaseDonnee3",this));

        Personne p1=new Personne("n1", "p1", "id1");
        Personne p2=new Personne("n2", "p2", "id2");
        Personne p3=new Personne("n3", "p3", "id3");
        Personne p4=new Personne("n4", "p4", "id4");
        ArrayList liste = new ArrayList();
        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
        liste.add(p4);
        modeleChoix = new gs.modele.ComboBoxModelGS(liste );
        cbxTestListe.setModel(modeleChoix);
    }

    private void createUIComponents() {


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        comboBox1 = new ComboBoxCritere();
        textField1 = new JTextField();
        champOrdre = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new ComboBoxCritere();
        textField2 = new JTextField();
        ordre = new JComboBox();
        label3 = new JLabel();
        comboBox3 = new ComboBoxCritere();
        textField3 = new JTextField();
        label4 = new JLabel();
        comboBox4 = new ComboBoxCritere();
        cbxTestListe = new JComboBox();

        //======== this ========
        setMinimumSize(new Dimension(150, 39));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 101, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {27, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("String");
        contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(comboBox1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- textField1 ----
        textField1.setMaximumSize(new Dimension(150, 30));
        textField1.setMinimumSize(new Dimension(150, 30));
        textField1.setPreferredSize(new Dimension(150, 22));
        contentPane.add(textField1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(champOrdre, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- label2 ----
        label2.setText("Numeric");
        contentPane.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(comboBox2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- textField2 ----
        textField2.setMaximumSize(new Dimension(150, 30));
        textField2.setMinimumSize(new Dimension(150, 30));
        textField2.setPreferredSize(new Dimension(150, 22));
        contentPane.add(textField2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(ordre, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- label3 ----
        label3.setText("Date");
        contentPane.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(comboBox3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- textField3 ----
        textField3.setMaximumSize(new Dimension(150, 30));
        textField3.setMinimumSize(new Dimension(150, 30));
        textField3.setPreferredSize(new Dimension(150, 22));
        contentPane.add(textField3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("Liste String");
        contentPane.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(comboBox4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(cbxTestListe, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        setSize(665, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private ComboBoxCritere comboBox1;
    private JTextField textField1;
    private JComboBox champOrdre;
    private JLabel label2;
    private ComboBoxCritere comboBox2;
    private JTextField textField2;
    private JComboBox ordre;
    private JLabel label3;
    private ComboBoxCritere comboBox3;
    private JTextField textField3;
    private JLabel label4;
    private ComboBoxCritere comboBox4;
    private JComboBox cbxTestListe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Override
    public void filtrer() {
         try {
             System.out.println(test.creerClauseWhereSQL());
         } catch (ErreurCritereManquant ex) {
             System.out.println("Critère non renseigné");
             //Logger.getLogger(NewJFormDesignerForm.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ErreurValeurIncorrecte ex) {
             System.out.println("Valeur incorrecte");
             
             //Logger.getLogger(NewJFormDesignerForm.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ErreurInterval ex) {
             System.out.println("Erreur d'expression");
             //Logger.getLogger(NewJFormDesignerForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void raz() {
        
    }
}
