/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

import faber.modele.renderer.HeaderRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 *
 * @author RDEV
 */
public class CollectionComposantGraphique extends ArrayList<ComposantGraphique> {


    final Logger logger = LoggerFactory.getLogger(CollectionComposantGraphique.class);
    public void miseAJourChamps() {
        for (int i = 0; i < this.size(); i++) {
            ComposantGraphique composantGraphique = this.get(i);
            composantGraphique.updateComposant();

        }
    }

}
