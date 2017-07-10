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
public class VendingMachineTransactionLogFileImpl implements VendingMachineTransactionLog {

    public static final String TRANSACTION_LOG = "transactionLog.txt";

    @Override
    public void writeTransactionLog(String logEntry) throws VendFilePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(TRANSACTION_LOG, true));
        } catch (IOException e) {
            throw new VendFilePersistenceException("Could not persist log information.", e);
        }

        out.println(logEntry);
        out.flush();
    }
}
