package solitaire.dao;

import java.util.*;

/**
 *
 * @author ollisavi
 */
public class Deck {

    ArrayList<Card> deckInOrder;

    /**
     * Construct the Deck class. Creates new cards and add them to an ArrayList
     * in order. Loops creates 52 new cards with a spesific suit and adds them
     * to Arraylist
     */
    public Deck() {
        this.deckInOrder = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            Card c = new Card("Hearts", i);
            deckInOrder.add(c);
        }
        for (int i = 1; i <= 13; i++) {
            Card c = new Card("Diamonds", i);
            deckInOrder.add(c);
        }
        for (int i = 1; i <= 13; i++) {
            Card c = new Card("Spades", i);
            deckInOrder.add(c);
        }
        for (int i = 1; i <= 13; i++) {
            Card c = new Card("Clubs", i);
            deckInOrder.add(c);
        }
    }

    /**
     * Shuffle the deck in order. Add shuffled deck to an ArrayDeque for more
     * effective and easier deck handling. We don't have a situation that we
     * need to get a card from middle of the deck so deque is more effective
     *
     * @return ArrayDeque shuffledDeck
     */
    public ArrayDeque<Card> getShuffledDeck() {
        ArrayDeque<Card> shuffledDeck = new ArrayDeque<>();
        Collections.shuffle(deckInOrder);
        for (int i = 0; i < 52; i++) {
            shuffledDeck.addLast(deckInOrder.get(i));
        }
        return shuffledDeck;
    }

}
