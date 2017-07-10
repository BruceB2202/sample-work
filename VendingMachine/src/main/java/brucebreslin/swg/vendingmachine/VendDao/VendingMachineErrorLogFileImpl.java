/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineErrorLogFileImpl implements VendingMachineErrorLog{

    public static final String ERROR_LOG = "errorLog.txt";
    
    @Override
    public void writeErrorLog(String entry) throws VendFilePersistenceException {
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(ERROR_LOG, true));
        } catch (IOException e){
            throw new VendFilePersistenceException("Could not persist log information.", e);
        }
        
        
        out.println(entry);
        out.flush();
    }
    
}
