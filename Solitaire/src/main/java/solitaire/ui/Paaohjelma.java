
package solitaire.ui;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author ollis
 */
public class Paaohjelma {

    /**
     * Main class to call for Solitaire class and start the game.
     * 
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        Solitaire solitaire = new Solitaire(input);
        solitaire.startNewGame();
    }
    
}
