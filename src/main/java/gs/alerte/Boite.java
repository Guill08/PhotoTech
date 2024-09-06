/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.alerte;

import javax.swing.*;

/**
 *
 * @author RDEV
 */
public class Boite extends JOptionPane{
    
    public static void afficherBoite( String titre,String message){
        
        showMessageDialog(null,message , titre, 0);
        
    }
    public static void afficherBoiteAlerte( String titre,String message,Integer type){
        
        showMessageDialog(null,message , titre, type);
        
    }
   public static int afficherBoiteDialogue( String titre,String message,Integer type){
        
       return showConfirmDialog(null,message , titre, type);
        
    }
    
    public Boite() {
        
    }
    
}
