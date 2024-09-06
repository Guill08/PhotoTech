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
public class MyComboBoxModel <T>extends DefaultComboBoxModel{
    private ArrayList<T> collection ;

    public ArrayList<T> getCollection() {
        return collection;
    }
    
    public MyComboBoxModel(ArrayList<T> collection ) {
        this.collection =collection;
    }
    
    @Override
    public int getSize() {
       return collection.size();
    }

    @Override
    public T getElementAt(int index) {
       return collection.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        super.setSelectedItem(anItem);
    }

    @Override
    public T getSelectedItem() {
         T objet = (T) super.getSelectedItem();
         return objet;
    }

    @Override
    public void removeElementAt(int index) {
        super.removeElementAt(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeElement(Object anObject) {
        super.removeElement(anObject); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addElement(Object anObject) {
        super.addElement(anObject);
        //T objet = (T) anObject;
        //collection.add(objet);
//To change body of generated methods, choose Tools | Templates.
    }

    

    
}
