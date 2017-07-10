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
public class AlarmClockTest {
    AlarmClock ac = new AlarmClock();
    
    public AlarmClockTest() {
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
     * Test of alarmClock method, of class AlarmClock.
     */
    @Test
    public void testAlarmClockSunFalse() {
        String expected = "10:00";
        assertEquals(expected, ac.alarmClock(0, false));
    }
    
    @Test
    public void testAlarmClockMonFalse() {
        String expected = "7:00";
        assertEquals(expected, ac.alarmClock(1, false));
    }
    
    @Test
    public void testAlarmClockFriFalse() {
        String expected = "7:00";
        assertEquals(expected, ac.alarmClock(5, false));
    }
    
    @Test
    public void testAlarmClockSatTrue() {
        String expected = "Off";
        assertEquals(expected, ac.alarmClock(6, true));
    }
    
    @Test
    public void testAlarmClockWedTrue() {
        String expected = "10:00";
        assertEquals(expected, ac.alarmClock(3, true));
    }
    
}
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
