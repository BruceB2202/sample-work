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
public class CountXxTest {
    CountXx myCount = new CountXx();
    
    public CountXxTest() {
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
     * Test of countXX method, of class CountXx.
     */
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    
    
    @Test
    public void testCountXx1() {
        int expectedNum = 1;
        assertEquals(expectedNum, myCount.countXX("abcxx"));
    }
    
    @Test
    public void testCountXx2(){
        int expectedNum = 2;
        assertEquals(expectedNum, myCount.countXX("xxx"));
    }
    
    @Test
    public void testCountXx3(){
        int expectedNum = 3;
        assertEquals(expectedNum, myCount.countXX("xxxx"));
    }
    
    @Test
    public void testCountXx0(){
        int expectedNum = 0;
        assertEquals(expectedNum, myCount.countXX("abccba"));
    }
    
    @Test
    public void testCountXxSplit(){
        int expectedNum = 2;
        assertEquals(expectedNum, myCount.countXX("abxxcdxxef"));
    }
    
}
