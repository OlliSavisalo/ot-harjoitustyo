
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
    ArrayList<Card> tableDeck1;
    ArrayList<Card> tableDeck2;
    ArrayList<Card> tableDeck3;
    ArrayList<Card> tableDeck4;
    ArrayList<Card> tableDeck5;
    ArrayList<Card> tableDeck6;
    ArrayList<Card> tableDeck7;

    public Table() {
        // In mainDeck we want to have the whole shuffled deck and we can start dealing cards from there
        // Any leftover cards will be used as the "hand deck" during the game
        Deck d = new Deck();
        mainDeck = d.getShuffledDeck();
        finalDeckHearts = new ArrayDeque<>();
        finalDeckDiamonds = new ArrayDeque<>();
        finalDeckSpades = new ArrayDeque<>();
        finalDeckClubs = new ArrayDeque<>();
        tableDeck1 = new ArrayList<>();
        tableDeck2 = new ArrayList<>();
        tableDeck3 = new ArrayList<>();
        tableDeck4 = new ArrayList<>();
        tableDeck5 = new ArrayList<>();
        tableDeck6 = new ArrayList<>();
        tableDeck7 = new ArrayList<>();
    }

    public void startDeal() {
        // Since we know that we will deal total of 28 cards, we can loop this
        // Normally table decks are dealt this way: 1st cards of all table decks, 2nd cards of decks 2 to 7, 3rd cards of decks 3 to 7 etc.
        // Since we don't have any way to know the upcoming cards, we will deal the cards this way: table deck 1 add 1 card, table deck 2 add 2 cards, table deck 3 add 3 cards etc
        // We will always take the last card from main deck (delete it) and add it to the right table deck
        for (int i = 0; i < 28; i++) {
            if (i < 1) {
                tableDeck1.add(mainDeck.pollLast());
            } else if (i >= 1 && i <= 2) {
                tableDeck2.add(mainDeck.pollLast());
            } else if (i > 2 && i <= 5) {
                tableDeck3.add(mainDeck.pollLast());
            } else if (i > 5 && i <= 9) {
                tableDeck4.add(mainDeck.pollLast());
            } else if (i > 9 && i <= 14) {
                tableDeck5.add(mainDeck.pollLast());
            } else if (i > 14 && i <= 20) {
                tableDeck6.add(mainDeck.pollLast());
            } else {
                tableDeck7.add(mainDeck.pollLast());
            }
        }
    }

    // Check if card is possible to add in to desired final stack
    public boolean possibleToAddToFinalDeck(Card c, ArrayDeque d) {
        if (d.isEmpty()) {
            if (c.getNumber() == 1) {
                return true;
            }
        } else {
            Card check = (Card) d.getLast();
            if (c.getNumber() - 1 == check.getNumber() && c.getSuit().equals(check.getSuit())) {
                return true;
            }
        }
        return false;
    }

    // Check if card is possible to add in to desired table stack
    public boolean possibleToAddToTableDeck(Card c, ArrayList d) {
        if (d.isEmpty()) {
            return true;
        } else {
            Card check = (Card) d.get(d.size() - 1);
            if (c.getSuit().equals("Hearts")) {
                if (check.getSuit().equals("Spades") || check.getSuit().equals("Clubs")) {
                    if (c.getNumber() == check.getNumber() - 1) {
                        return true;
                    }
                }
            } else if (c.getSuit().equals("Diamonds")) {
                if (check.getSuit().equals("Spades") || check.getSuit().equals("Clubs")) {
                    if (c.getNumber() == check.getNumber() - 1) {
                        return true;
                    }
                }
            } else if (c.getSuit().equals("Spades")) {
                if (check.getSuit().equals("Hearts") || check.getSuit().equals("Diamonds")) {
                    if (c.getNumber() == check.getNumber() - 1) {
                        return true;
                    }
                }
            } else if (c.getSuit().equals("Clubs")) {
                if (check.getSuit().equals("Hearts") || check.getSuit().equals("Diamonds")) {
                    if (c.getNumber() == check.getNumber() - 1) {
                        return true;
                    }
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

    // Move a card to final deck from table deck
    public void moveCardToFinalDeck(ArrayList from, ArrayDeque to) {
        Card c = (Card) from.get(from.size() - 1);
        if (possibleToAddToFinalDeck(c, to)) {
            to.addLast(from.remove(from.size() - 1));
        }
    }

    // Move a card to table deck
    public void moveCardToTableDeck(ArrayDeque from, ArrayList to) {
        Card c = (Card) from.getLast();
        if (possibleToAddToTableDeck(c, to)) {
            to.add(from.pollLast());
        }
    }

    // Move a card to table deck from table deck
    public void moveCardToTableDeck(ArrayList from, ArrayList to) {
        Card c = (Card) from.get(from.size() - 1);
        if (possibleToAddToTableDeck(c, to)) {
            to.add(from.get(from.size() - 1));
            from.remove(from.size() - 1);
        }
    }

    // Move the top card of main deck to the bottom of the pile
    public void moveMainDeckCardToTheBottom() {
        mainDeck.addFirst(mainDeck.pollLast());
    }

    // Is the card valid for movable table stack
    public boolean isCardValidForMovableStack(Card check, Card onTop) {
        if (check.suit.equals("Clubs")) {
            if (onTop.suit.equals("Hearts") || onTop.suit.equals("Diamonds")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (check.suit.equals("Spades")) {
            if (onTop.suit.equals("Hearts") || onTop.suit.equals("Diamonds")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (check.suit.equals("Hearts")) {
            if (onTop.suit.equals("Clubs") || onTop.suit.equals("Spades")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (check.suit.equals("Diamonds")) {
            if (onTop.suit.equals("Clubs") || onTop.suit.equals("Spades")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    // Check how big stack is movable from table stack with one turn
    public int howBigStackIsMovableFromTableStack(ArrayList from) {
        int count = 1;
        for (int i = 1; i < from.size(); i++) {
            Card check = (Card) from.get(from.size() - (i + 1));
            Card onTop = (Card) from.get(from.size() - i);
            if (isCardValidForMovableStack(check, onTop)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // Move a stack from table deck
    // n is the value of how many cards want to be moved
    public void moveAStackFromTableStack(int n, ArrayList from, ArrayList to) {
        Card firstOfStack = (Card) from.get(from.size() - (n));
        if (possibleToAddToTableDeck(firstOfStack, to)) {
            for (int i = n; i > 0; i--) {
                Card move = (Card) from.get(from.size() - (i));
                from.remove(move);
                to.add(move);
            }
        }
    }
}
