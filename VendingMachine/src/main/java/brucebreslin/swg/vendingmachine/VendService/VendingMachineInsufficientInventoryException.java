/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendService;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineInsufficientInventoryException extends Exception {

    public VendingMachineInsufficientInventoryException(String message){
        super(message);
    }
    public VendingMachineInsufficientInventoryException(String message, Throwable cause){
        super(message, cause);
    }
    
}
