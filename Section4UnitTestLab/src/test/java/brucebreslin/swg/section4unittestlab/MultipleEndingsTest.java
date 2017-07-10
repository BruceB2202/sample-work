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
public class MultipleEndingsTest {
    
    MultipleEndings multends = new MultipleEndings();
    
    public MultipleEndingsTest() {
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
     * Test of multipleEndings method, of class MultipleEndings.
     */
    @Test
    public void testMultipleEndingsHello() {
        String expected = "lololo";
        assertEquals(expected, multends.multipleEndings("Hello"));
    }
    
    @Test
    public void testMultipleEndingsAb() {
        String expected = "ababab";
        assertEquals(expected, multends.multipleEndings("ab"));
    }
    
    @Test
    public void testMultipleEndingsHi() {
        String expected = "HiHiHi";
        assertEquals(expected, multends.multipleEndings("Hi"));
    }
    
}
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"