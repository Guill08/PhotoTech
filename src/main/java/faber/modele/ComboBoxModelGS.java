/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele;


import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author guillaume
 */
public class ComboBoxModelGS extends DefaultComboBoxModel{
    private ArrayList collection ;

 

    public ArrayList getCollection() {
        return collection;
    }
    
    public ComboBoxModelGS(ArrayList collection ) {
        this.collection =collection;
    }
    
    @Override
    public int getSize() {
       return collection.size();
    }

    @Override
    public Object getElementAt(int index) {
       return collection.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        super.setSelectedItem(anItem);
    }

    @Override
    public Object getSelectedItem() {
         Object objet =  super.getSelectedItem();
         return objet;
    }

    @Override
    public void removeElementAt(int index) {
        super.removeElementAt(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeElement(Object anObject) {
        super.removeElement(anObject); //To change body of generated methods, choose Tools | Templates.
        collection.remove(anObject);
    }

    @Override
    public void addElement(Object anObject) {
        collection.add(anObject);
        super.addElement(anObject);
        //T objet = (T) anObject;
        //collection.add(objet);
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAllElements() {
        collection.clear();
        super.removeAllElements(); //To change body of generated methods, choose Tools | Templates.
    }
    
}