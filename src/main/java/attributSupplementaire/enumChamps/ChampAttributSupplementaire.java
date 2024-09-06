/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributSupplementaire.enumChamps;

/**
 *
 * @author RDEV
 */
public enum ChampAttributSupplementaire {

    ALPHA("alpha"),
    NUMERIQUE("numerique"),
    DATE("date"),
    HEURE("heure");

    private String name = "";

    //Constructeur
    ChampAttributSupplementaire(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
