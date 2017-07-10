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
public class FlooringMasteryDuplicateProductIdException extends Exception {

    public FlooringMasteryDuplicateProductIdException(String message) {
        super(message);
    }

    public FlooringMasteryDuplicateProductIdException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
