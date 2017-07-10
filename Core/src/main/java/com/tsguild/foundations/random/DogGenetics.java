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
public class DogGenetics {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random percents = new Random();
        
        int percentOne, percentTwo, percentThree, percentFour, percentFive;
        
        System.out.println("What is the name of your dog?");
        String dogName = userInput.nextLine();
        
        System.out.println("It is on good authority that " + dogName + "'s pedigree is as follows: ");
        
        percentOne = percents.nextInt(60) + 1; //I intentionally made this one less than 100 so that
        //it will leave room for the other four variables
        
        percentTwo = percents.nextInt(95 - percentOne) + 1;
        percentThree = percents.nextInt(95 - percentOne - percentTwo) + 1;
        percentFour = percents.nextInt(95 - percentOne - percentTwo - percentThree) + 1;
        percentFive = 100 - percentOne - percentTwo - percentThree - percentFour;
        //also intentionally didn't allow the first 4 percents to reach 100 to ensure there would be no
        //0 percentages.
        
        System.out.println(percentOne + "% Poodle");
        System.out.println(percentTwo + "% German Shepherd");
        System.out.println(percentThree + "% Labrador");
        System.out.println(percentFour + "% Golden Retriever");
        System.out.println(percentFive + "% Sharpei");
        
        System.out.println("Man that's quite the mix. Beautiful dog!!");
    }
}
