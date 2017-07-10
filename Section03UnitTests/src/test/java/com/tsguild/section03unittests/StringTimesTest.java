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
public class StringTimesTest {
    StringTimes myStringTimes = new StringTimes();
    
    public StringTimesTest() {
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testString2Times() {
       String expectedString = "HiHi";
        assertEquals(expectedString, myStringTimes.stringTimes("Hi", 2));
    }
    
    @Test
    public void testString3Times(){
       String expectedString = "HiHiHi";
        assertEquals(expectedString, myStringTimes.stringTimes("Hi", 3));
    }
    
     @Test
    public void testString1Time(){
       String expectedString = "Hi";
        assertEquals(expectedString, myStringTimes.stringTimes("Hi", 1));
    }
}
