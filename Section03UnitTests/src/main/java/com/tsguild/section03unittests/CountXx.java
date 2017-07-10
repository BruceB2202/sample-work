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
public class CountXx {
    
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        int concurrentXs = 0;
        int numberOfGroups = 0;
        char[] array= str.toCharArray();
        for(char letter: array){
            String currentLetter = Character.toString(letter);
            if(currentLetter.equals("x")){
                concurrentXs++;
                if(concurrentXs == 2){
                    numberOfGroups++;
                    concurrentXs = 1;
                }
            }else{
                concurrentXs = 0;
            }
        }
        return numberOfGroups;
    }
    
}
