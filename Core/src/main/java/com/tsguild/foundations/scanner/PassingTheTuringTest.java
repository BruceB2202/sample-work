/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name, color, food;
        int number;
        
        Scanner julia = new Scanner(System.in);
        
        System.out.println("Hello. What is your name?");
        name = julia.nextLine();
        System.out.println("Nice to meet you, " + name + ". My name is Julia.");
        
        System.out.println("What is your favorite color?");
        color = julia.nextLine();
        System.out.println("Ahh, " + color + " I like that too.");
        
        System.out.println("What is your favorite food to eat?");
        food = julia.nextLine();
        System.out.println("Mmm " + food + " sounds good right now!!");
        
        System.out.println("What is your favorite number?");
        number = julia.nextInt();
        System.out.println("Hmm.. " + number + ", mine is 2.");
        System.out.println("It was nice to meet you, " + name + " , lets chat again soon! Goodbye.");
        
    }
}
