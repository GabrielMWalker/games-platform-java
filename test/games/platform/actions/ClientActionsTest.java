/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package games.platform.actions;

import games.platform.connection.DataBase;
import games.platform.models.Client;
import games.platform.models.Deposit;
import games.platform.models.Game;
import games.platform.utils.DbGlobal;
import games.platform.utils.LoggerGlobal;
import java.sql.Connection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel.walker
 */
public class ClientActionsTest {

    static DataBase db;

    public ClientActionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbGlobal.generateDb();
        db = DbGlobal.getDb();
        LoggerGlobal.generateLogger();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of buyOneGame method, of class ClientActions.
     */
    @Test
    public void testBuyOneGame() {
        System.out.println("buyOneGame");
        Client client = new Client(1, "Pidney", 10000);
        Game game = new Game(1, "Runescape", "A unique MMO set in the vast, fantasy world of Gielinor, brimming with diverse races, "
                + "guilds and ancient gods battling for dominion", new Date(), 150.00f, 1, "JAGEX", 50, new Date(), 75.00f);
        Connection dbConnection = db.getConnection();
        String expResult = "Compra Finalizada";
        String result = ClientActions.buyOneGame(client, game, dbConnection);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCash method, of class ClientActions.
     */
    @Test
    public void testAddCash() {
        System.out.println("addCash");
        Deposit deposit = new Deposit(1, 1000.00f);
        Connection dbConnection = db.getConnection();
        String expResult = "Crédito adicionado";
        String result = ClientActions.addCash(deposit, dbConnection);
        assertEquals(expResult, result);
    }

}
