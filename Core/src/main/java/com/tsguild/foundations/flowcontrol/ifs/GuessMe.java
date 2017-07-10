/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class GuessMe {
    public static void main(String[] args) {
        int myNumber, guess;
        myNumber = 2202;
        
        Scanner pickANumber = new Scanner(System.in);
        
        System.out.println("I picked a number between 1 and 5000, try to guess it.");
        guess =  pickANumber.nextInt();
        
        if(guess == myNumber) {
            System.out.println("Wow, nice guess! That was it!");
        }else if(guess < myNumber) {
            System.out.println("Ha, nice try - too low! I choose 2202!");
        }else {
            System.out.println("Too bad - too high! I choose 2202!");
        }
    }
}
