
import java.util.*;

/**
 *
 * @author ollisavi
 */
public class Solitaire {

    Table table;

    public Solitaire() {
        table = new Table();
    }

    // If possible to move more than 1 card at a time, this method returns how many cards user wants to move
    public int howManyCardsWantToMove(int n, ArrayList from) {
        Scanner input = new Scanner(System.in);
        System.out.println("You can move following cards: ");
        for (int i = n; i > 0; i--) {
            System.out.print(from.get(from.size() - i)+" ");
        }
        System.out.println("You can move 1-" + n + " cards.");
        System.out.println("How many you wish to move?");
        int moves = input.nextInt();
        return moves;
    }

    public void startNewGame() {
        table.startDeal();
        Scanner input = new Scanner(System.in);        
        while (table.finalDeckClubs.size() < 13 && table.finalDeckDiamonds.size() < 13 && table.finalDeckHearts.size() < 13 && table.finalDeckSpades.size() < 13) {
            System.out.print(table.mainDeck.getLast() + " | ");
            if (table.finalDeckClubs.isEmpty()) {
                System.out.print("[Clubs] ");
            } else {
                System.out.print(table.finalDeckClubs.getLast() + " ");
            }
            if (table.finalDeckSpades.isEmpty()) {
                System.out.print("[Spades] ");
            } else {
                System.out.print(table.finalDeckSpades.getLast() + " ");
            }
            if (table.finalDeckHearts.isEmpty()) {
                System.out.print("[Hearts] ");
            } else {
                System.out.print(table.finalDeckHearts.getLast() + " ");
            }
            if (table.finalDeckDiamonds.isEmpty()) {
                System.out.print("[Diamonds] ");
            } else {
                System.out.print(table.finalDeckDiamonds.getLast() + " ");
            }
            System.out.println();
            System.out.println();
            if (table.tableDeck1.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck1.get(table.tableDeck1.size() - 1) + " | ");
            }
            if (table.tableDeck2.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck2.get(table.tableDeck2.size() - 1) + " | ");
            }
            if (table.tableDeck3.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck3.get(table.tableDeck3.size() - 1) + " | ");
            }
            if (table.tableDeck4.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck4.get(table.tableDeck4.size() - 1) + " | ");
            }
            if (table.tableDeck5.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck5.get(table.tableDeck5.size() - 1) + " | ");
            }
            if (table.tableDeck6.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck6.get(table.tableDeck6.size() - 1) + " | ");
            }
            if (table.tableDeck7.isEmpty()) {
                System.out.print("Empty | ");
            } else {
                System.out.print(table.tableDeck7.get(table.tableDeck7.size() - 1));
            }
            System.out.println();
            System.out.println("From which deck you want to move from? (1: Hand-deck, 2-5: Final decks, 6-12: Table decks), 0 for Exit.");
            int moveStart = input.nextInt();
            int movableCount;
            int wantedMoves = 0;
            if (moveStart == 0) {
                break;
            } else if (moveStart == 6) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck1);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck1);
                }
            } else if (moveStart == 7) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck2);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck2);
                }
            } else if (moveStart == 8) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck3);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck3);
                }
            } else if (moveStart == 9) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck4);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck4);
                }
            } else if (moveStart == 10) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck5);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck5);
                }
            } else if (moveStart == 11) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck6);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck6);
                }
            } else if (moveStart == 12) {
                movableCount = table.howBigStackIsMovableFromTableStack(table.tableDeck7);
                if (movableCount > 1) {
                    wantedMoves = howManyCardsWantToMove(movableCount, table.tableDeck7);
                }
            }
            System.out.println("Which deck you want to move to? (1: Hand-deck, 2-5: Final decks, 6-12: Table decks), 0 for Exit.");
            int moveEnd = input.nextInt();
            if (moveEnd == 0) {
                break;
            }
            if (moveStart < 0 || moveStart > 12 || moveEnd < 0 || moveEnd > 12) {
                System.out.println("Wrong move, please try again.");
            }
            if (moveStart == 1) {
                if (moveEnd == 1) {
                    table.moveMainDeckCardToTheBottom();
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.mainDeck, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.mainDeck, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.mainDeck, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.mainDeck, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck1);
                } else if (moveEnd == 7) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck2);
                } else if (moveEnd == 8) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck3);
                } else if (moveEnd == 9) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck4);
                } else if (moveEnd == 10) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck5);
                } else if (moveEnd == 11) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck6);
                } else if (moveEnd == 12) {
                    table.moveCardToTableDeck(table.mainDeck, table.tableDeck7);
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 2) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 3) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 4) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 5) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 6) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck1);
                } else if (moveEnd == 7) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck2);
                } else if (moveEnd == 8) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck3);
                } else if (moveEnd == 9) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck4);
                } else if (moveEnd == 10) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck5);
                } else if (moveEnd == 11) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck6);
                } else if (moveEnd == 12) {
                    table.moveCardToTableDeck(table.finalDeckClubs, table.tableDeck7);
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 3) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 3) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 4) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 5) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 6) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck1);
                } else if (moveEnd == 7) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck2);
                } else if (moveEnd == 8) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck3);
                } else if (moveEnd == 9) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck4);
                } else if (moveEnd == 10) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck5);
                } else if (moveEnd == 11) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck6);
                } else if (moveEnd == 12) {
                    table.moveCardToTableDeck(table.finalDeckSpades, table.tableDeck7);
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 4) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 3) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 4) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 5) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 6) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck1);
                } else if (moveEnd == 7) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck2);
                } else if (moveEnd == 8) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck3);
                } else if (moveEnd == 9) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck4);
                } else if (moveEnd == 10) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck5);
                } else if (moveEnd == 11) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck6);
                } else if (moveEnd == 12) {
                    table.moveCardToTableDeck(table.finalDeckHearts, table.tableDeck7);
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 5) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 3) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 4) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 5) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 6) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck1);
                } else if (moveEnd == 7) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck2);
                } else if (moveEnd == 8) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck3);
                } else if (moveEnd == 9) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck4);
                } else if (moveEnd == 10) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck5);
                } else if (moveEnd == 11) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck6);
                } else if (moveEnd == 12) {
                    table.moveCardToTableDeck(table.finalDeckDiamonds, table.tableDeck7);
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 6) {

                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck1, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck1, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck1, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck1, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck1, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck1, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }

            }
            if (moveStart == 7) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck2, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck2, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck2, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck2, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck2, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck2, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 8) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck3, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck3, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck3, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck3, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck3, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck3, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 9) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck4, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck4, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck4, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck4, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck4, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck4, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 10) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck5, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck5, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck5, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck5, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck5, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck5, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 11) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck6, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck6, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck6, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck6, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    System.out.println("You cannot move to same location.");
                } else if (moveEnd == 12) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck6, table.tableDeck7);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck6, table.tableDeck7);
                    }
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }
            if (moveStart == 12) {
                if (moveEnd == 1) {
                    System.out.println("Wrong move, please try again.");
                } else if (moveEnd == 2) {
                    table.moveCardToFinalDeck(table.tableDeck7, table.finalDeckClubs);
                } else if (moveEnd == 3) {
                    table.moveCardToFinalDeck(table.tableDeck7, table.finalDeckSpades);
                } else if (moveEnd == 4) {
                    table.moveCardToFinalDeck(table.tableDeck7, table.finalDeckHearts);
                } else if (moveEnd == 5) {
                    table.moveCardToFinalDeck(table.tableDeck7, table.finalDeckDiamonds);
                } else if (moveEnd == 6) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck1);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck1);
                    }
                } else if (moveEnd == 7) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck2);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck2);
                    }
                } else if (moveEnd == 8) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck3);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck3);
                    }
                } else if (moveEnd == 9) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck4);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck4);
                    }
                } else if (moveEnd == 10) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck5);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck5);
                    }
                } else if (moveEnd == 11) {
                    if (wantedMoves > 1) {
                        table.moveAStackFromTableStack(wantedMoves, table.tableDeck7, table.tableDeck6);
                    } else {
                        table.moveCardToTableDeck(table.tableDeck7, table.tableDeck6);
                    }
                } else if (moveEnd == 12) {
                    System.out.println("You cannot move to same location.");
                } else {
                    System.out.println("Wrong move, please try again.");
                }
            }

        }

    }

}
