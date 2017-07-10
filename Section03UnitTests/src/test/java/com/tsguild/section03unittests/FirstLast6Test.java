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
public class FirstLast6Test {
    FirstLast6 myFL6 = new FirstLast6();
    
    public FirstLast6Test() {
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
     * Test of firstLast6 method, of class FirstLast6.
     */
    
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false
    @Test
    public void testLast6() {
       assertTrue(myFL6.firstLast6(new int[]{1, 2, 6}));
    }
    
    @Test
    public void testFirst6() {
        assertTrue(myFL6.firstLast6(new int[] {6, 1, 2 ,3}));
    }
    
    @Test
    public void testSecondToLast6() {
        assertFalse(myFL6.firstLast6(new int[] {13, 2, 1, 6, 3}));
    }
    
    @Test
    public void testSecondPlace6(){
        assertFalse(myFL6.firstLast6(new int[]{13, 6, 1, 2, 3}));
    }
    
    @Test
    public void testNo6() {
        assertFalse(myFL6.firstLast6(new int[]{1, 2, 3, 4, 5}));
    }
    
}
