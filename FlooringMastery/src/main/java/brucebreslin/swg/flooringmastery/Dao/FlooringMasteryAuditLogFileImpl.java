/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryAuditLogFileImpl implements FlooringMasteryAuditLog{
    public static final String AUDIT_LOG = "flooringMasteryAuditLog.txt";

    @Override
    public void writeAuditLogEntry(String entry) throws FlooringMasteryDataPersistenceException{
        PrintWriter out;
         try{
             out = new PrintWriter(new FileWriter(AUDIT_LOG, true));
         } catch (IOException ex) {
            throw new FlooringMasteryDataPersistenceException("There was an error writing to the audit log.");
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        
    }
    
    
    
}
