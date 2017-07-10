/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.State;
import java.math.BigDecimal;
import java.util.List;
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
public class FlooringMasteryStateDaoImplTest {
    FlooringMasteryStateDao stateDao = new FlooringMasteryStateDaoFileImpl();
    
    public FlooringMasteryStateDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<State> statesServiced = stateDao.getAllStates();
        statesServiced.forEach((state) -> {
            stateDao.removeState(state.getStateId());
        });
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addState and getState methods, of class FlooringMasteryStateDaoFileImpl.
     */
    @Test
    public void testAddAndGetState() {
        State newState = new State(1);
        newState.setStateName("OH");
        newState.setStateTaxRate(new BigDecimal("6.25"));
        stateDao.addState(newState);
        
        State fromDao = stateDao.getState(1);
        
        assertEquals(newState, fromDao);
        
    }

    /**
     * Test of getAllStates method, of class FlooringMasteryStateDaoFileImpl.
     */
    @Test
    public void testGetAllStates() {
        State newState = new State(1);
        newState.setStateName("OH");
        newState.setStateTaxRate(new BigDecimal("6.25"));
        stateDao.addState(newState);
        
        State newState2 = new State(2);
        newState2.setStateName("PA");
        newState2.setStateTaxRate(new BigDecimal("6.75"));
        stateDao.addState(newState2);
        
        assertEquals(2, stateDao.getAllStates().size());
    }

    /**
     * Test of editState method, of class FlooringMasteryStateDaoFileImpl.
     */
    @Test
    public void testEditState() {
        State newState = new State(1);
        newState.setStateName("OH");
        newState.setStateTaxRate(new BigDecimal("6.25"));
        stateDao.addState(newState);
        
        State newState2 = new State(1);
        newState2.setStateName("OH");
        newState2.setStateTaxRate(new BigDecimal("6.15"));
        stateDao.addState(newState2);
        
        assertEquals(newState2, stateDao.getState(1));
        assertNotEquals(newState, stateDao.getState(1));
    }

    /**
     * Test of removeState method, of class FlooringMasteryStateDaoFileImpl.
     */
    @Test
    public void testRemoveState() {
        State newState = new State(1);
        newState.setStateName("OH");
        newState.setStateTaxRate(new BigDecimal("6.25"));
        stateDao.addState(newState);
        assertEquals(1, stateDao.getAllStates().size());
        
        State newState2 = new State(2);
        newState2.setStateName("PA");
        newState2.setStateTaxRate(new BigDecimal("6.75"));
        stateDao.addState(newState2);
        assertEquals(2, stateDao.getAllStates().size());
        
        stateDao.removeState(1);
        assertEquals(1, stateDao.getAllStates().size());
        stateDao.removeState(2);
        assertEquals(0, stateDao.getAllStates().size());
    }
    
}
