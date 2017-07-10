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
public class SkipSumTest {
    
    SkipSum ss = new SkipSum();
    
    public SkipSumTest() {
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
     * Test of skipSum method, of class SkipSum.
     */
    @Test
    public void testSkipSum34() {
        assertEquals(7, ss.skipSum(3, 4));
    }
    
    @Test
    public void testSkipSum94() {
        assertEquals(20, ss.skipSum(9, 4));
    }
    
    @Test
    public void testSkipSum1011() {
        assertEquals(21, ss.skipSum(10, 11));
    }
    
    @Test
    public void testSkipSum63() {
        assertEquals(9, ss.skipSum(6, 3));
    }
    
    @Test
    public void testSkipSum55() {
        assertEquals(20, ss.skipSum(5, 5));
    }
    
    @Test
    public void testSkipSum146() {
        assertEquals(20, ss.skipSum(14, 6));
    }
    
}
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21