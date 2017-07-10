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
public class MiniMadLibs {
    public static void main(String[] args) {
        String verb, adjectiveOne, adjectiveTwo, nounOne, adjectiveThree, verbed, nounTwo, verbing;
        
        Scanner mad = new Scanner(System.in);
        
        System.out.println("Let's make some fortune cookies!!");
        System.out.println("Please input the requested type of word.");
        System.out.println("verb");
        verb = mad.nextLine();
        System.out.println("adjective");
        adjectiveOne = mad.nextLine();
        System.out.println("adjective");
        adjectiveTwo = mad.nextLine();
        System.out.println("noun");
        nounOne = mad.nextLine();
        System.out.println("adjective");
        adjectiveThree = mad.nextLine();
        System.out.println("verb ending in 'ed'");
        verbed = mad.nextLine();
        System.out.println("noun");
        nounTwo = mad.nextLine();
        System.out.println("verb ending in 'ing'");
        verbing = mad.nextLine();
        
        
        System.out.println("- While anyone can " + verb + " to themselves they were " + adjectiveOne + ", the true test is adminssion to someone else.");
        System.out.println("- Faults are " + adjectiveTwo + " where " + nounOne + " is thin.");
        System.out.println("- The only real way to look " + adjectiveThree + " is not to be " + verbed + " so soon.");
        System.out.println("- Always try to do things in chronological " + nounTwo + "; it's less " + verbing + " that way." );
        
    }
}
