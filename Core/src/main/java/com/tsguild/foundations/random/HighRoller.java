/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class HighRoller {
    public static void main(String[] args) {
        int diceSides;
        Scanner userInput = new Scanner(System.in);
        Random diceRoller = new Random();
        
        System.out.println("Time to roll the dice!");
        System.out.println("How many sides does your die have?");
        diceSides = userInput.nextInt();
        
        int rollResult = diceRoller.nextInt(diceSides) + 1;
        if (rollResult == 1){
            System.out.println("You rolled a critical failure! Ouch.");
        }else if(rollResult == diceSides){
            System.out.println("Congratulations!!! You rolled a critical!");
        }
        System.out.println("You rolled a: " + rollResult);
        
    }
}
