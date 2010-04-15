package model;

import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author riza
 */
public class ServerTest {

    public ServerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ReceiveConnection method, of class Server.
     */
    @Test
    public void testReceiveConnectionUseQueue() {
        System.out.println("ReceiveConnection");
        Socket pSocket = null;
        Server instance = new Server(true);
        for(int i = 0; i < 100; ++i) {
            instance.ReceiveConnection(pSocket);
        }
        try { Thread.sleep(100); } catch(Exception ex) { }
        for(int i = 0; i < 100; ++i) {
            instance.ReceiveConnection(pSocket);
        }
    }
    
    /**
     * Test of ReceiveConnection method, of class Server.
     */
    @Test
    public void testReceiveConnectionNotUseQueue() {
        System.out.println("ReceiveConnection");
        Socket pSocket = null;
        Server instance = new Server(false);

        for(int i = 0; i < 100; ++i) {
            instance.ReceiveConnection(pSocket);
        }
        try { Thread.sleep(100); } catch(Exception ex) { }
        for(int i = 0; i < 100; ++i) {
            instance.ReceiveConnection(pSocket);
        }
    }
}