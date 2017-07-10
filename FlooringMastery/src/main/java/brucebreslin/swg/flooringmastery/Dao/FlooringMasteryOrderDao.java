/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import brucebreslin.swg.flooringmastery.Model.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruce_Breslin
 */
public interface FlooringMasteryOrderDao {
    
    /**
     *Adds the order to the order list and associates it with the given orders order ID.
     * 
     * @param order the order to be added to the order list
     * @return returns an order with the same order ID as the given order if one exists, returns null otherwise.
     * @throws brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException
     */
    Order addOrder(Order order) throws FlooringMasteryDataPersistenceException;
    
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
     *Returns a map of all orders sorted by date.
     * 
     * @return map of all orders sorted by date
     */
    Map<LocalDate , List<Order>> getAllOrdersByDate();
    
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
     */
    Order editOrder(Order editedOrder);
    
    /**
     *Deletes the order object associated with the given ID from the order list if it exists.
     * 
     * @param orderToRemove
     * @return the order removed from the list if it exists
     */
    Order removeOrder(Order orderToRemove);
    
    
    /**
     * Saves the current list of orders, unless program is in training mode.
     * @param orderList orders to be saved, unless the program is in training mode in which case there is no saving.
     * @throws brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException
     */
    void saveOrders(List<Order> orderList) throws FlooringMasteryDataPersistenceException;
    
    
    /**
     * Returns a list of Orders with the order date value matching the given desiredDate.
     * @param desiredDate LocalDate of desired orders to retrieve.
     * @throws brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException
     */
    void loadOrders() throws FlooringMasteryDataPersistenceException;

    public int getNextOrderNumber();
    public void loadNextOrderNumber() throws FlooringMasteryDataPersistenceException;

    public void saveNextOrderNumber()throws FlooringMasteryDataPersistenceException;

    public void removeBlankOrderFile(LocalDate dateToBlankOut) throws FlooringMasteryDataPersistenceException;
}
