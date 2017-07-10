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
public class YourLifeInMovies {
    public static void main(String[] args) {
         int year;
    Scanner age = new Scanner(System.in);
    
    System.out.println("Hello, lets play a game of movie trivia.");
    System.out.println("In what year were you born?");
    year = age.nextInt();
    
    if(year < 1965){
        System.out.println("MASH has been around for almost half a century!!");
    }
    if(year < 1975){
        System.out.println("The original Jurassic Park release is closer to the lunar landing than, today.");
    }
    if(year < 1985){
        System.out.println("Space Jam came out not last decade, but the one BEFORE that!");
    }
    if(year < 1995){
        System.out.println("The first Harry Potter came out over 15 years ago!");
    }
    if(year < 2005){
        System.out.println("Pixars 'Up' came out half a decade ago!");
    }
    
    
    
    }
    
   
}
