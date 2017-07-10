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
public class AbbaTest {
    
    Abba myAbba = new Abba();
    
    public AbbaTest() {
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

    @Test
    public void testHiBye() {
        String expectedResult = "HiByeByeHi";
        assertEquals(expectedResult, myAbba.abba("Hi", "Bye"));
    }
    
    @Test
    public void testYoAlice(){
        String expectedResult = "YoAliceAliceYo";
        assertEquals(expectedResult, myAbba.abba("Yo", "Alice"));
    }
    
    @Test
    public void testWhatUp(){
        String expectedResult = "WhatUpUpWhat";
        assertEquals(expectedResult, myAbba.abba("What", "Up"));
    }
    
}
