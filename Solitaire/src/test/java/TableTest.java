
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollisavi
 */
public class TableTest {
    
    Table table;
    
    @Before
    public void setUp() {
        table = new Table();
        table.startDeal();
    }
    
    @Test
    public void tableDecksAreRightSize() {
        assertEquals(1, table.tableDeck1.size());
        assertEquals(2, table.tableDeck2.size());
        assertEquals(3, table.tableDeck3.size());
        assertEquals(4, table.tableDeck4.size());
        assertEquals(5, table.tableDeck5.size());
        assertEquals(6, table.tableDeck6.size());
        assertEquals(7, table.tableDeck7.size());
    }
    
    @Test
    public void mainDeckIsRightSize() {
        assertEquals(24, table.mainDeck.size());
    }
    
    @Test
    public void finalDecksAreEmpty() {
        assertTrue(table.finalDeckClubs.isEmpty());
        assertTrue(table.finalDeckHearts.isEmpty());
        assertTrue(table.finalDeckSpades.isEmpty());
        assertTrue(table.finalDeckDiamonds.isEmpty());
    }
    
    @Test
    public void addingToFinalDecksRightCards() {
        table.finalDeckClubs.addLast(new Card("Clubs", 1));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.finalDeckSpades.addLast(new Card("Spades", 1));
        table.finalDeckDiamonds.addLast(new Card("Diamonds", 1));
        assertEquals("Clubs, 1", table.finalDeckClubs.getLast().toString());
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
        assertEquals("Spades, 1", table.finalDeckSpades.getLast().toString());
        assertEquals("Diamonds, 1", table.finalDeckDiamonds.getLast().toString());
    }
    
    @Test
    public void movingToFinalDecksWrongCards() {
        table.finalDeckClubs.addLast(new Card("Clubs", 1));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.finalDeckSpades.addLast(new Card("Spades", 1));
        table.finalDeckDiamonds.addLast(new Card("Diamonds", 1));
        ArrayList<Card> test = new ArrayList<>();
        test.add(new Card("Clubs", 3));
        table.moveCardToFinalDeck(test, table.finalDeckClubs);
        table.moveCardToFinalDeck(test, table.finalDeckSpades);
        table.moveCardToFinalDeck(test, table.finalDeckDiamonds);
        table.moveCardToFinalDeck(test, table.finalDeckHearts);
        assertEquals("Clubs, 1", table.finalDeckClubs.getLast().toString());
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
        assertEquals("Spades, 1", table.finalDeckSpades.getLast().toString());
        assertEquals("Diamonds, 1", table.finalDeckDiamonds.getLast().toString());
    }
    @Test
    public void movingTopCardFromHandDeckToBottom() {
        Card c = table.mainDeck.getLast();
        table.moveMainDeckCardToTheBottom();
        assertEquals(c, table.mainDeck.getFirst());
    }
}
