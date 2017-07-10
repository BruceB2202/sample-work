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
public class AllTheTrivia {
    public static void main(String[] args) {
        
        
        String continent, makers, champs;
        
        Scanner trivia = new Scanner(System.in);
        
        System.out.println("What continent is the USA on?");
        continent = trivia.nextLine();
        System.out.println("Which software company originally developed Java?");
        makers = trivia.nextLine();
        System.out.println("Who won the 2016 NBA championship?");
        champs = trivia.nextLine();
        
        
        System.out.println("I knew the USA was on " + makers + "!");
        System.out.println("Oh yea, Java was made by " + champs + ", of course.");
        System.out.println("So, " + continent + " won the 2016 NBA Championship.");
        
    }
}
