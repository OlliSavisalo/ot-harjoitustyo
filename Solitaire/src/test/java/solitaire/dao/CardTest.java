package solitaire.dao;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author ollisavi
 */
public class CardTest {
    
    Card card;
    
    @Before
    public void setUp() {
        card = new Card("Hearts", 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void cannotAddWrongNumberOnACard() {        
        Card c = new Card("Hearts", 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void cannotAddWrongSuitOnACard() {        
        Card c = new Card("risti", 1);
    }
    
    @Test
    public void cardAddedNumberAndSuitIsRight() {
        Card c = new Card("Hearts", 2);
        assertEquals("Hearts, 2", c.toString());
    }
    
    @Test
    public void suitIsRight() {
        assertEquals("Hearts", card.getSuit());
    }
    
    @Test
    public void numberIsRight() {
        assertEquals(1, card.getNumber());
    }
    
    @Test
    public void stringMethodIsRight() {
        assertEquals("Hearts, 1", card.toString());
    }


}
