/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.factorizor;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class Factorizor {

    public void factorThis() {
        int userNumber, isPerfect, factorChecker, numberOfFactors;

        factorChecker = 1;
        numberOfFactors = 0;
        isPerfect = 0;

        Scanner numberGetter = new Scanner(System.in);

        System.out.print("What number would you like to factor?:  ");
        userNumber = numberGetter.nextInt();

        System.out.println("The factor(s) of " + userNumber + " is/are:");

        for (factorChecker = 1; factorChecker < userNumber; factorChecker++) {
            if (userNumber % factorChecker == 0) {
                System.out.println(factorChecker);
                isPerfect += factorChecker;
                numberOfFactors++;
            }
        }

        System.out.println(userNumber + " has " + numberOfFactors + " factor(s) total.");
        if (isPerfect == userNumber) {
            System.out.println(userNumber + " is a perfect number.");
        } else {
            System.out.println(userNumber + " is not a perfect number.");
        }
        if (numberOfFactors == 1) {
            System.out.println(userNumber + " is a prime number.");
        } else {
            System.out.println(userNumber + " is not a prime number.");
        }
    }
}
