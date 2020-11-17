
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
    
}
