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
public class FlooringMasteryDuplicateOrderIdException extends Exception {

    public FlooringMasteryDuplicateOrderIdException(String message) {
        super(message);
    }

    public FlooringMasteryDuplicateOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }

}
