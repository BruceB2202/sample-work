/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.Product;
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
public class FlooringMasteryProductDaoImplTest {
    
    FlooringMasteryProductDao productDao = new FlooringMasteryProductDaoFileImpl();
    
    public FlooringMasteryProductDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Product> productList = productDao.getAllProducts();
        for(Product product : productList){
            productDao.removeProduct(product.getProductId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct and getProduct methods, of class FlooringMasteryProductDaoFileImpl.
     */
    @Test
    public void testAddAndGetProduct() {
        Product newProduct = new Product(1);
        newProduct.setProductName("Carpet");
        newProduct.setMaterialCostPerSqFt(new BigDecimal("2.25"));
        newProduct.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct);
        
        Product fromDao = productDao.getProduct(1);
        assertEquals(fromDao, newProduct);
        
        
    }

    /**
     * Test of getAllProducts method, of class FlooringMasteryProductDaoFileImpl.
     */
    @Test
    public void testGetAllProducts() {
        Product newProduct = new Product(1);
        newProduct.setProductName("Carpet");
        newProduct.setMaterialCostPerSqFt(new BigDecimal("2.25"));
        newProduct.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct);
        
        Product newProduct2 = new Product(2);
        newProduct2.setProductName("Laminate");
        newProduct2.setMaterialCostPerSqFt(new BigDecimal("1.75"));
        newProduct2.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct2);
        
        assertEquals(2, productDao.getAllProducts().size());
    }

    /**
     * Test of editProduct method, of class FlooringMasteryProductDaoFileImpl.
     */
    @Test
    public void testEditProduct() {
        Product newProduct = new Product(1);
        newProduct.setProductName("Carpet");
        newProduct.setMaterialCostPerSqFt(new BigDecimal("2.25"));
        newProduct.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct);
        
        Product newProduct2 = new Product(1);
        newProduct2.setProductName("Carpet");
        newProduct2.setMaterialCostPerSqFt(new BigDecimal("2.25"));
        newProduct2.setLaborCostPerSqFt(new BigDecimal("2.00"));
        productDao.addProduct(newProduct2);
        
        Product fromDao = productDao.getProduct(1);
        assertNotEquals(fromDao, newProduct);
        assertEquals(fromDao, newProduct2);
        
        
    }

    /**
     * Test of removeProduct method, of class FlooringMasteryProductDaoFileImpl.
     */
    @Test
    public void testRemoveProduct() {
        Product newProduct = new Product(1);
        newProduct.setProductName("Carpet");
        newProduct.setMaterialCostPerSqFt(new BigDecimal("2.25"));
        newProduct.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct);
        
        Product newProduct2 = new Product(2);
        newProduct2.setProductName("Laminate");
        newProduct2.setMaterialCostPerSqFt(new BigDecimal("1.75"));
        newProduct2.setLaborCostPerSqFt(new BigDecimal("2.10"));
        productDao.addProduct(newProduct2);
        
        assertEquals(2, productDao.getAllProducts().size());
        productDao.removeProduct(1);
        assertEquals(1, productDao.getAllProducts().size());
        productDao.removeProduct(2);
        assertEquals(0, productDao.getAllProducts().size());
        
        
    }
    
}
