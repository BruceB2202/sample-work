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
public class CommonEndTest {
    
    CommonEnd ce = new CommonEnd();
    
    public CommonEndTest() {
    }
    

    /**
     * Test of commonEnd method, of class CommonEnd.
     */
    @Test
    public void testCommonEndRear() {
        int[] a = {1,2,3};
        int[] b = {7,3};
        assertTrue(ce.commonEnd(a, b));
    }
    
    @Test
    public void testCommonEndNone() {
        int[] a = {1,2,3};
        int[] b = {7,3,2};
        assertFalse(ce.commonEnd(a, b));
    }
    
    @Test
    public void testCommonEndBoth() {
        int[] a = {1,2,3};
        int[] b = {1,3};
        assertTrue(ce.commonEnd(a, b));
    }
    
    @Test
    public void testCommonEndFront() {
        int[] a = {1,2,3};
        int[] b = {1,5};
        assertTrue(ce.commonEnd(a, b));
    }
    
}
// commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true