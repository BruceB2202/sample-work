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
public class MischeviousChildrenTest {
    MischeviousChildren myChildren = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testBothSmile() {
       assertTrue(myChildren.areWeInTrouble(true, true));
    }
    
    @Test
    public void testNeitherSmile(){
        assertTrue(myChildren.areWeInTrouble(false, false));
    }
    
    @Test
    public void testASmiles(){
        assertFalse(myChildren.areWeInTrouble(true, false));
    }
    
    @Test
    public void testBSmiles(){
        assertFalse(myChildren.areWeInTrouble(false, true));
    }
    
}
