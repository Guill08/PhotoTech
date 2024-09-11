/*
 * Created by JFormDesigner on Wed May 23 10:20:37 CEST 2018
 */
package faber.formulaire.mainFormulaire;


import faber.alerte.Boite;

import faber.formulaire.pnlTagFichier.PnlTagFichier;
import faber.imageClipBoard.ImageClipBoard;
import faber.tool.configuration.objet.ConfigurationApplication;
import gs.modele.ComboBoxModelGS;
import gs.objet.erreur.ErreurCritereManquant;
import gs.objet.erreur.ErreurInterval;
import gs.objet.erreur.ErreurValeurIncorrecte;
import org.jdatepicker.impl.JDatePickerImpl;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Guillaume SUPPIN
 */
public class MainFormulaire extends JFrame {

    private PnlTagFichier pnlTagCategorie;
    private ComboBoxModelGS modelLiaison;
    private ComboBoxModelGS modeleDonnees;
    private ComboBoxModelGS modelEdi;
    private ComboBoxModelGS modelArticle;
    private ImageClipBoard imageClipBoard;
    private DateTime dateProgramme;
    private JDatePickerImpl datePicker;


    public MainFormulaire(PnlTagFichier pnlTagFichier) throws SQLException, ErreurCritereManquant, ErreurValeurIncorrecte, ErreurInterval {
        this.pnlTagCategorie = pnlTagFichier;
        initComponents();

        URL urlIconeApplication = getClass().getClassLoader().getResource("png/application.png");

        this.setIconImage(new ImageIcon(urlIconeApplication).getImage());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                DaoOffre.deBloquerOffre(Main.getCodeUtilisateur());
            }
        });
        //  initialiseDatePicker();
        tabbedPane1.add(pnlTagFichier);
    }


    private void createUIComponents() {


    }

    public JMenuItem getMenuItem2() {
        return menuItem2;
    }

    public void setMenuItem2(JMenuItem menuItem2) {
        this.menuItem2 = menuItem2;
    }


    private void menuItem4ActionPerformed(ActionEvent e) {

    }

    private void action(ActionEvent e) {


    }


    private void menuItem3(ActionEvent e) {
        Path currentRelativePath = Paths.get("");
        String pathApplication = currentRelativePath.toAbsolutePath().toString();
        String nomApplication = "DeclarationOf.jar";
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", pathApplication + "\\update\\UpdateApplication.jar", ConfigurationApplication.getVersion(), ConfigurationApplication.getCheminDossierMaj(), pathApplication, nomApplication);
        pb.directory(new File(pathApplication + "\\update\\"));

        try {
            Boite.afficherBoiteAlerte("Mise à jour", "Lors de cette mise à jour, cette application va se fermer automatiquement.", JOptionPane.WARNING_MESSAGE);
            pb.start();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(MainFormulaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem2 = new JMenuItem();
        scrollPane3 = new JScrollPane();
        tabbedPane1 = new JTabbedPane();

        //======== this ========
        setTitle("PhotoTech");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200, 200));
        setIconImage(null);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Outils");

                //---- menuItem1 ----
                menuItem1.setText("Configuration");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/png/configuration.png")));
                menuItem1.addActionListener(e -> action(e));
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("Mettre \u00e0 jour");
                menuItem3.setIcon(new ImageIcon(getClass().getResource("/png/upgrade.png")));
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("Aide");

                //---- menuItem2 ----
                menuItem2.setText("180424.1");
                menuItem2.setIcon(new ImageIcon(getClass().getResource("/png/question.png")));
                menu3.add(menuItem2);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(tabbedPane1);
        }
        contentPane.add(scrollPane3);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem2;
    private JScrollPane scrollPane3;
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
