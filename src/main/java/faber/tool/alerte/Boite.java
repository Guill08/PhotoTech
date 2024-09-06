/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.tool.alerte;

import faber.main.Main;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class Boite extends JOptionPane{
    
    public static void afficherBoite(String titre, String message, int yesNoOption){
        
        showMessageDialog(null,message , titre, 0);
        
    }
    public static void afficherBoiteAlerte( String titre,String message,Integer type){
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.showMessageDialog(null,message , titre, type, Main.getIconAlert());
        
    }
   public static int afficherBoiteDialogue( String titre,String message,Integer type){
       JOptionPane jOptionPane = new JOptionPane();

       return jOptionPane.showConfirmDialog(null,message , titre,0, type, Main.getIconQuestion48());
        
    }
    public static void afficherBoite(String titre, String message, int yesNoOption,JDialog jDialog){

        showMessageDialog(jDialog,message , titre, 0);

    }
    public Boite() {
        
    }
    
}
