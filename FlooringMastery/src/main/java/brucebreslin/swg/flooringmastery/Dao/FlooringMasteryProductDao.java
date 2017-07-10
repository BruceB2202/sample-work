/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.Product;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface FlooringMasteryProductDao {
    
    /**
     * Adds the given product to the list of products.
     * @param product Product object to be added to the inventory of products
     * @return product currently in the system with given products ID, null if none exists.
     */
    Product addProduct(Product product);
    
    /**
     * Returns the product object associated with the given product ID, null if none exists.
     * @param productId the product ID of the wanted product object
     * @return the product object associated with the given product ID if one exists, null otherwise.
     */
    Product getProduct(int productId);
    
    /**
     * Returns a list of all available product objects
     * @return all product objects in the product inventory
     */
    List<Product> getAllProducts();
    
    /**
     * Updates modified values for given product.
     * @param modifiedProduct the modified version of the product that needs to be updated
     * @return the updated product object
     */
    Product editProduct(Product modifiedProduct);
    
    /**
     * Removes the product object associated with the given product ID from the product inventory if one exists.
     * @param productId the ID of the product to be removed from the inventory
     * @return the product object being removed if one exists.
     */
    Product removeProduct(int productId);
    
    void saveProducts(List<Product> productList) throws FlooringMasteryDataPersistenceException;
    
    
    void loadProducts() throws FlooringMasteryDataPersistenceException;
}
