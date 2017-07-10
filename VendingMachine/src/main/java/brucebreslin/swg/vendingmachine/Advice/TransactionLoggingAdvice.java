/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.Advice;

import brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineDao;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineTransactionLog;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Bruce_Breslin
 */
public class TransactionLoggingAdvice {
    VendingMachineTransactionLog transactionLog;
    VendingMachineDao dao;
    
    public TransactionLoggingAdvice(VendingMachineTransactionLog transactionLog, VendingMachineDao dao){
        this.transactionLog = transactionLog;
        this.dao = dao;
    }
    
    public void createTransactionLog(JoinPoint jp) throws VendFilePersistenceException{
        Object[] args = jp.getArgs();
        String snackName = dao.getSnackAtLocation(args[0].toString()).getName();
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = timestamp + ":: Sold- " + snackName;
        try {
            transactionLog.writeTransactionLog(entry);
        } catch (VendFilePersistenceException e) {
            System.err.println(
               "ERROR: Could not create log entry in Error Log.");
        }
        
    }
}
