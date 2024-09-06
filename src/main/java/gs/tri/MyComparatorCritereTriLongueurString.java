/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.tri;

/**
 *
 * @author guillaume
 */
public class MyComparatorCritereTriLongueurString implements MyComparatorCritereTri{

    @Override
    public <E extends Comparable> int compareTo(E e1, E e2) {
      String valeur1 = (String) e1;
       String valeur2 = (String) e2;
       Integer longueurValeur1=valeur1.length();
       Integer longueurValeur2=valeur2.length();
       return longueurValeur1.compareTo(longueurValeur2);
    }
    
}
