/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire.dao;

import java.sql.SQLException;
import java.util.ArrayList;
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
public class ToplistDaoTest {
    
    ToplistDao t;
    
    public ToplistDaoTest() throws SQLException {
        t = new ToplistDao();
        
    }    
    
    @Test
    public void topListsInOrderIsRight() throws SQLException {   
        t.enterNewResultToTopList("Olli", "00:20:15", 100);
        ArrayList<String> list = t.getToplistInTimeOrder();
        assertEquals("1. Olli 00:00:54 30", list.get(0));
        assertEquals("6. Olli 00:20:15 100", list.get(5));
        list = t.getToplistInMoveOrder();
        assertEquals("1. Olli 00:01:25 1", list.get(0));
        assertEquals("6. Olli 00:20:15 100", list.get(5));
    }
    
}
