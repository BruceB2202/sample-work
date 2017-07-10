/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendService;

import brucebreslin.swg.vendingmachine.VendDao.VendingMachineDaoStubImpl;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineDao;
import brucebreslin.swg.vendingmachine.VendDto.Snack;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineServiceTest {
    VendingMachineService service;
    
    public VendingMachineServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VendingMachineService.class);
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
     * Test of addMoney method, of class VendingMachineService.
     */
    @Test
    public void testAddMoney() {
        String firstAdd = "1.00";
        String returnFromAddMoney = service.addMoney(new BigDecimal("1.00"));
        assertEquals(firstAdd, returnFromAddMoney);
        
        String secondAdd = "1.50";
        String returnSecondTime = service.addMoney(new BigDecimal("0.50"));
        
        assertEquals(secondAdd, returnSecondTime);
        
        
        
        
    }

    /**
     * Test of vendService method, of class VendingMachineService.
     */
    @Test
    public void testVendService() throws Exception {
        
        service.addMoney(new BigDecimal("1.25"));
        
        service.vendService("A1");
    }
    
    @Test
    public void testVendServiceInsufficientFunds() throws Exception {
        
        service.addMoney(new BigDecimal("1.00"));
        
        try {
            service.vendService("A1");
            fail("Expected VendingMachineInsufficientFundsException was not thrown.");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
    }
    
    @Test
    public void testVendServiceInsufficientInventory() throws Exception {
        
        
        service.addMoney(new BigDecimal("1.25"));
        
        try {
            service.vendService("A2");
            fail("Expected VendingMachineInsufficientInventoryException was not thrown.");
        } catch (VendingMachineInsufficientInventoryException e) {
            return;
        }
    }
    
    

    /**
     * Test of getAllSnacksInInventory method, of class VendingMachineService.
     */
    @Test
    public void testGetAllSnacksInInventory() throws Exception {
        assertEquals(2, service.getAllSnacksInInventory().size());
    }

    /**
     * Test of getSnackAtLocation method, of class VendingMachineService.
     */
    @Test
    public void testGetSnackAtLocation() throws Exception {
        Snack snickers = service.getSnackAtLocation("A1");
        assertNotNull(snickers);
        
        Snack nothing = service.getSnackAtLocation("My Belly");
        assertNull(nothing);
        
    }

    
}
