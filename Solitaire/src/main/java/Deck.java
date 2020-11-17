
import java.util.*;

/**
 *
 * @author ollisavi
 */
public class Deck {

    ArrayList<Card> deckInOrder;

    public Deck() {
        // ArrayList to compile a full deck in order
        // Loop creates 52 new cards with a spesific suit and adds them to Arraylist
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

    public ArrayDeque<Card> getShuffledDeck() {
        ArrayDeque<Card> shuffledDeck = new ArrayDeque<>();
        // Shuffle the deck which is in order
        Collections.shuffle(deckInOrder);
        // Add shuffled deck to an ArrayDeque for more effective and easier deck handling
        // We don't have a situation that we need to get a card from middle of the deck so deque is more effective
        for (int i = 0; i < 52; i++) {
            shuffledDeck.addLast(deckInOrder.get(i));
        }
        return shuffledDeck;
    }

}
