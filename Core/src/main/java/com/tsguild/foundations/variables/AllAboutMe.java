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
public class AllAboutMe {
    public static void main(String[] args) {
        int pets, ageWhistle;
        String name, favFood;
        boolean gnocchi;
        
        pets = 1;
        ageWhistle = 26;
        name = "Bruce Breslin III";
        favFood = "steak";
        gnocchi = true;
        
        System.out.println("I am " + name+".");
        System.out.println("I have " + pets + " pet.");
        System.out.println("My favorite food is " + favFood + ".");
        System.out.println("It is " + gnocchi + " that I have eaten gnocchi.");
        System.out.println("And I was " + ageWhistle + " years old, I learned to whistle.");
    }
}
