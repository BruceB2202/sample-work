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
public class CanHazTableTest {
    
    CanHazTable greeter = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void testTable5_10() {
        int expectedAnswer = 2;
        assertEquals(expectedAnswer, greeter.canHazTable(5, 10));
    }
    
    @Test
    public void testTable5_2(){
        int expectedAnswer = 0;
        assertEquals(expectedAnswer, greeter.canHazTable(5, 2));
    }
    
    @Test
    public void testTable5_5(){
        int expectedAnswer = 1;
        assertEquals(expectedAnswer, greeter.canHazTable(5, 5));
    }
    
    @Test
    public void testTable8_5(){
        int expectedAnswer = 2;
        assertEquals(expectedAnswer, greeter.canHazTable(8, 5));
    }
    
    @Test
    public void testTable7_5(){
        int expectedAnswer = 1;
        assertEquals(expectedAnswer, greeter.canHazTable(7, 5));
    }
    
    @Test
    public void testTable3_5(){
        int expectedAnswer = 1;
        assertEquals(expectedAnswer, greeter.canHazTable(3, 5));
    }
    
    @Test
    public void testTable1_1(){
        int expectedAnswer = 0;
        assertEquals(expectedAnswer, greeter.canHazTable(1, 1));
    }
    
    @Test
    public void testTable9_9(){
        int expectedAnswer = 2;
        assertEquals(expectedAnswer, greeter.canHazTable(9, 9));
    }
}
