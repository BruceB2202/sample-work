/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Advice;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryErrorLog;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryDuplicateOrderIdException;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryOrderNotFoundException;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryErrorLoggingAdvice {
    FlooringMasteryErrorLog errorLog;
        public FlooringMasteryErrorLoggingAdvice(FlooringMasteryErrorLog errorLog){
            this.errorLog = errorLog;
        }
    
    public void createDuplicateOrderIdLog(JoinPoint jp, FlooringMasteryDuplicateOrderIdException duplicateId) throws FlooringMasteryDataPersistenceException{
        
        
        
        Object[] args = jp.getArgs();
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = timestamp + ": Duplicate Order Id Exception || ";
        for(Object arg : args){
            entry += arg;
        }
        try {
            errorLog.writeErrorLogEntry(entry);
        } catch (FlooringMasteryDataPersistenceException e) {
            System.err.println(
               "ERROR: Could not create log entry in Error Log.");
        }
        
    }
    
    public void createOrderNotFoundLog(JoinPoint jp, FlooringMasteryOrderNotFoundException orderNotFound) throws FlooringMasteryDataPersistenceException{
        
        
        
        Object[] args = jp.getArgs();
        LocalDateTime timestamp = LocalDateTime.now();
        String entry = timestamp + ": Order Not Found Exception || ";
        for(Object arg : args){
            entry += arg;
        }
        try {
            errorLog.writeErrorLogEntry(entry);
        } catch (FlooringMasteryDataPersistenceException e) {
            System.err.println(
               "ERROR: Could not create log entry in Error Log.");
        }
        
    }
    
    
}
