/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Advice;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryAuditLog;
import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryAuditLogAdvice {
    FlooringMasteryAuditLog auditLog;
    
    public FlooringMasteryAuditLogAdvice(FlooringMasteryAuditLog auditLog){
        this.auditLog = auditLog;
    }
    
    
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditLog.writeAuditLogEntry(auditEntry);
        } catch (FlooringMasteryDataPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    
}
