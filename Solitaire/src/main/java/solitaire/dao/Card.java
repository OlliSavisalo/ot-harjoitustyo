package solitaire.dao;

/**
 *
 * @author ollisavi
 */
public class Card {

    public String suit;
    public int number;

    /**
     * Card class is used to create all the necessary cards for the deck. Added
     * if's for testing that all the cards are formed right.
     *
     * @param suit is "Hearts", "Diamonds", "Spades", "Clubs".
     * @param number is the number of the said suit, always 1-13.
     */
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

    /**
     * Get the suit of the card.
     *
     * @return suit
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Get the number of the card.
     *
     * @return number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Get the String of the card.
     *
     * @return String suit + ", " + number
     */
    @Override
    public String toString() {
        return this.suit + ", " + this.number;
    }

}
