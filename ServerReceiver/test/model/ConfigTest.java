/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Properties;
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
public class ConfigTest {

    public ConfigTest() {
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
     * Test of getQueueCapacity method, of class Config.
     */
    @Test
    public void testGetQueueCapacity() {
        System.out.println("getQueueCapacity");
        Config instance = new Config();
        int expResult = instance.loadConfiguration() ? 100 : 1;
        int result = instance.getQueueCapacity();
        assertEquals(expResult, result);
    }


    /**
     * Test of getQueueFairness method, of class Config.
     */
    @Test
    public void testGetQueueFairness() {
        System.out.println("getQueueFairness");
        Config instance = new Config();
        instance.loadConfiguration();
        boolean expResult = true;
        boolean result = instance.getQueueFairness();
        assertEquals(expResult, result);
    }

    /**
     * Test of getThreadNumber method, of class Config.
     */
    @Test
    public void testGetThreadNumber() {
        System.out.println("getThreadNumber");
        Config instance = new Config();
        instance.loadConfiguration();
        int expResult = 1;
        int result = instance.getThreadNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEOS method, of class Config.
     */
    @Test
    public void testGetEOS() {
        System.out.println("getEOS");
        Config instance = new Config();
        char expResult = '|';
        char result = instance.getEOS();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPort method, of class Config.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        Config instance = new Config();
        instance.loadConfiguration();
        int expResult = 35568;
        int result = instance.getPort();
        assertEquals(expResult, result);
    }
}
