
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollisavi
 */
public class DeckTest {
    
    Deck deck;
    
    @Before
    public void setUp() {
        deck = new Deck();
    }
    
    @Test
    public void deckCreatesSortedArrayListRightSize() {        
        assertEquals(52, deck.deckInOrder.size());
    }
    
    @Test
    public void shuffledDeckIsRightSize() {
        assertEquals(52, deck.getShuffledDeck().size());        
    }
    
}
