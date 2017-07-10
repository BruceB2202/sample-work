/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.Advice;

import brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineDao;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineErrorLog;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineInsufficientFundsException;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineInsufficientInventoryException;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Bruce_Breslin
 */
public class ErrorLoggingAdvice {
    VendingMachineErrorLog errorLog;
    VendingMachineDao dao;
    
    public ErrorLoggingAdvice(VendingMachineErrorLog errorLog, VendingMachineDao dao){
        this.errorLog = errorLog;
        this.dao = dao;
    }
    
    public void createInsufficientFundsLog(JoinPoint jp, VendingMachineInsufficientFundsException fundException) throws VendFilePersistenceException{
        Object[] args = jp.getArgs();
        String snackName = dao.getSnackAtLocation(args[0].toString()).getName();
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = timestamp + ": InsufficientFundsException || " + snackName;
        try {
            errorLog.writeErrorLog(entry);
        } catch (VendFilePersistenceException e) {
            System.err.println(
               "ERROR: Could not create log entry in Error Log.");
        }
        
    }
    
    public void createInsufficientInventoryLog(JoinPoint jp, VendingMachineInsufficientInventoryException inventoryException) throws VendFilePersistenceException{
        Object[] args = jp.getArgs();
        String snackName = dao.getSnackAtLocation(args[0].toString()).getName();
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = timestamp + ": InsufficientInventoryException || " + snackName;
        try {
            errorLog.writeErrorLog(entry);
        } catch (VendFilePersistenceException e) {
            System.err.println(
               "ERROR: Could not create log entry in Error Log.");
        }
        
    }
    
}
