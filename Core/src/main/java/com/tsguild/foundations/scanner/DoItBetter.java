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
public class DoItBetter {
    public static void main(String[] args) {
        int miles, hotdogs, languages;
        
        Scanner brag = new Scanner(System.in);
        
        System.out.println("How many miles can you run?");
        miles = brag.nextInt();
        int myMiles = miles*2+1;
        System.out.println("Cool, I can run " + myMiles);
        
        System.out.println("How many hotdogs can you eat?");
        hotdogs = brag.nextInt();
        int myHotdogs = hotdogs*2+1;
        System.out.println("Cool, I can eat " + myHotdogs);
        
        System.out.println("How many languages do you speak?");
        languages = brag.nextInt();
        int myLanguages = languages*2+1;
        System.out.println("Cool, I can speak " + myLanguages);
        
        
    }
    
}
