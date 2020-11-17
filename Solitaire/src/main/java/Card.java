/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ollisavi
 */
public class Card {
    
    // Card class is used to create all the necessary cards for the deck
    // Variable suit is "Hearts", "Diamonds", "Spades", "Clubs"
    // Variable number is the number of the said suit, always 1-13
    
    String suit;
    int number;
    
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    @Override
    public String toString() {
        return this.suit + ", " + this.number;
    }
    
}
