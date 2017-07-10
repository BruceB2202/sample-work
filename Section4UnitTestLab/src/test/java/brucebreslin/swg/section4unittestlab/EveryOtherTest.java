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
public class EveryOtherTest {
    EveryOther eo = new EveryOther();
    
    public EveryOtherTest() {
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
     * Test of everyOther method, of class EveryOther.
     */
    @Test
    public void testEveryOtherHello() {
        String expected = "Hlo";
        assertEquals(expected, eo.everyOther("Hello"));
    }
    
    @Test
    public void testEveryOtherHi() {
        String expected = "H";
        assertEquals(expected, eo.everyOther("Hi"));
    }
    
    @Test
    public void testEveryOtherHeeololeo() {
        String expected = "Hello";
        assertEquals(expected, eo.everyOther("Heeololeo"));
    }
    
}
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"