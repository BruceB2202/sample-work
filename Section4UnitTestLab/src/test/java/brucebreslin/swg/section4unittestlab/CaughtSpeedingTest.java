/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.section4unittestlab;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruce_Breslin
 */
public class CaughtSpeedingTest {
    CaughtSpeeding cs = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of caughtSpeeding method, of class CaughtSpeeding.
     */
    @Test
    public void testCaughtSpeeding64True() {
        assertEquals(0, cs.caughtSpeeding(64, true));
    }
    
    @Test
    public void testCaughtSpeeding65True() {
        assertEquals(0, cs.caughtSpeeding(65, true));
    }
    
    @Test
    public void testCaughtSpeeding84True() {
        assertEquals(1, cs.caughtSpeeding(84, true));
    }
    
    @Test
    public void testCaughtSpeeding85True() {
        assertEquals(1, cs.caughtSpeeding(85, true));
    }
    
    @Test
    public void testCaughtSpeeding86True() {
        assertEquals(2, cs.caughtSpeeding(86, true));
    }
    
    @Test
    public void testCaughtSpeeding59False() {
        assertEquals(0, cs.caughtSpeeding(59, false));
    }
    
    @Test
    public void testCaughtSpeeding60False() {
        assertEquals(0, cs.caughtSpeeding(60, false));
    }
    
    @Test
    public void testCaughtSpeeding79False() {
        assertEquals(1, cs.caughtSpeeding(79, false));
    }
    
    @Test
    public void testCaughtSpeeding80False() {
        assertEquals(1, cs.caughtSpeeding(80, false));
    }
    
    @Test
    public void testCaughtSpeeding81False() {
        assertEquals(2, cs.caughtSpeeding(81, false));
    }
    
}
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0