/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire.ui;

import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import solitaire.dao.ToplistDao;
import solitaire.domain.Table;

/**
 *
 * @author ollisavi
 */
public class Solitaire {

    Table table;
    Scanner input;
    Map<Integer, String> commandsMoveFrom;
    Map<Integer, String> commandsMoveTo;
    long startTime;
    long endTime;
    

    public Solitaire(Scanner input) {
        this.table = new Table(input);
        this.input = input;
        this.commandsMoveFrom = new TreeMap<>();
        this.commandsMoveTo = new TreeMap<>();
        enterCommandsToMoveFrom();
        enterCommandsToMoveTo();

    }

    // Enters moves to Treemap so we can print them when wanted.
    private void enterCommandsToMoveFrom() {
        commandsMoveFrom.put(1, "Move from hand deck.");
        commandsMoveFrom.put(2, "Move from final deck Clubs.");
        commandsMoveFrom.put(3, "Move from final deck Spades.");
        commandsMoveFrom.put(4, "Move from final deck Hearts.");
        commandsMoveFrom.put(5, "Move from final deck Diamonds.");
        commandsMoveFrom.put(6, "Move from 1st table deck.");
        commandsMoveFrom.put(7, "Move from 2nd table deck.");
        commandsMoveFrom.put(8, "Move from 3rd table deck.");
        commandsMoveFrom.put(9, "Move from 4th table deck.");
        commandsMoveFrom.put(10, "Move from 5th table deck.");
        commandsMoveFrom.put(11, "Move from 6th table deck.");
        commandsMoveFrom.put(12, "Move from 7th table deck.");
        commandsMoveFrom.put(0, "Exit game.");
    }

    // Enters moves to Treemap so we can print them when wanted.
    private void enterCommandsToMoveTo() {
        commandsMoveTo.put(2, "Move to final deck Clubs.");
        commandsMoveTo.put(3, "Move to final deck Spades.");
        commandsMoveTo.put(4, "Move to final deck Hearts.");
        commandsMoveTo.put(5, "Move to final deck Diamonds.");
        commandsMoveTo.put(6, "Move to 1st table deck.");
        commandsMoveTo.put(7, "Move to 2nd table deck.");
        commandsMoveTo.put(8, "Move to 3rd table deck.");
        commandsMoveTo.put(9, "Move to 4th table deck.");
        commandsMoveTo.put(10, "Move to 5th table deck.");
        commandsMoveTo.put(11, "Move to 6th table deck.");
        commandsMoveTo.put(12, "Move to 7th table deck.");
        commandsMoveTo.put(0, "Exit game.");
    }

    // Print moves 
    public void printMovesFrom() {
        for (Entry e : commandsMoveFrom.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }
        System.out.println("From which deck you want to move from?");
    }

    // Print moves
    public void printMovesTo() {
        for (Entry e : commandsMoveTo.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }
        System.out.println("Which deck you want to move to?");
    }

    // Check if empty and Print hand deck and final decks
    public void printHandAndFinalDecks() {
        table.checkIfListIsEmptyHandFinal(table.mainDeck);
        table.checkIfListIsEmptyHandFinal(table.finalDeckClubs);
        table.checkIfListIsEmptyHandFinal(table.finalDeckSpades);
        table.checkIfListIsEmptyHandFinal(table.finalDeckHearts);
        table.checkIfListIsEmptyHandFinal(table.finalDeckDiamonds);
        System.out.println();
        System.out.println();
    }

    // Check if empty and Print table decks
    public void printTableDecks() {
        table.checkIfListIsEmptyTableDeck(table.tableDeck1);
        table.checkIfListIsEmptyTableDeck(table.tableDeck2);
        table.checkIfListIsEmptyTableDeck(table.tableDeck3);
        table.checkIfListIsEmptyTableDeck(table.tableDeck4);
        table.checkIfListIsEmptyTableDeck(table.tableDeck5);
        table.checkIfListIsEmptyTableDeck(table.tableDeck6);
        table.checkIfListIsEmptyTableDeck(table.tableDeck7);
        System.out.println();
        System.out.println();
    }

    // Print end of the game, if all final decks full you're a winner. Otherwise loser
    // Print also the duration of the game
    public void printEndGame() throws SQLException {
        if (table.finalDeckClubs.size() == 13 && table.finalDeckDiamonds.size() == 13 && table.finalDeckHearts.size() == 13 && table.finalDeckSpades.size() == 13) {
            System.out.println("Congratulations! You're a winner!");
            System.out.println(table.getTimeUsedInGame(startTime, endTime));
            System.out.println(table.getMoves());
        } else {
            System.out.println("You didn't finish the game. Better luck next time.");
            System.out.println(table.getTimeUsedInGame(startTime, endTime));
            System.out.println(table.getMoves());
        }
    }

    // Which toplist wants to be seen
    public void chooseTopList(ToplistDao topList) throws SQLException {        
        System.out.println("Which toplist you want to see?");
        System.out.println("1. Fastest times");
        System.out.println("2. Fewest moves");
        int choice = input.nextInt();
        if (choice == 1) {
            getTopListInTimeOrder(topList);
        } else if (choice == 2) {
            getTopListInMoveOrder(topList);
        } else {
            System.out.println("Wrong choice, returning to main menu.");
        }
    }

    // Prints toplist database in time order
    public void getTopListInTimeOrder(ToplistDao topList) throws SQLException {        
        topList.getToplistInTimeOrder();
    }

    // Prints toplist database in move order
    public void getTopListInMoveOrder(ToplistDao topList) throws SQLException {        
        topList.getToplistInMoveOrder();
    }

    // Prints the first menu where you can decide whether to start new game, check toplist or exit
    public void printMainMenu() throws SQLException {
        ToplistDao topList = new ToplistDao();
        System.out.println("Welcome to Solitaire!");
        while (true) {
            System.out.println("Decide from the following options: ");
            System.out.println("1. Start new Game");
            System.out.println("2. Check toplist");
            System.out.println("3. Exit the game.");
            int firstChoice = input.nextInt();
            if (firstChoice == 1) {
                table.startDeal();
                playTheGame();
            } else if (firstChoice == 2) {
                chooseTopList(topList);
            } else if (firstChoice == 3) {
                break;
            } else {
                System.out.println("Wrong choice, please try again.");
            }
        }
    }
    
    public void playTheGame() throws SQLException {
        startTime = System.nanoTime();
        while (table.finalDeckClubs.size() <= 13 && table.finalDeckDiamonds.size() <= 13 && table.finalDeckHearts.size() <= 13 && table.finalDeckSpades.size() <= 13) {
            printHandAndFinalDecks();
            printTableDecks();
            printMovesFrom();
            int moveStart = input.nextInt();
            if (moveStart == 0) {
                break;
            }
            int cardsToMove = table.howBigStackIsMovableFromTableStack(moveStart);
            printMovesTo();
            int moveEnd = input.nextInt();
            if (moveEnd == 0) {
                break;
            }
            table.checkIfMoveIsCorrectAndContinue(moveStart, cardsToMove, moveEnd);            
        }
        endTime = System.nanoTime();
        printEndGame();
    }

    public void startNewGame() throws SQLException {
        printMainMenu();  
        
    }
}
