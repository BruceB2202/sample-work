/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.section03unittests;

/**
 *
 * @author Bruce_Breslin
 */
public class MakePi {
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        double myPi = Math.PI;
        Double piDouble = new Double(myPi);
        String piString = piDouble.toString();
        StringBuilder sb = new StringBuilder(piString);
        sb = sb.deleteCharAt(1);
        piString = sb.toString();
        String piStringLengthFixed = piString.substring(0, n);
        int[] piIntArray = new int[piStringLengthFixed.length()];
        for (int x = 0; x < piStringLengthFixed.length(); x++) {
            piIntArray[x] = piString.charAt(x) - '0';    
        }
        return piIntArray;
    }
}
