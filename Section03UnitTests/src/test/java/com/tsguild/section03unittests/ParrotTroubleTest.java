/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.section03unittests;

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
public class ParrotTroubleTest {
    
    ParrotTrouble parrot = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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
     * Test of parrotTrouble method, of class ParrotTrouble.
     */
    // We have a loud talking parrot. The "hour" parameter is the 
    // current hour time in the range 0..23. We are in trouble if 
    // the parrot is talking and the hour is before 7 or after 20. 
    // Return true if we are in trouble. 
    //
    // parrotTrouble(true, 6) -> true
    // parrotTrouble(true, 7) -> false
    // parrotTrouble(false, 6) -> false
    @Test
    public void testParrotTrue6() {
        assertTrue(parrot.parrotTrouble(true, 6));
    }
    
    @Test
    public void testParrotTrue7() {
        assertFalse(parrot.parrotTrouble(true, 7));
    }
    
    @Test
    public void testParrotFalse6() {
        assertFalse(parrot.parrotTrouble(false, 6));
    }
    
    @Test
    public void testParrotFalse7(){
        assertFalse(parrot.parrotTrouble(false, 7));
    }
    
    @Test
    public void testParrotTrue20(){
        assertFalse(parrot.parrotTrouble(true, 20));
    }
    
    @Test
    public void testParrotFalse20(){
        assertFalse(parrot.parrotTrouble(false, 20));
    }
    
    @Test
    public void testParrotTrue21() {
        assertTrue(parrot.parrotTrouble(true, 21));
    }
    
    @Test
    public void testParrotFalse21(){
        assertFalse(parrot.parrotTrouble(false, 21));
    }
    
}
