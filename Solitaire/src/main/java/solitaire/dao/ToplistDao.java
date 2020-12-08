
package solitaire.dao;


import java.sql.*;

/**
 *
 * @author ollisavi
 */
public class ToplistDao {
    
    Connection db;
    Statement s;
    
    public ToplistDao() throws SQLException {
        this.db = DriverManager.getConnection("jdbc:sqlite:toplist.db");
        this.s = db.createStatement();
        createTable();
    }
    
    // Creates table and inserts info for testing
    private void createTable() throws SQLException {
        s.execute("CREATE TABLE Toplist(id INTEGER PRIMARY KEY, nimi TEXT, aika TIME, siirrot INTEGER)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:13', 50)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:00:54', 30)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:02:10', 25)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:00', 70)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:25', 1)");
    }
    // Prints the toplist in time order
    public void getToplistInTimeOrder() throws SQLException {
        ResultSet r  = s.executeQuery("SELECT nimi, aika, siirrot FROM Toplist ORDER BY aika");
        int i = 1;
        while (r.next()) {
            System.out.println(i + ". " + r.getString("nimi") + " " + r.getString("aika") + " " + r.getInt("siirrot"));
            i++;
        }
        System.out.println();
    }
    // Prints the toplist in move order
    public void getToplistInMoveOrder() throws SQLException {
        ResultSet r  = s.executeQuery("SELECT nimi, aika, siirrot FROM Toplist ORDER BY siirrot");
        int i = 1;
        while (r.next()) {
            System.out.println(i + ". " + r.getString("nimi") + " " + r.getString("aika") + " " + r.getInt("siirrot"));
            i++;
        }
        System.out.println();
    }
    
}
