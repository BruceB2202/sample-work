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
public class HealthyHearts {
    public static void main(String[] args) {
        int age; 
        double maxRate, lowTarget, highTarget;
        
        Scanner ageFinder = new Scanner(System.in);
        
        System.out.println("How old are you?");
        age = ageFinder.nextInt();
        
        maxRate = 220 - age;
        lowTarget = maxRate * .5;
        highTarget = maxRate * .85;
        
        System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute.");
        System.out.println("Your target heart rate zone is between " + lowTarget + " and " + highTarget + " beats per minute.");
        
        
    }
}
