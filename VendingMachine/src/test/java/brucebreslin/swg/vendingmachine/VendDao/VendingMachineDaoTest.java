/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import brucebreslin.swg.vendingmachine.VendDto.Snack;
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
public class VendingMachineDaoTest {
    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        List<Snack> snackList = dao.getAllSnacksInInventory();
        for(Snack currentSnack: snackList){
            dao.removeSnack(currentSnack.getLocationInMachine());
        }
    }
    
    @After
    public void tearDown() {
    }

   
    
    
    
    
    
    
    
    /**
     * Test of vend method, of class VendingMachineDao.
     */
    @Test
    public void testVend() throws Exception {
        Snack snickers = new Snack("A1");
        snickers.setName("Snickers");
        snickers.setCost(new BigDecimal("1.25"));
        snickers.setAmountInStock(10);
        
        dao.addSnack(snickers.getLocationInMachine(), snickers);
        Snack afterVendSnicker = dao.vend("A1");
        assertEquals(9, afterVendSnicker.getAmountInStock());
    }

    /**
     * Test of getAllSnacksInInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllSnacksInInventory() throws Exception {
        Snack snickers = new Snack("A1");
        snickers.setName("Snickers");
        snickers.setCost(new BigDecimal("1.25"));
        snickers.setAmountInStock(10);
        
        Snack twix = new Snack("A2");
        twix.setName("Twix");
        twix.setCost(new BigDecimal("1.25"));
        twix.setAmountInStock(10);
        dao.addSnack(snickers.getLocationInMachine(), snickers);
        dao.addSnack(twix.getLocationInMachine(), twix);
        
        assertEquals(2,dao.getAllSnacksInInventory().size());
    }

    /**
     * Test of getSnackAtLocation method, of class VendingMachineDao.
     */
    @Test
    public void testAddGetSnackAtLocation() throws Exception {
        Snack snickers = new Snack("A1");
        snickers.setName("Snickers");
        snickers.setCost(new BigDecimal("1.25"));
        snickers.setAmountInStock(10);
        
        dao.addSnack(snickers.getLocationInMachine(), snickers);
        Snack daoSnicker = dao.getSnackAtLocation("A1");
        
        assertEquals(snickers, daoSnicker);
    }
    
    
    /**
     * Test of removeSnack method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveSnack() throws Exception {
        Snack snickers = new Snack("A1");
        snickers.setName("Snickers");
        snickers.setCost(new BigDecimal("1.25"));
        snickers.setAmountInStock(10);
        
        Snack twix = new Snack("A2");
        twix.setName("Twix");
        twix.setCost(new BigDecimal("1.25"));
        twix.setAmountInStock(10);
        dao.addSnack(snickers.getLocationInMachine(), snickers);
        dao.addSnack(twix.getLocationInMachine(), twix);
        
        
        dao.removeSnack(snickers.getLocationInMachine());
        assertEquals(1, dao.getAllSnacksInInventory().size());
        assertNull(dao.getSnackAtLocation(snickers.getLocationInMachine()));
        
        dao.removeSnack(twix.getLocationInMachine());
        assertEquals(0, dao.getAllSnacksInInventory().size());
        assertNull(dao.getSnackAtLocation(twix.getLocationInMachine()));
        
        
    }
    
    
    
}
