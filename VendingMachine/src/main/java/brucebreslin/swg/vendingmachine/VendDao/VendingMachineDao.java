/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import brucebreslin.swg.vendingmachine.VendDto.Snack;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineInsufficientFundsException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface VendingMachineDao {
    
    /**
     * Dispenses the given snack item, and reduces on hand value in inventory. Returns the snackItem vended if there is one in inventory, returns null otherwise.
     * 
     * 
     * @param location location of the item in the vending machine(ie. A1, C9)
     * @return the updated snackItem being vended if there is one in inventory, null otherwise
     * @throws brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException
     */
    
    Snack vend(String location) throws VendFilePersistenceException;
    
    /**
     * Returns a list of all the snacks in the inventory.
     * 
     * @return list of all snacks on the inventory list.
     * @throws brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException
     */
    List<Snack> getAllSnacksInInventory() throws VendFilePersistenceException;

    
    /**
     * Returns the snack item stored in the given location. If there is an item in the location provided it will be returned, otherwise null will be returned.
     * @param location the location of the item desired.
     * @return the snack item in the given location, null otherwise.
     * @throws brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException
     */
    Snack getSnackAtLocation(String location) throws VendFilePersistenceException;
    
    /**
     * 
     * @param location
     * @param snack
     * @return 
     */
    Snack addSnack(String location, Snack snack) throws VendFilePersistenceException;
    
    /**
     * 
     * @param location
     * @return
     * @throws VendFilePersistenceException 
     */
    Snack removeSnack(String location) throws VendFilePersistenceException;
    
}
