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
public class GuessMeMore {
    public static void main(String[] args) {
         int myNumber, guess;
        Random numberPicker = new Random();
        Scanner pickANumber = new Scanner(System.in);
        
        myNumber = numberPicker.nextInt(200) - 100;
        System.out.println("I picked a number between -100 and 100, try to guess it.");
        guess =  pickANumber.nextInt();
        
        while (guess != myNumber) {
            if (guess < myNumber) {
                System.out.println("Too low.. Try again: ");
                guess = pickANumber.nextInt();
                
            }else if(guess > myNumber){
                System.out.println("Too high.. Try again: ");
                guess = pickANumber.nextInt();
            }
        }
        
        System.out.println("Congratulations, " + myNumber + " is my number!!");
        
        
    }
}
