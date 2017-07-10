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
public class DoubleX {

    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        boolean xFound = false;
        boolean doubleXFound = false;
        int x = 0;

        for (x = 0; x < str.length() - 1; x++) {
            if (!xFound && Character.toString(str.charAt(x)).equalsIgnoreCase("x")) {
                xFound = true;
                if (Character.toString(str.charAt(x + 1)).equalsIgnoreCase("x")) {
                    doubleXFound = true;
                }
            }

        }

        return doubleXFound;
    }
}
