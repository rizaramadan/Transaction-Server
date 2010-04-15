package model;

import java.net.ServerSocket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
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
public class SocketListenerTest {


    Config mConfig;
    ArrayBlockingQueue<QueueElement> RequestQueue;
    ServerSocket mServerSocket;

    public SocketListenerTest() {
        mConfig = new Config(); mConfig.loadConfiguration();
        RequestQueue = new ArrayBlockingQueue<QueueElement>(10,true);
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
     * Test of run method, of class SocketListener.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        //SocketListener instance = new SocketListener(mConfig.getProperties(),mServerSocket,RequestQueue);
        //instance.run();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}