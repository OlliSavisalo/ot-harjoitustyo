package solitaire.dao;

/**
 *
 * @author ollisavi
 */
public class Card {
    
    // Card class is used to create all the necessary cards for the deck
    // Variable suit is "Hearts", "Diamonds", "Spades", "Clubs"
    // Variable number is the number of the said suit, always 1-13
    
    public String suit;
    public int number;
    
    // Added if's for testing that all the cards are formed right
    public Card(String suit, int number) {
        if (suit.equals("Hearts") || suit.equals("Diamonds") || suit.equals("Spades") || suit.equals("Clubs")) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException();
        }
        if (number > 0 && number < 14) {
            this.number = number;
        } else {
            throw new IllegalArgumentException();
        }
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
