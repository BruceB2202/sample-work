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
public class BiggerBetterAdder {
    public static void main(String[] args) {
        int numOne, numTwo, numThree;
        int sum;
        
        
        Scanner numGetter = new Scanner(System.in);
        
        System.out.println("Number 1: ");
        numOne = numGetter.nextInt();
        System.out.println("Number 2: ");
        numTwo = numGetter.nextInt();
        System.out.println("Number 3: ");
        numThree = numGetter.nextInt();
        
        
        System.out.println(numOne);
        System.out.println(numTwo);
        System.out.println(numThree);
        
        
        sum = numOne + numTwo + numThree;
        
        System.out.println(sum);
        System.out.println(sum);
    }
}
