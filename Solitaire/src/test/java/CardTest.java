/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
