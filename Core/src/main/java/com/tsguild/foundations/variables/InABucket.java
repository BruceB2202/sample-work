/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables;

/**
 *
 * @author Bruce_Breslin
 */
public class InABucket {
    public static void main(String[] args) {

        // You can declare all KINDS of variables.a
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;
        
        // But declaring them just sets up the space for data
        //to use the variable, you have to put data IN it first!
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        weightOfTeacupPig = 10;
        grainsOfSand = 200;
        
        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.print("he was a bit hungry today, and ate this many pies : ");
        System.out.println(piesEaten);
        System.out.println("I also have a teacup pig, he only weighs: " + weightOfTeacupPig + " lbs");
        System.out.println("That is almost the same as " + grainsOfSand + " grains of sand.");
    }
}
