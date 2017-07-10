/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Bruce_Breslin
 */
public class State {
    private int stateId;
    private String stateName;
    private BigDecimal stateTaxRate;
    
    public State(int stateId){
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return stateId + ": " + stateName + " || " + stateTaxRate.toString();
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.stateId;
        hash = 59 * hash + Objects.hashCode(this.stateName);
        hash = 59 * hash + Objects.hashCode(this.stateTaxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.stateId != other.stateId) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.stateTaxRate, other.stateTaxRate)) {
            return false;
        }
        return true;
    }

    public int getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getStateTaxRate() {
        return stateTaxRate;
    }

    public void setStateTaxRate(BigDecimal stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }
    
}
