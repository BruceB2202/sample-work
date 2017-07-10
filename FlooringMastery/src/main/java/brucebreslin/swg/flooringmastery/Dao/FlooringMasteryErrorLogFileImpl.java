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
public class FlooringMasteryErrorLogFileImpl implements FlooringMasteryErrorLog{
    public static final String ERROR_LOG = "errorLog.txt";

    @Override
    public void writeErrorLogEntry(String entry) throws FlooringMasteryDataPersistenceException{
        PrintWriter out;
         try{
             out = new PrintWriter(new FileWriter(ERROR_LOG));
         } catch (IOException ex) {
            throw new FlooringMasteryDataPersistenceException("Unable to write to the error log.");
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
    
    
    
    
}
