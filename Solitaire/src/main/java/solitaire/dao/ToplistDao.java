package solitaire.dao;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ollisavi
 */
public class ToplistDao {

    Connection db;
    Statement s;

    /**
     * Constructor creates the database and calls method createTable()
     *
     * @throws SQLException
     */
    public ToplistDao() throws SQLException {
        this.db = DriverManager.getConnection("jdbc:sqlite:toplist.db");
        this.s = db.createStatement();
        createTable();
    }

    /**
     * Creates the SQL table Toplist and adds a little start info for showing it
     * works. Can comment or delete insert commands if empty table is wanted.
     * Also if user allready has the toplist.db with right table on the
     * computer, user can comment or delete this method.
     *
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        s.execute("CREATE TABLE Toplist(id INTEGER PRIMARY KEY, nimi TEXT, aika TIME, siirrot INTEGER)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:13', 50)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:00:54', 30)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:02:10', 25)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:00', 70)");
        s.execute("INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:25', 1)");
    }

    /**
     * Returns the whole toplist which is in order by time, from fastest to
     * slowest.
     *
     * @return ArrayList in time order
     * @throws SQLException
     */
    public ArrayList<String> getToplistInTimeOrder() throws SQLException {
        ResultSet r = s.executeQuery("SELECT nimi, aika, siirrot FROM Toplist ORDER BY aika");
        ArrayList<String> topList = new ArrayList<>();
        int i = 1;
        while (r.next()) {
            String query = i + ". " + r.getString("nimi") + " " + r.getString("aika") + " " + r.getInt("siirrot");
            topList.add(query);
            i++;
        }
        return topList;
    }

    /**
     * Returns the whole toplist which is in order by count of moves, from
     * smallest to biggest count.
     *
     * @return ArrayList in move order
     * @throws SQLException
     */
    public ArrayList<String> getToplistInMoveOrder() throws SQLException {
        ResultSet r = s.executeQuery("SELECT nimi, aika, siirrot FROM Toplist ORDER BY siirrot");
        ArrayList<String> topList = new ArrayList<>();
        int i = 1;
        while (r.next()) {
            String query = i + ". " + r.getString("nimi") + " " + r.getString("aika") + " " + r.getInt("siirrot");
            topList.add(query);
            i++;
        }
        return topList;
    }

    /**
     * Method for adding results to database.
     *
     * @param name Name of the user which is asked when game is won.
     * @param gameTime Duration of the game converted to right kind of String
     * (HH:MM:SS).
     * @param moves Count of the moves made in the game.
     *
     * @throws SQLException
     */
    public void enterNewResultToTopList(String name, String gameTime, int moves) throws SQLException {
        PreparedStatement p = db.prepareStatement("INSERT INTO Toplist (nimi, aika, siirrot) VALUES (?,?,?)");
        p.setString(1, name);
        p.setString(2, gameTime);
        p.setInt(3, moves);
        p.executeUpdate();
    }

}
