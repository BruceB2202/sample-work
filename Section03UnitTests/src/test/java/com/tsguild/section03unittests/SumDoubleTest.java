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
public class SumDoubleTest {
    
    SumDouble sumDbl = new SumDouble();
    
    public SumDoubleTest() {
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
     * Test of sumDouble method, of class SumDouble.
     */
    
    // Given two int values, return their sum. However, if the two 
    // values are the same, then return double their sum. 
    //
    // sumDouble(1, 2) -> 3
    // sumDouble(3, 2) -> 5
    // sumDouble(2, 2) -> 8
    @Test
    public void testSum1_2() {
        int expectedResult = 3;
        assertEquals(expectedResult, sumDbl.sumDouble(1, 2));
    }
    
    @Test
    public void testSum3_2() {
        int expectedResult = 5;
        assertEquals(expectedResult, sumDbl.sumDouble(3, 2));
    }
    
    @Test
    public void testSum2_2() {
        int expectedResult = 8;
        assertEquals(expectedResult, sumDbl.sumDouble(2, 2));
    }
    
}
