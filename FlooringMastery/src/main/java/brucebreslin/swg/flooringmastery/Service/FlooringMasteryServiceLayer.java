/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Service;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface FlooringMasteryServiceLayer {
    /**
     *Adds the order to the order list and associates it with the given orders order ID.
     * 
     * @param order the order to be added to the order list
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDuplicateOrderIdException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     * @throws brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException
     */
    void addOrder(Order order) throws FlooringMasteryDuplicateOrderIdException, FlooringMasteryDataValidationException, FlooringMasteryDataPersistenceException;
    
    /**
     *Returns the order object associated with the given order ID. Returns null if no order exists with the given ID.
     * 
     * @param orderId ID of the desired order object
     * @return object with given ID, null if none exists
     */
    Order getOrder(int orderId);
    
    /**
     * Returns all orders in the system.
     * @return a list of all orders currently in the system.
     */
    List<Order> getAllOrders();
    
    /**
     *Returns a list of orders associated with the given date.
     * 
     * @param desiredDate date of desired order(s)
     * @return list of orders from given date if there are any
     */
    List<Order> getOrdersFromDate(LocalDate desiredDate);
    
    /**
     *Updates any fields that have been modified for the existing order with the same ID as the given order.
     *
     * @param editedOrder modified version of order to be edited
     * @return returns the order that has been modified
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryOrderNotFoundException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     */
    Order editOrder(Order editedOrder) throws FlooringMasteryOrderNotFoundException, FlooringMasteryDataValidationException;
    
    /**
     *Deletes the order object associated with the given ID from the order list if it exists.
     * 
     * @param orderToRemove
     * @return the order removed from the list if it exists
     */
    Order removeOrder(Order orderToRemove);
    
    /**
     * Adds the given product to the list of products.
     * @param product Product object to be added to the inventory of products
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDuplicateProductIdException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     */
    void addProduct(Product product)throws FlooringMasteryDuplicateProductIdException, FlooringMasteryDataValidationException;
    
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
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryProductNotFoundException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     */
    Product editProduct(Product modifiedProduct)throws FlooringMasteryProductNotFoundException, FlooringMasteryDataValidationException;
    
    /**
     * Removes the product object associated with the given product ID from the product inventory if one exists.
     * @param productId the ID of the product to be removed from the inventory
     * @return the product object being removed if one exists.
     */
    Product removeProduct(int productId);
    
    /**
     * Adds the given state object to the list of states provided to.
     * @param state the state object to be added to the list
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDuplicateStateIdException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     */
    void addState(State state)throws FlooringMasteryDuplicateStateIdException, FlooringMasteryDataValidationException;
    
    /**
     * Returns the state object associated with the given state ID if one exists.
     * @param stateId the state ID of the desired state object
     * @return the state object associated with the given state ID if one exists, null otherwise.
     */
    State getState(int stateId);
    
    /**
     * Returns a list of all states in the list of states serviced
     * @return all states in the states serviced list
     */
    List<State> getAllStates();
    
    /**
     * Updates the modified values for the given state object
     * @param modifiedState the state object with the values that have been modified
     * @return the updated state object from the state list.
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryStateNotFoundException
     * @throws brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException
     */
    State editState(State modifiedState) throws FlooringMasteryStateNotFoundException, FlooringMasteryDataValidationException;
    
    /**
     * Removes the state object associated with the given state ID.
     * @param stateId the state ID of the state to be removed
     * @return the state object that was removed if one existed, null otherwise.
     */
    State removeState(int stateId);

    Order calculateCostsAndTaxes(Order shellOrder);

    void saveOrders() throws FlooringMasteryDataPersistenceException;
    
    void loadOrders() throws FlooringMasteryDataPersistenceException;

    public int getNextOrderNumber();

    public void loadNextOrderNumber() throws FlooringMasteryDataPersistenceException;

    public void loadStates() throws FlooringMasteryDataPersistenceException;

    public void loadProducts() throws FlooringMasteryDataPersistenceException;
    
    public void saveOrderNumber() throws FlooringMasteryDataPersistenceException;

    public void removeBlankOrderFile(LocalDate dateToBlankOut) throws FlooringMasteryDataPersistenceException;
    
}
