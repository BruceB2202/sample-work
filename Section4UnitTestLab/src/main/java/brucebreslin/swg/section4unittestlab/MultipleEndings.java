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
public class MultipleEndings {
        // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    public String multipleEndings(String str) {
        int lastIndex = str.length();
        int firstIndex = str.length() - 2;
        
        String lastTwo = str.substring(firstIndex, lastIndex);
        return lastTwo + lastTwo + lastTwo;
        
    }
}
