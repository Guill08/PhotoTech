/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faber.modele;

/**
 *
 * @author RDEV
 */
public class ColonneTable {
    private String nom;
    private Integer largeur;

    public ColonneTable(String nom, Integer largeur) {
        this.nom = nom;
        this.largeur = largeur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public String getNom() {
        return nom;
    }
    
}
