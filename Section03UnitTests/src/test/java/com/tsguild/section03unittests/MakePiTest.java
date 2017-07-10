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
public class MakePiTest {
    
    MakePi myPi = new MakePi();
    
    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}
    @Test
    public void testMakePi3() {
        int[] expectedResult = new int[] {3, 1, 4};
        assertArrayEquals(expectedResult, myPi.makePi(3));
    }
    
    @Test
    public void testMakePi10() {
        int[] expectedResult = new int[] {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        assertArrayEquals(expectedResult, myPi.makePi(10));
    }
    
    @Test
    public void testMakePi5() {
        int[] expectedResult = new int[] {3, 1, 4, 1, 5};
        assertArrayEquals(expectedResult, myPi.makePi(5));
    }
    
}
