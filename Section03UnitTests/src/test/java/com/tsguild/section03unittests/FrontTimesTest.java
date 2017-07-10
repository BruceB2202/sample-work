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
public class FrontTimesTest {
    FrontTimes myFront = new FrontTimes();
    
    public FrontTimesTest() {
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
     * Test of frontTimes method, of class FrontTimes.
     */
    
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    @Test
    public void testChoCho() {
        String expected = "ChoCho";
        assertEquals(expected, myFront.frontTimes("Chocolate", 2));
    }
    
    @Test
    public void testChoChoCho(){
        String expected = "ChoChoCho";
        assertEquals(expected, myFront.frontTimes("Chocolate", 3));
    }
    
    @Test
    public void testAbcAbcAbc(){
        String expected = "AbcAbcAbc";
        assertEquals(expected, myFront.frontTimes("Abc", 3));
    }
    
    @Test
    public void testAbAbAbAb(){
        String expected = "AbAbAbAb";
        assertEquals(expected, myFront.frontTimes("Ab", 4));
    }
    
}
