
package solitaire.ui;

import java.util.*;

/**
 *
 * @author ollis
 */
public class Paaohjelma {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Solitaire solitaire = new Solitaire(input);
        solitaire.startNewGame();
    }
    
}
