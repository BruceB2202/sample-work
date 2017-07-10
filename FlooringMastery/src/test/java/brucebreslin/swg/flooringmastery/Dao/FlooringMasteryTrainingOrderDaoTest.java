/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
public class FlooringMasteryTrainingOrderDaoTest {
    FlooringMasteryTrainingOrderDaoFileImpl trainingDao = new FlooringMasteryTrainingOrderDaoFileImpl();
    
    public FlooringMasteryTrainingOrderDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Order> orderList = trainingDao.getAllOrders();
        for(Order order : orderList){
            trainingDao.removeOrder(order);
        }
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder and getOrder methods, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testAddAndGetOrder() throws FlooringMasteryDataPersistenceException {
        Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        
        Order fromDao = trainingDao.getOrder(1);
        assertEquals(newOrder, fromDao);
        
    }

    /**
     * Test of getAllOrdersByDate method, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testGetAllOrdersByDate() throws FlooringMasteryDataPersistenceException {
        Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Christine Breslin");
        newOrder2.setCustomerProduct(testProduct);
        newOrder2.setCustomerState(testState);
        newOrder2.setAreaOfProject(new BigDecimal("500"));
        newOrder2.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder2.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder2.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder2.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder2.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder2);
        
        Order newOrder3 = new Order(3);
        newOrder3.setCustomerName("Chelsea Breslin");
        newOrder3.setCustomerProduct(testProduct);
        newOrder3.setCustomerState(testState);
        newOrder3.setAreaOfProject(new BigDecimal("500"));
        newOrder3.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder3.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder3.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder3.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder3.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder3);
        
        Map<LocalDate, List<Order>> orderListByDate = trainingDao.getAllOrdersByDate();
        
        assertEquals(2, orderListByDate.size());
        assertEquals(1, orderListByDate.get(LocalDate.now()).size());
        assertEquals(2, orderListByDate.get(LocalDate.of(2017, 01, 8)).size());
        
        
        
        
        
    }

    /**
     * Test of getOrdersFromDate method, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testGetOrdersFromDate() throws FlooringMasteryDataPersistenceException {
        Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Christine Breslin");
        newOrder2.setCustomerProduct(testProduct);
        newOrder2.setCustomerState(testState);
        newOrder2.setAreaOfProject(new BigDecimal("500"));
        newOrder2.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder2.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder2.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder2.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder2.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder2);
        
        Order newOrder3 = new Order(3);
        newOrder3.setCustomerName("Chelsea Breslin");
        newOrder3.setCustomerProduct(testProduct);
        newOrder3.setCustomerState(testState);
        newOrder3.setAreaOfProject(new BigDecimal("500"));
        newOrder3.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder3.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder3.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder3.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder3.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder3);
        
        assertEquals(2, trainingDao.getOrdersFromDate(LocalDate.of(2017, 01, 8)).size());
        assertEquals(1, trainingDao.getOrdersFromDate(LocalDate.now()).size());
        
        
        
    }
    
    /**
     * Test of the getAllOrders method, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testGetAllOrders() throws FlooringMasteryDataPersistenceException{
        Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Christine Breslin");
        newOrder2.setCustomerProduct(testProduct);
        newOrder2.setCustomerState(testState);
        newOrder2.setAreaOfProject(new BigDecimal("500"));
        newOrder2.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder2.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder2.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder2.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder2.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder2);
        
        Order newOrder3 = new Order(3);
        newOrder3.setCustomerName("Chelsea Breslin");
        newOrder3.setCustomerProduct(testProduct);
        newOrder3.setCustomerState(testState);
        newOrder3.setAreaOfProject(new BigDecimal("500"));
        newOrder3.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder3.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder3.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder3.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder3.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder3);
        
        
        assertEquals(3, trainingDao.getAllOrders().size());
        
        
        
    }

    /**
     * Test of editOrder method, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testEditOrder() throws FlooringMasteryDataPersistenceException {
         Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        Order newOrder2 = new Order(1);
        newOrder2.setCustomerName("Christine Breslin");
        newOrder2.setCustomerProduct(testProduct);
        newOrder2.setCustomerState(testState);
        newOrder2.setAreaOfProject(new BigDecimal("500"));
        newOrder2.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder2.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder2.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder2.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder2.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder2);
        
        Order fromDaoAfterEdit = trainingDao.getOrder(1);
        
        assertNotEquals(newOrder, fromDaoAfterEdit);
        assertEquals(newOrder2, fromDaoAfterEdit);
        
        
        
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryTrainingOrderDaoFileImpl.
     */
    @Test
    public void testRemoveOrder() throws FlooringMasteryDataPersistenceException {
        Product testProduct = new Product(1);
        testProduct.setProductName("Test Product");
        testProduct.setMaterialCostPerSqFt(BigDecimal.ZERO);
        testProduct.setLaborCostPerSqFt(BigDecimal.ZERO);
        
        State testState = new State(1);
        testState.setStateName("OH");
        testState.setStateTaxRate(BigDecimal.ZERO);
                
        
        Order newOrder = new Order(1);
        newOrder.setCustomerName("Bruce Breslin");
        newOrder.setCustomerProduct(testProduct);
        newOrder.setCustomerState(testState);
        newOrder.setAreaOfProject(new BigDecimal("400"));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder);
        
        Order newOrder2 = new Order(2);
        newOrder2.setCustomerName("Christine Breslin");
        newOrder2.setCustomerProduct(testProduct);
        newOrder2.setCustomerState(testState);
        newOrder2.setAreaOfProject(new BigDecimal("500"));
        newOrder2.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder2.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder2.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder2.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder2.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder2);
        
        Order newOrder3 = new Order(3);
        newOrder3.setCustomerName("Chelsea Breslin");
        newOrder3.setCustomerProduct(testProduct);
        newOrder3.setCustomerState(testState);
        newOrder3.setAreaOfProject(new BigDecimal("500"));
        newOrder3.setOrderDate(LocalDate.of(2017, 01, 8));
        newOrder3.setTotalCostOfLabor(BigDecimal.ZERO);
        newOrder3.setTotalCostOfMaterials(BigDecimal.ZERO);
        newOrder3.setTotalOrderTaxes(BigDecimal.ZERO);
        newOrder3.setTotalOrderPrice(BigDecimal.ZERO);
        trainingDao.addOrder(newOrder3);
        
        
        assertEquals(3, trainingDao.getAllOrders().size());
        trainingDao.removeOrder(newOrder3);
        assertEquals(2, trainingDao.getAllOrders().size());
        trainingDao.removeOrder(newOrder2);
        assertEquals(1, trainingDao.getAllOrders().size());
        trainingDao.removeOrder(newOrder);
        assertEquals(0, trainingDao.getAllOrders().size());
        
        
    }
    
}
