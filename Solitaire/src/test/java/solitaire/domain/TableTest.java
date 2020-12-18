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
        assertEquals("Hearts, 5", table.tableDeck1.get(table.tableDeck1.size() - 1).toString());
    }

    @Test
    public void moveAWrongCardToTableDeckFromDeque() {
        table.mainDeck.addLast(new Card("Hearts", 5));
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.moveCardToTableDeck(table.mainDeck, table.tableDeck1);
        assertEquals("Hearts, 2", table.tableDeck1.get(table.tableDeck1.size() - 1).toString());
    }

    @Test
    public void isCardValidForMovableStack() {
        Card c = new Card("Clubs", 2);
        Card check = new Card("Hearts", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        check = new Card("Diamonds", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Spades", 2);
        check = new Card("Hearts", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));        
        check = new Card("Diamonds", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Hearts", 2);
        check = new Card("Clubs", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        check = new Card("Spades", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        c = new Card("Diamonds", 2);
        check = new Card("Clubs", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
        check = new Card("Spades", 1);
        assertTrue(table.isCardValidForMovableStack(c, check));
    }

    @Test
    public void cardIsNotValidForMovableStack() {
        Card c = new Card("Clubs", 1);
        Card check = new Card("Hearts", 1);
        assertFalse(table.isCardValidForMovableStack(c, check));
    }

    @Test
    public void testEmptyDecks() {
        table.finalDeckClubs.clear();
        table.finalDeckDiamonds.clear();
        table.finalDeckHearts.clear();
        table.finalDeckSpades.clear();
        table.mainDeck.clear();
        table.tableDeck1.clear();
        assertFalse(table.checkIfTableIsEmpty(1));
        assertFalse(table.checkIfTableIsEmpty(2));
        assertFalse(table.checkIfTableIsEmpty(3));
        assertFalse(table.checkIfTableIsEmpty(4));
        assertFalse(table.checkIfTableIsEmpty(5));
        assertFalse(table.checkIfTableIsEmpty(6));
        assertTrue(table.checkIfTableIsEmpty(7));
    }

    @Test
    public void testEmptyDecksIfNotEmpty() {
        table.finalDeckClubs.clear();
        table.finalDeckClubs.add(new Card("Hearts", 3));
        table.finalDeckDiamonds.clear();
        table.finalDeckDiamonds.add(new Card("Hearts", 3));
        table.finalDeckHearts.clear();
        table.finalDeckHearts.add(new Card("Hearts", 3));
        table.finalDeckSpades.clear();
        table.finalDeckSpades.add(new Card("Hearts", 3));
        table.mainDeck.clear();
        table.mainDeck.add(new Card("Hearts", 3));
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 3));
        assertTrue(table.checkIfTableIsEmpty(1));
        assertTrue(table.checkIfTableIsEmpty(2));
        assertTrue(table.checkIfTableIsEmpty(3));
        assertTrue(table.checkIfTableIsEmpty(4));
        assertTrue(table.checkIfTableIsEmpty(5));
        assertTrue(table.checkIfTableIsEmpty(6));
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
    public void howBigStackIsMovableInBiggerTableStack() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.tableDeck1.add(new Card("Hearts", 6));
        table.tableDeck1.add(new Card("Hearts", 12));
        assertEquals(1, table.howBigStackIsMovableFromTableStack(6));
    }

    @Test
    public void testTimeUsedInGamePrintsRightWay() {
        assertEquals("00:00:01", table.getTimeUsedInGame(1000000000, 2000000000));
    }

    @Test
    public void movesCountIsRight() {
        table.tableDeck1.clear();
        table.mainDeck.addLast(new Card("Hearts", 2));
        table.doTheMove(1, 1, 6);
        table.mainDeck.addLast(new Card("Spades", 1));
        table.doTheMove(1, 1, 6);
        assertEquals(2, table.getMoves());
    }

    @Test
    public void testIfItIsPossibleToAddToFinalDeck() {
        assertTrue(table.possibleToAddToFinalDeck(new Card("Hearts", 1), table.finalDeckHearts));
        assertFalse(table.possibleToAddToFinalDeck(new Card("Hearts", 2), table.finalDeckHearts));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        assertTrue(table.possibleToAddToFinalDeck(new Card("Hearts", 2), table.finalDeckHearts));
        assertFalse(table.possibleToAddToFinalDeck(new Card("Hearts", 3), table.finalDeckHearts));
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
        assertEquals("Hearts, 2", table.tableDeck2.get(table.tableDeck2.size() - 2).toString());
        assertEquals("Spades, 1", table.tableDeck2.get(table.tableDeck2.size() - 1).toString());
    }

    @Test
    public void doTheMoveFromMainDeckToFinalDeck() {
        table.mainDeck.addLast(new Card("Hearts", 1));
        table.doTheMove(1, 1, 4);
        assertEquals(1, table.getMoves());
        assertEquals("Hearts, 1", table.finalDeckHearts.getLast().toString());
    }

    @Test
    public void doTheMoveFromFinalDeckToTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Spades", 2));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.doTheMove(4, 1, 6);
        assertEquals(1, table.getMoves());
        assertEquals("Hearts, 1", table.tableDeck1.get(table.tableDeck1.size() - 1).toString());
    }

    @Test
    public void doTheMoveFromTableDeckToFinalDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        table.finalDeckHearts.addLast(new Card("Hearts", 1));
        table.doTheMove(6, 1, 4);
        assertEquals(1, table.getMoves());
        assertEquals("Hearts, 2", table.finalDeckHearts.getLast().toString());
    }

    @Test
    public void doTheMoveFromTableDeckToTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Spades", 2));
        table.tableDeck2.clear();
        table.tableDeck2.add(new Card("Hearts", 1));
        table.doTheMove(7, 1, 6);
        assertEquals(1, table.getMoves());
        assertEquals("Hearts, 1", table.tableDeck1.get(table.tableDeck1.size() - 1).toString());
    }

    @Test
    public void checkIfMoveIsCorrectAndMoveMainDeckToBottom() {
        table.mainDeck.add(new Card("Spades", 3));
        table.mainDeck.add(new Card("Spades", 6));
        table.checkIfMoveIsCorrectAndContinue(1, 1, 1);
        assertEquals("Spades, 3", table.mainDeck.getLast().toString());
    }

    @Test
    public void possibleToAddToTableDeck() {
        table.tableDeck1.clear();
        table.tableDeck1.add(new Card("Hearts", 2));
        assertTrue(table.possibleToAddToTableDeck(new Card("Spades", 1), table.tableDeck1));
        assertTrue(table.possibleToAddToTableDeck(new Card("Clubs", 1), table.tableDeck1));
        table.tableDeck2.clear();
        table.tableDeck2.add(new Card("Diamonds", 2));
        assertTrue(table.possibleToAddToTableDeck(new Card("Clubs", 1), table.tableDeck2));
        assertTrue(table.possibleToAddToTableDeck(new Card("Spades", 1), table.tableDeck2));
        table.tableDeck3.clear();
        table.tableDeck3.add(new Card("Spades", 2));
        assertTrue(table.possibleToAddToTableDeck(new Card("Hearts", 1), table.tableDeck3));
        assertTrue(table.possibleToAddToTableDeck(new Card("Diamonds", 1), table.tableDeck3));
        table.tableDeck4.clear();
        table.tableDeck4.add(new Card("Clubs", 2));
        assertTrue(table.possibleToAddToTableDeck(new Card("Diamonds", 1), table.tableDeck4));
        assertTrue(table.possibleToAddToTableDeck(new Card("Hearts", 1), table.tableDeck4));
    }
}
