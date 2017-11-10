/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie.test;

import java.util.ArrayList;
import magiemagie.Carte;
import org.junit.Test;

/**
 *
 * @author Administrateur
 */
public class RemoveTest {
    
    @Test
    public void removeOK(){
        
        ArrayList<Carte> cartes = new ArrayList<>();
        
        Carte c1 = new Carte();
        c1.setType(Carte.TypeCarte.MANDRAGORE);
        cartes.add(c1);
        
        Carte c2 = new Carte();
        c2.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
        cartes.add(c2);
        
        Carte c3 = new Carte();
        c3.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
        cartes.add(c3);
        
        Carte carteSortA = new Carte();
        carteSortA.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
        
        cartes.remove(carteSortA);
        System.out.println( cartes );
    }
}
