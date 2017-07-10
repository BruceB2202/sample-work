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
public class Diff21Test {
    
    Diff21 diff = new Diff21();
    
    public Diff21Test() {
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
     * Test of diff21 method, of class Diff21.
     */
    
    // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value 
    // of the difference if n is over 21. 
    //
    // diff21(23) -> 4
    // diff21(10) -> 11
    // diff21(21) -> 0
    @Test
    public void testDiff23() {
        int expectedResult = 4;
        assertEquals(expectedResult, diff.diff21(23));
    }
    
    @Test
    public void testDiff10() {
        int expectedResult = 11;
        assertEquals(expectedResult, diff.diff21(10));
    }
    
    @Test
    public void testDiff21() {
        int expectedResult = 0;
        assertEquals(expectedResult, diff.diff21(21));
    }
    
}
