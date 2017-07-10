/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

/**
 *
 * @author Bruce_Breslin
 */
public interface FlooringMasteryErrorLog {
    void writeErrorLogEntry(String entry)throws FlooringMasteryDataPersistenceException;
}
