/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import java.io.IOException;

/**
 *
 * @author Bruce_Breslin
 */
public class VendFilePersistenceException extends Exception {

    public VendFilePersistenceException(String message){
        super(message);
    }
    public VendFilePersistenceException(String message, Throwable cause){
        super(message, cause);
    }
    
}
