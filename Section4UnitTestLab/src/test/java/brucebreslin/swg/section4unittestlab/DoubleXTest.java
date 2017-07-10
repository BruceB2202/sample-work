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
public class DoubleXTest {
    
    DoubleX xx = new DoubleX();
    
    public DoubleXTest() {
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
    public void testDoubleXTrue(){
        String str = "axxbb";
        assertTrue(xx.doubleX(str)); 
    }
    
    @Test
    public void testDoubleXFalseX(){
        String str = "axaxxax";
        assertFalse(xx.doubleX(str)); 
    }
    
    @Test
    public void testDoubleXTrueAllX(){
        String str = "xxxxx";
        assertTrue(xx.doubleX(str)); 
    }
    
    @Test
    public void testDoubleXFalseNoX(){
        String str = "asdfasdf";
        assertFalse(xx.doubleX(str)); 
    }
    
}
    //doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true