package solitaire.domain;


import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import solitaire.dao.Card;
import static org.junit.Assert.*;


/**
 *
 * @author ollisavi
 */
public class TableTest {
    
    Table table;
    Scanner input;
    
    @Before
    public void setUp() {
        table = new Table(input);
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
    public void checkThatMoveIsCorrectAndDoTheMove() {
        table.mainDeck.add(new Card("Hearts", 1));
        table.checkIfMoveIsCorrectAndContinue(1, 1, 4);
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
    }
    
    @Test
    public void moveACardToTableDeckFromDeque() {
        table.mainDeck.addLast(new Card("Hearts", 5));
        table.tableDeck1.clear();
        table.moveCardToTableDeck(table.mainDeck, table.tableDeck1);
        assertEquals("Hearts, 5", table.tableDeck1.get(table.tableDeck1.size()-1).toString());
    }
    @Test
    public void moveAWrongCardToTableDeckFromDeque() {
        table.mainDeck.addLast(new Card("Hearts", 5));
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.moveCardToTableDeck(table.mainDeck, table.tableDeck1);
        assertEquals("Hearts, 2", table.tableDeck1.get(table.tableDeck1.size()-1).toString());
    }
    
    @Test
    public void isCardValidForMovableStack() {
        Card c = new Card("Clubs", 2);
        Card check = new Card("Hearts", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Spades", 2);
        check = new Card("Hearts", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Hearts", 2);
        check = new Card("Clubs", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Diamonds", 2);
        check = new Card("Clubs", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
    }
    
    @Test
    public void cardIsNotValidForMovableStack() {
        Card c = new Card("Clubs", 1);
        Card check = new Card("Hearts", 1);
        assertFalse(table.isCardValidForMovableStack(c, check));
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
    
    @Test
    public void howBigStackIsMovableInTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        assertEquals(1, table.howBigStackIsMovableFromTableStack(6));
    }
    
    @Test
    public void testTimeUsedInGamePrintsRightWay() {
        assertEquals("Your game took 1 seconds.",table.getTimeUsedInGame(1000000000, 2000000000));        
    }
    
    @Test
    public void movesCountIsRight() {
        table.tableDeck1.clear();
        table.mainDeck.addLast(new Card("Hearts", 2));
        table.doTheMove(1, 1, 6);
        table.mainDeck.addLast(new Card("Spades", 1));
        table.doTheMove(1, 1, 6);
        assertEquals("You made total of: 2 moves during the game.", table.getMoves());
    }
    
    @Test
    public void testIfItIsPossibleToAddToFinalDeck() {
        assertTrue(table.possibleToAddToFinalDeck(new Card("Hearts", 1), table.finalDeckHearts));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        assertTrue(table.possibleToAddToFinalDeck(new Card("Hearts", 2), table.finalDeckHearts));        
    }
    
    @Test
    public void moveCardToFinalDeckFromDeque() {
        table.mainDeck.addLast(new Card("Hearts", 1));
        table.moveCardToFinalDeck(table.mainDeck, table.finalDeckHearts);
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
    }
    
    @Test
    public void moveAStackFromTableStack() {
        table.tableDeck1.clear();
        table.tableDeck2.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.tableDeck1.add(new Card("Spades", 1));
        table.moveAStackFromTableStack(2, table.tableDeck1, table.tableDeck2);
        assertEquals("Hearts, 2", table.tableDeck2.get(table.tableDeck2.size()-2).toString());
        assertEquals("Spades, 1", table.tableDeck2.get(table.tableDeck2.size()-1).toString());
    }
    
    @Test
    public void doTheMoveFromMainDeckToFinalDeck() {
        table.mainDeck.addLast(new Card("Hearts", 1));
        table.doTheMove(1, 1, 4);
        assertEquals("You made total of: 1 moves during the game.", table.getMoves());
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
    }
    
    @Test
    public void doTheMoveFromFinalDeckToTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Spades", 2));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.doTheMove(4, 1, 6);
        assertEquals("You made total of: 1 moves during the game.", table.getMoves());
        assertEquals("Hearts, 1", table.tableDeck1.get(table.tableDeck1.size()-1).toString());
    }
    
    @Test
    public void doTheMoveFromTableDeckToFinalDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.doTheMove(6, 1, 4);
        assertEquals("You made total of: 1 moves during the game.", table.getMoves());
        assertEquals("Hearts, 2", table.finalDeckHearts.getLast().toString());
    }
    
    @Test
    public void doTheMoveFromTableDeckToTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Spades", 2));
        table.tableDeck2.clear();
        table.tableDeck2.add(new Card("Hearts", 1));
        table.doTheMove(7, 1, 6);
        assertEquals("You made total of: 1 moves during the game.", table.getMoves());
        assertEquals("Hearts, 1", table.tableDeck1.get(table.tableDeck1.size()-1).toString());
    }
}
