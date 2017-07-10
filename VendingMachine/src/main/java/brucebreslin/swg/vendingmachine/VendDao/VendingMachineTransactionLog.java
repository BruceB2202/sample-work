/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

/**
 *
 * @author Bruce_Breslin
 */
public interface VendingMachineTransactionLog {
    public void writeTransactionLog(String logEntry) throws VendFilePersistenceException;
}
