package faber.modele;

import javax.swing.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RDEV
 */
public class MyListBoxModel   <T> extends AbstractListModel {
    private ArrayList<T> collection ;
    
    public MyListBoxModel(ArrayList<T> collection ) {
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
    public void update() {
        this.fireContentsChanged(this,0,collection.size()-1);
    }
//    public void addElement(Object anObject) {
//        super.addElement(anObject);
//        T objet = (T) anObject;
//        collection.add(objet);
//To change body of generated methods, choose Tools | Templates.
//    }
}
