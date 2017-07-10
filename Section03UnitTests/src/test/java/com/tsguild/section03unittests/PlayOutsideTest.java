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
public class PlayOutsideTest {
    
    PlayOutside play = new PlayOutside();
    
    public PlayOutsideTest() {
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
     * Test of playOutside method, of class PlayOutside.
     */
    // The children in Cleveland spend most of the day playing outside. 
    // In particular, they play if the temperature is between 60 and 90 
    // (inclusive). Unless it is summer, then the upper limit is 100 
    // instead of 90. Given an int temperature and a boolean isSummer, 
    // return true if the children play and false otherwise. 
    //
    // playOutside(70, false) → true
    // playOutside(95, false) → false
    // playOutside(95, true) → true
    // boundaries: 59/60 90/91 100/101
    @Test
    public void testPlay70False() {
       assertTrue(play.playOutside(70, false));
    }
    
    @Test
    public void testPlay95False(){
        assertFalse(play.playOutside(95, false));
    }
    
    @Test
    public void testPlay95True(){
        assertTrue(play.playOutside(95, true));
    }
    
    @Test
    public void testPlay59True(){
        assertFalse(play.playOutside(59, true));
    }
    
    @Test
    public void testPlay59False(){
        assertFalse(play.playOutside(59, false));
    }
    
    @Test
    public void testPlay60True(){
        assertTrue(play.playOutside(60, true));
    }
    
    @Test
    public void testPlay60False(){
        assertTrue(play.playOutside(60, false));
    }
    
    @Test
    public void testPlay90True(){
        assertTrue(play.playOutside(90, true));
    }
    
    @Test
    public void testPlay90False(){
        assertTrue(play.playOutside(90, false));
    }
    
    @Test
    public void testPlay91True(){
        assertTrue(play.playOutside(91, true));
    }
    
    @Test
    public void testPlay91False(){
        assertFalse(play.playOutside(91, false));
    }
    
    @Test
    public void testPlay100True(){
        assertTrue(play.playOutside(100, true));
    }
    
    @Test
    public void testPlay100False(){
        assertFalse(play.playOutside(100, false));
    }
    
    @Test
    public void testPlay101True(){
        assertFalse(play.playOutside(101, true));
    }
    
    @Test
    public void testPlay101False(){
        assertFalse(play.playOutside(101, false));
    }
    
}
