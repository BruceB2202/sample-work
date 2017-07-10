/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryStateDaoFileImpl implements FlooringMasteryStateDao{
    public static final String ROSTER_FILE = "states.txt";
    public static final String DELIMITER = "::";
    
    
    
    private Map<Integer, State> statesServiced = new HashMap<>();

    @Override
    public State addState(State state) {
        State newState = statesServiced.put(state.getStateId(), state);
        return newState;
    }

    @Override
    public State getState(int stateId) {
        return statesServiced.get(stateId);
    }

    @Override
    public List<State> getAllStates() {
        return new ArrayList<State>(statesServiced.values());
    }

    @Override
    public State editState(State modifiedState) {
        State editedState = statesServiced.put(modifiedState.getStateId(), modifiedState);
        return editedState;
    }

    @Override
    public State removeState(int stateId) {
        State removedState = statesServiced.remove(stateId);
        return removedState;
    }
    
    @Override
    public void saveStates(List<State> stateList) throws FlooringMasteryDataPersistenceException{
        
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        }catch(IOException e){
            throw new FlooringMasteryDataPersistenceException("State list could not be saved at this time.");
        }
        
        for(State state : stateList){
            out.println(state.getStateId() + DELIMITER + state.getStateName() + DELIMITER + state.getStateTaxRate().setScale(2, RoundingMode.HALF_UP));
            
            out.flush();
        }
        out.close();
        
        
    }
    
    @Override
    public void loadStates() throws FlooringMasteryDataPersistenceException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        }catch(FileNotFoundException e){
            throw new FlooringMasteryDataPersistenceException("State List could not be loaded.");
        }
        
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            State currentState = new State(Integer.parseInt(currentTokens[0]));
            currentState.setStateName(currentTokens[1]);
            currentState.setStateTaxRate(new BigDecimal(currentTokens[2]));
            
            statesServiced.put(currentState.getStateId(), currentState);
        }
        scanner.close();
        
        
    }
    
    
}
