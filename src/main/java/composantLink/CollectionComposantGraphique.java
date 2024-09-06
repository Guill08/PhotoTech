/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

/**
 *
 * @author RDEV
 */
public class CollectionComposantGraphique extends ArrayList<ComposantGraphique> {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(CollectionComposantGraphique.class.getName());

    public void miseAJourChamps() {
        for (int i = 0; i < this.size(); i++) {
            ComposantGraphique composantGraphique = this.get(i);
            composantGraphique.updateComposant();

        }
    }

}
