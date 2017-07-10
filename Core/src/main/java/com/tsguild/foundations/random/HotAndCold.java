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
public class HotAndCold {
    public static void main(String[] args) {
        int winningNumber, guess, difference;
        Scanner userInput = new Scanner(System.in);
        Random gameTime = new Random();
        
        winningNumber = gameTime.nextInt(1000) + 1;
        
        System.out.println("I have picked a number between 1-1000, guess what it is!");
        System.out.print("You guess?: ");
        guess = userInput.nextInt();
        
        if (winningNumber > guess){
            difference = winningNumber - guess;
            if (difference > 500){
                System.out.println("So cold, you're practically in the north pole.");
            }else if (difference <= 500 && difference > 200){
                System.out.println("You're pretty chilly.");
            }else if (difference <= 200 && difference > 100){
                System.out.println("Tepid, but approaching room temperature.");
            }else if (difference <= 100 && difference > 50){
                System.out.println("Warm, but still a bit off.");
            }else if (difference <= 50 && difference > 20){
                System.out.println("Heating up....");
            }else if (difference <= 20 && difference >= 10){
                System.out.println("Hot hot hot, you are practically bubbling.");
            }else if (difference < 10){
                System.out.println("So hot, it's like living on the SUN!");
            }
            System.out.println("I actually choose " + winningNumber);
        }else if (winningNumber < guess){
            difference = guess - winningNumber;
            if (difference > 500){
                System.out.println("So cold, you're practically in the north pole.");
            }else if (difference <= 500 && difference > 200){
                System.out.println("You're pretty chilly.");
            }else if (difference <= 200 && difference > 100){
                System.out.println("Tepid, but approaching room temperature.");
            }else if (difference <= 100 && difference > 50){
                System.out.println("Warm, but still a bit off.");
            }else if (difference <= 50 && difference > 20){
                System.out.println("Heating up....");
            }else if (difference <= 20 && difference >= 10){
                System.out.println("Hot hot hot, you are practically bubbling.");
            }else if (difference < 10){
                System.out.println("So hot, it's like living on the SUN!");
            }
            System.out.println("I actually choose " + winningNumber);
        }else {
            System.out.println("Congratulations, that was my number!!!");
        }
    }
}
