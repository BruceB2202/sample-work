/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.section4unittestlab;

/**
 *
 * @author Bruce_Breslin
 */
public class EveryOther {
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public String everyOther(String str) {
        String returnedString = "";
        for(int x = 0; x < str.length(); x++){
            if(x == 0 || (x % 2) == 0)
            returnedString += Character.toString(str.charAt(x));
        }
        
        return returnedString;
    }
    
}
