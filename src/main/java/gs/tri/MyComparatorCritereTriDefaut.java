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
public class MyComparatorCritereTriDefaut implements MyComparatorCritereTri{

    @Override
    public <E extends Comparable> int compareTo(E e1, E e2) {
        
        return e1.compareTo(e2);
    }
    
}
