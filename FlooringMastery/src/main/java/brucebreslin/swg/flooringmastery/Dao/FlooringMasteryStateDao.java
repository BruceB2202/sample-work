/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.State;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface FlooringMasteryStateDao {
    
    /**
     * Adds the given state object to the list of states provided to.
     * @param state the state object to be added to the list
     * @return the state object that was added to the list
     */
    State addState(State state);
    
    /**
     * Returns the state object associated with the given state ID if one exists.
     * @param stateId the state ID of the desired state object
     * @return the state object associated with the given state ID if one exists, null otherwise.
     */
    State getState(int stateId);
    
    /**
     * Returns a list of all states in the list of states serviced
     * @return all states in the states serviced list
     */
    List<State> getAllStates();
    
    /**
     * Updates the modified values for the given state object
     * @param modifiedState the state object with the values that have been modified
     * @return the updated state object from the state list.
     */
    State editState(State modifiedState);
    
    /**
     * Removes the state object associated with the given state ID.
     * @param stateId the state ID of the state to be removed
     * @return the state object that was removed if one existed, null otherwise.
     */
    State removeState(int stateId);
    
    void saveStates(List<State> stateList) throws FlooringMasteryDataPersistenceException;
    
    void loadStates() throws FlooringMasteryDataPersistenceException;
}
