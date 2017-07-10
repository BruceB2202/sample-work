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
public class SameFirstLastTest {
    
    SameFirstLast myFL = new SameFirstLast();
    
    public SameFirstLastTest() {
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

    
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    @Test
    public void testNotSame() {
        assertFalse(myFL.sameFirstLast(new int[] {1, 2, 3}));
    }
    
    @Test
    public void testSame4(){
        assertTrue(myFL.sameFirstLast(new int[] {1, 2, 3, 1}));
    }
    
    @Test
    public void testSame3(){
        assertTrue(myFL.sameFirstLast(new int[] {1, 2, 1}));
    }
    
}
