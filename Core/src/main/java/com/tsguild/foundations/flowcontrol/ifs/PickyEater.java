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
public class PickyEater {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("How many times has it been fried? (#)");
        int timesFried = userInput.nextInt();
        
        System.out.println("Does it have any spinach in it? (y/n)");
        String hasSpinach = userInput.nextLine();
        
        System.out.println("Is it covered in cheese? (y/n)");
        String cheeseCovered = userInput.nextLine();
        
        System.out.println("How many pats of butter are on top? (#)");
        int butterPats = userInput.nextInt();
        
        System.out.println("Is it covered in chocolate? (y/n)");
        String chocolateCovered = userInput.nextLine();
        
        System.out.println("Does it have a funny name? (y/n)");
        String funnyName = userInput.nextLine();
        
        System.out.println("Is it broccoli? (y/n)");
        String isBroccoli = userInput.nextLine();
        
        //evaluate information below here
        
        if (hasSpinach.equalsIgnoreCase("y") || funnyName.equalsIgnoreCase("y")){
            System.out.println("There's no way  that'll get eaten.");
        }
        if (timesFried < 4 && timesFried > 2 && chocolateCovered.equalsIgnoreCase("y")){
            System.out.println("Oh, it's like a deep fried snickers. That'll be a hit!");
        }
        if (timesFried == 2 && cheeseCovered.equalsIgnoreCase("y")){
            System.out.println("Mmm. Yeah, fried cheesy doodles will get ate.");
        }
        if (isBroccoli.equalsIgnoreCase("y") && butterPats > 6 && cheeseCovered.equalsIgnoreCase("y")){
            System.out.println("As long as the green is hidden by cheddar, it'll happen!");
        }
        if (isBroccoli.equalsIgnoreCase("y")){
            System.out.println("Oh, green stuff like that might as well go in the bin.");
        }
        
        
        
        
    }
}
