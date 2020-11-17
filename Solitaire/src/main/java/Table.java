import java.util.*;

/**
 *
 * @author ollisavi
 */
public class Table {
    // When called, table class creates full table with the Solitaire schematic
    // In Solitaire we need a lot of different size lists which are made using deques, since they are effective and easy to use
    ArrayDeque<Card> mainDeck;
    // Final decks are the ones we want to have our cards in.
    ArrayDeque<Card> finalDeckHearts;
    ArrayDeque<Card> finalDeckDiamonds;
    ArrayDeque<Card> finalDeckSpades;
    ArrayDeque<Card> finalDeckClubs;
    // In the table we have 7 different decks
    ArrayDeque<Card> tableDeck1;
    ArrayDeque<Card> tableDeck2;
    ArrayDeque<Card> tableDeck3;
    ArrayDeque<Card> tableDeck4;
    ArrayDeque<Card> tableDeck5;
    ArrayDeque<Card> tableDeck6;
    ArrayDeque<Card> tableDeck7;
    
    public Table() {
        // In mainDeck we want to have the whole shuffled deck and we can start dealing cards from there
        // Any leftover cards will be used as the "hand deck" during the game
        Deck d = new Deck();
        mainDeck = d.getShuffledDeck();
        finalDeckHearts = new ArrayDeque<>();
        finalDeckDiamonds = new ArrayDeque<>();
        finalDeckSpades = new ArrayDeque<>();
        finalDeckClubs = new ArrayDeque<>();
        tableDeck1 = new ArrayDeque<>();
        tableDeck2 = new ArrayDeque<>();
        tableDeck3 = new ArrayDeque<>();
        tableDeck4 = new ArrayDeque<>();
        tableDeck5 = new ArrayDeque<>();
        tableDeck6 = new ArrayDeque<>();
        tableDeck7 = new ArrayDeque<>();
    }
    
    public void startDeal() {
        // Since we know that we will deal total of 28 cards, we can loop this
        // Normally table decks are dealt this way: 1st cards of all table decks, 2nd cards of decks 2 to 7, 3rd cards of decks 3 to 7 etc.
        // Since we don't have any way to know the upcoming cards, we will deal the cards this way: table deck 1 add 1 card, table deck 2 add 2 cards, table deck 3 add 3 cards etc
        // We will always take the last card from main deck (delete it) and add it to the right table deck
        for (int i = 0; i < 28; i++) {
            if (i < 1) {
                tableDeck1.addLast(mainDeck.pollLast());
            } else if (i >= 1 && i <= 2) {
                tableDeck2.addLast(mainDeck.pollLast());
            } else if (i > 2 && i <= 5) {
                tableDeck3.addLast(mainDeck.pollLast());
            } else if (i > 5 && i <= 9) {
                tableDeck4.addLast(mainDeck.pollLast());
            } else if (i > 9 && i <= 14) {
                tableDeck5.addLast(mainDeck.pollLast());
            } else if (i > 14 && i <= 20) {
                tableDeck6.addLast(mainDeck.pollLast());
            } else {
                tableDeck7.addLast(mainDeck.pollLast());
            }
        }
    }
    
    // Check if card is possible to add in to desired final stack
    public boolean possibleToAddToFinalDeck(Card c, ArrayDeque d) {
        if (d.isEmpty()) {
            if (c.getNumber() == 1) return true;
        } else {
            Card check = (Card) d.getLast();
            if (c.getNumber() == check.getNumber() && c.getSuit().equals(check.getSuit())) {
                return true;
            } 
        }
        return false;
    }
    
    // Check if card is possible to add in to desired table stack
    public boolean possibleToAddToTableDeck(Card c, ArrayDeque d) {
        if (d.isEmpty()) {
            return true;
        } else {
            Card check = (Card) d.getLast();
            if (c.getSuit().equals("Hearts")) {
                if (check.getSuit().equals("Spades") || check.getSuit().equals("Clubs")) {
                    if (c.getNumber() == check.getNumber()-1) return true;
                }
            } else if (c.getSuit().equals("Diamonds")) {
                if (check.getSuit().equals("Spades") || check.getSuit().equals("Clubs")) {
                    if (c.getNumber() == check.getNumber()-1) return true;
                }
            } else if (c.getSuit().equals("Spades")) {
                if (check.getSuit().equals("Hearts") || check.getSuit().equals("Diamonds")) {
                    if (c.getNumber() == check.getNumber()-1) return true;
                }
            } else if (c.getSuit().equals("Clubs")) {
                if (check.getSuit().equals("Hearts") || check.getSuit().equals("Diamonds")) {
                    if (c.getNumber() == check.getNumber()-1) return true;
                }
            }
        }
        return false;
    }
    // Move a card to final deck
    public void moveCardToFinalDeck(ArrayDeque from, ArrayDeque to) {
        Card c = (Card) from.getLast();
        if (possibleToAddToFinalDeck(c, to)) {
            to.addLast(from.pollLast());
        }
    }
    // Move a card to table deck
    public void moveCardToTableDeck(ArrayDeque from, ArrayDeque to) {
        Card c = (Card) from.getLast();
        if (possibleToAddToTableDeck(c, to)) {
            to.addLast(from.pollLast());
        }
    }
    
}
