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
public class MakeTagsTest {
    MakeTags myTags = new MakeTags();
    
    public MakeTagsTest() {
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
     * Test of makeTags method, of class MakeTags.
     */
    
    // The web is built with HTML Strings like "<i>Yay</i>" which 
    // draws Yay as italic text. In this example, the "i" tag makes 
    // <i> and </i> which surround the word "Yay". Given tag and word 
    // Strings, create the HTML String with tags around the word, e.g. 
    // “<i>Yay</i>". 
    //
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"
    @Test
    public void testTagsItalYay() {
        String expectedTag = "<i>Yay</i>";
        assertEquals(expectedTag, myTags.makeTags("i", "Yay"));
    }
    
    @Test
    public void testTagsItalHello(){
        String expectedTag = "<i>Hello</i>";
        assertEquals(expectedTag, myTags.makeTags("i", "Hello"));
    }
    
    @Test
    public void testTagsCiteYay(){
        String expectedTag = "<cite>Yay</cite>";
        assertEquals(expectedTag, myTags.makeTags("cite", "Yay"));
    }
    
}
