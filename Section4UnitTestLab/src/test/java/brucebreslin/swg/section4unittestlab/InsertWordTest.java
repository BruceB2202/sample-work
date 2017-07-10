/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.section4unittestlab;

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
public class InsertWordTest {
    InsertWord iw = new InsertWord();
    
    public InsertWordTest() {
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
     * Test of insertWord method, of class InsertWord.
     */
    @Test
    public void testInsertWordYay() {
        String expected = "<<Yay>>";
        assertEquals(expected, iw.insertWord("<<>>", "Yay"));
    }
    
    @Test
    public void testInsertWordWooHoo() {
        String expected = "<<WooHoo>>";
        assertEquals(expected, iw.insertWord("<<>>", "WooHoo"));
    }
    
    @Test
    public void testInsertWordWord() {
        String expected = "[[word]]";
        assertEquals(expected, iw.insertWord("[[]]", "word"));
    }
    
}
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"