
/**
 *
 * @author ollisavi
 */
public class Solitaire {
    
    public Solitaire() {
        
    }
    public void startNewGame() {
        Table table = new Table();
        table.startDeal();
        // Testing that table shows cards which are on top at the moment
        System.out.println(table.mainDeck.getLast());        
        System.out.print(table.tableDeck1.getLast()+" | ");
        System.out.print(table.tableDeck2.getLast()+" | ");
        System.out.print(table.tableDeck3.getLast()+" | ");
        System.out.print(table.tableDeck4.getLast()+" | ");
        System.out.print(table.tableDeck5.getLast()+" | ");
        System.out.print(table.tableDeck6.getLast()+" | ");
        System.out.print(table.tableDeck7.getLast());
    }
    
}
