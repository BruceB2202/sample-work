/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendService;

import brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException;
import brucebreslin.swg.vendingmachine.VendDto.Snack;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface VendingMachineService {
    
    /**
     * 
     * Adds money to the current balance. Adds an amount of money to the current balance and returns the new balance as a String.
     * 
     * 
     * @param moneyToAdd the amount to be added to the current balance
     * @return the new balance after adding the parameter moneyToAdd to the existing balance.
     */
    String addMoney(BigDecimal moneyToAdd);

    Change vendService(String wantedItemLocation) throws VendingMachineInsufficientFundsException, VendingMachineInsufficientInventoryException, VendFilePersistenceException;

    List<Snack> getAllSnacksInInventory() throws VendFilePersistenceException;
    
    Snack getSnackAtLocation(String location) throws VendFilePersistenceException;
}
