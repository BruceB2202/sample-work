/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendService;

import java.math.BigDecimal;

/**
 *
 * @author Bruce_Breslin
 */
public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    void getChangeDue(BigDecimal penniesToGive) {
        this.quarters = 0;
        this.dimes = 0;
        this.nickels = 0;
        this.pennies = 0;
        
        
        String pennyString = penniesToGive.toString();
        int pennyToGiveInt = Integer.parseInt(pennyString);
        
        int penniesLeftAfterQuarters = pennyToGiveInt % 25;
        this.quarters = (pennyToGiveInt - penniesLeftAfterQuarters) / 25;
        
        int penniesLeftAfterDimes = penniesLeftAfterQuarters % 10;
        this.dimes = (penniesLeftAfterQuarters - penniesLeftAfterDimes) / 10;
        
        int penniesLeftAfterNickels = penniesLeftAfterDimes % 10;
        this.nickels = (penniesLeftAfterDimes - penniesLeftAfterNickels) / 5;
        
        this.pennies = penniesLeftAfterNickels;
        
        
        
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

    

}
