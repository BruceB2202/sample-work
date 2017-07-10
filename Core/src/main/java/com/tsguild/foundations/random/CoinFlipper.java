/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random;

import java.util.Random;

/**
 *
 * @author Bruce_Breslin
 */
public class CoinFlipper {
    public static void main(String[] args) {
        Random coinFlip = new Random();
        
        System.out.println("Time to flip a coin.");
        boolean isHeads = coinFlip.nextBoolean();
        if (isHeads == true){
            System.out.println("It is heads!!");
        }else {
            System.out.println("It is tails!!");
        }
    }
}
