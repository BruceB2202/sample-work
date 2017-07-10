/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Service;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryProductNotFoundException extends Exception {

    public FlooringMasteryProductNotFoundException(String message) {
        super(message);
    }

    public FlooringMasteryProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
