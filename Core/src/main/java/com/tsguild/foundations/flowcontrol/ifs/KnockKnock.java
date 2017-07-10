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
public class KnockKnock {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Knock Knock! Guess who!!");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println("... from the Future."); // I would have too!!
        }else {
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
// Changing the .equals to a == tries to compare the value of nameGuess to a number not a string.
// The program will always thing the values do not match and will never print the if code..
// only the else portion.

// Changing the capitalization causes the program to not evaluate the strings to be
// equal to one another. To fix that you can use .equalsIgnoreCase instead of .equals