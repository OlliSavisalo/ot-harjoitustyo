/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire.domain;

import java.util.*;
import solitaire.dao.Card;
import solitaire.dao.Deck;

/**
 *
 * @author ollisavi
 */
public class Table {

    Deck d;
    Scanner input;
    // Counter to retrieve made moves
    int count;
    // Two different move maps because we have different type of lists (Deques and lists)
    Map<Integer, ArrayDeque> moves1to5;
    Map<Integer, ArrayList> moves6to12;
    // When called, table class creates full table with the Solitaire schematic
    // In Solitaire we need a lot of different size lists which are made using deques, since they are effective and easy to use
    public ArrayDeque<Card> mainDeck;
    // Final decks are the ones we want to have our cards in.
    public ArrayDeque<Card> finalDeckHearts;
    public ArrayDeque<Card> finalDeckDiamonds;
    public ArrayDeque<Card> finalDeckSpades;
    public ArrayDeque<Card> finalDeckClubs;
    // In the table we have 7 different decks
    public ArrayList<Card> tableDeck1;
    public ArrayList<Card> tableDeck2;
    public ArrayList<Card> tableDeck3;
    public ArrayList<Card> tableDeck4;
    public ArrayList<Card> tableDeck5;
    public ArrayList<Card> tableDeck6;
    public ArrayList<Card> tableDeck7;

    public Table(Scanner input) {
        // In mainDeck we want to have the whole shuffled deck and we can start dealing cards from there
        // Any leftover cards will be used as the "hand deck" during the game
        this.d = new Deck();
        this.input = input;
        this.count = 0;
        this.mainDeck = d.getShuffledDeck();
        this.finalDeckHearts = new ArrayDeque<>();
        this.finalDeckDiamonds = new ArrayDeque<>();
        this.finalDeckSpades = new ArrayDeque<>();
        this.finalDeckClubs = new ArrayDeque<>();
        this.tableDeck1 = new ArrayList<>();
        this.tableDeck2 = new ArrayList<>();
        this.tableDeck3 = new ArrayList<>();
        this.tableDeck4 = new ArrayList<>();
        this.tableDeck5 = new ArrayList<>();
        this.tableDeck6 = new ArrayList<>();
        this.tableDeck7 = new ArrayList<>();
        this.moves1to5 = new TreeMap<>();
        this.moves6to12 = new TreeMap<>();
        enterCommandsToMaps();
    }

    private void enterCommandsToMaps() {
        moves1to5.put(1, mainDeck);
        moves1to5.put(2, finalDeckClubs);
        moves1to5.put(3, finalDeckSpades);
        moves1to5.put(4, finalDeckHearts);
        moves1to5.put(5, finalDeckDiamonds);
        moves6to12.put(6, tableDeck1);
        moves6to12.put(7, tableDeck2);
        moves6to12.put(8, tableDeck3);
        moves6to12.put(9, tableDeck4);
        moves6to12.put(10, tableDeck5);
        moves6to12.put(11, tableDeck6);
        moves6to12.put(12, tableDeck7);
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
    /*public void moveCardToTableDeck(ArrayList from, ArrayList to) {
        Card c = (Card) from.get(from.size() - 1);
        if (possibleToAddToTableDeck(c, to)) {
            to.add(from.get(from.size() - 1));
            from.remove(from.size() - 1);
        }
    }*/
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
            }
        } else if (check.suit.equals("Spades")) {
            if (onTop.suit.equals("Hearts") || onTop.suit.equals("Diamonds")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            }
        } else if (check.suit.equals("Hearts")) {
            if (onTop.suit.equals("Clubs") || onTop.suit.equals("Spades")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            }
        } else if (check.suit.equals("Diamonds")) {
            if (onTop.suit.equals("Clubs") || onTop.suit.equals("Spades")) {
                if (check.number - 1 == onTop.number) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check how big stack is movable from table stack with one turn
    // First check from which stack user wanted to move from
    // Then check if it's possible to move more then 1 card at a time
    // Call method howManyCardsToMove for next step
    public int howBigStackIsMovableFromTableStack(int n) {
        int count = 1;
        if (n >= 6 && n <= 12) {
            ArrayList from = moves6to12.get(n);
            if (from.size() > 1) {
                for (int i = 1; i < from.size(); i++) {
                    Card check = (Card) from.get(from.size() - (i + 1));
                    Card onTop = (Card) from.get(from.size() - i);
                    if (isCardValidForMovableStack(check, onTop)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count > 1) {
                    return howManyCardsWantToMove(count, from);
                }
            }
        }
        return count;
    }

    // Method gets count how many cards can be moved from list
    // Asks user how many cards wants to move and does the desired move
    public int howManyCardsWantToMove(int count, ArrayList from) {
        System.out.println("You can move following cards: ");
        for (int i = count; i > 0; i--) {
            System.out.print(from.get(from.size() - i) + " ");
        }
        System.out.println("You can move 1-" + count + " cards.");
        System.out.println("How many you wish to move?");
        int moves = input.nextInt();
        if (moves > 0 && moves <= count) {
            return moves;
        }
        return 1;
    }

    // Move a stack from table deck
    // n is the value of how many cards want to be moved
    public void moveAStackFromTableStack(int n, ArrayList from, ArrayList to) {
        if (n > 0 || n < from.size()) {
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

    // Method for printing, check if given list is empty or not
    public void checkIfListIsEmptyHandFinal(ArrayDeque check) {
        if (check.isEmpty()) {
            System.out.print("Empty. | ");
        } else {
            System.out.print(check.getLast() + " | ");
        }
    }

    // Method for printing, check if given list is empty or not
    public void checkIfListIsEmptyTableDeck(ArrayList check) {
        if (check.isEmpty()) {
            System.out.print("Empty. | ");
        } else {
            System.out.print(check.get(check.size() - 1) + " | ");
        }
    }

    public void checkIfMoveIsCorrectAndContinue(int moveStart, int cardsToMove, int moveEnd) {
        if (moveStart < 0 || moveStart > 12 || moveEnd < 0 || moveEnd > 12) {
            System.out.println("Wrong move, please start over.");
        } else {
            if (moveStart == 1 && moveEnd == 1) {
                moveMainDeckCardToTheBottom();
                count++;
            } else {
                doTheMove(moveStart, cardsToMove, moveEnd);
            }
        }
    }

    // Does the desired move
    public void doTheMove(int moveStart, int cardsToMove, int moveEnd) {
        if (moveEnd == 1) {
            System.out.println("Wrong move, please start over.");
        } else if (moveStart > 1 && moveStart < 6 && moveEnd < 6) {
            System.out.println("Wrong move, please start over.");
        } else if (moveStart == moveEnd) {
            System.out.println("You cannot move to same location.");
        } else {
            if (moveStart == 1 && moveEnd < 6) {
                moveCardToFinalDeck(moves1to5.get(moveStart), moves1to5.get(moveEnd));
                count++;
            }
            if (moveStart == 1 && moveEnd >= 6) {
                moveCardToTableDeck(moves1to5.get(moveStart), moves6to12.get(moveEnd));
                count++;
            }
            if (moveStart > 1 && moveStart < 6 && moveEnd >= 6) {
                moveCardToTableDeck(moves1to5.get(moveStart), moves6to12.get(moveEnd));
                count++;
            }
            if (moveStart > 5 && moveEnd < 6) {
                moveCardToFinalDeck(moves6to12.get(moveStart), moves1to5.get(moveEnd));
                count++;
            }
            if (moveStart > 5 && moveEnd > 5) {
                moveAStackFromTableStack(cardsToMove, moves6to12.get(moveStart), moves6to12.get(moveEnd));
                count++;
            }
        }
    }
    
    // Calculate and return string of the game duration.
    public String getTimeUsedInGame(long startTime, long endTime) {
        long totalTime = (endTime - startTime) / 1000000000;
        return "Your game took " + totalTime + " seconds.";
    }
    
    // Return the count of moves made as a string
    public String getMoves() {
        return "You made total of: " + count + " moves during the game.";
    }
}
