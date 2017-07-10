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
public class SleepingInTest {
    SleepingIn mySleep = new SleepingIn();
    
    public SleepingInTest() {
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
     * Test of canSleepIn method, of class SleepingIn.
     */
    
    // The parameter weekday is true if it is a weekday, and the 
    // parameter vacation is true if we are on vacation. We sleep 
    // in if it is not a weekday or we're on vacation. Return true 
    // if we sleep in. 
    //
    // canSleepIn(false, false) -> true
    // canSleepIn(true, false) -> false
    // canSleepIn(false, true) -> true
    
    @Test
    public void testWeekendNoVaca() {
        assertTrue(mySleep.canSleepIn(false, false));
    }
    
    @Test
    public void testWeekdayNoVaca(){
        assertFalse(mySleep.canSleepIn(true, false));
    }
    
    @Test
    public void testWeekendVaca(){
        assertTrue(mySleep.canSleepIn(false, true));
    }
    
    @Test
    public void testWeekdayVaca(){
        assertTrue(mySleep.canSleepIn(true, true));
    }
    
}
