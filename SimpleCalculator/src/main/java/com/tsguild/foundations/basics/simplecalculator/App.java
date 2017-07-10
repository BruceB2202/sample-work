/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class App {

    static UserIO IO = new UserIO();

    public static void main(String[] args) {
        int userMathType;
        int userNumberA = 0;
        int userNumberB = 0;
        boolean closeApp = false;

        SimpleCalculator myCalc = new SimpleCalculator();
        while (!closeApp) {
            userMathType = IO.readInt("What would you like to do?\n 1- Add   2- Subtract   "
                    + "3-Multiply   4- Divide   5- Exit");
            if (userMathType >= 1 && userMathType <= 4) {
                userNumberA = IO.readInt("Which number would you like to perform the operation on?");
                userNumberB = IO.readInt("Which number would you like to perform the operation with?");
            } else if (userMathType == 5) {
                IO.print("Thank you for using my calculator!");
            } else {
                IO.print("Please input a valid number.");
            }

            switch (userMathType) {
                case 1:
                    IO.print(Integer.toString(myCalc.addNumbers(userNumberA, userNumberB)));
                    break;
                case 2:
                    IO.print(Integer.toString(myCalc.subtractNumbers(userNumberA, userNumberB)));
                    break;
                case 3:
                    IO.print(Integer.toString(myCalc.multiplyNumbers(userNumberA, userNumberB)));
                    break;
                case 4:
                    IO.print(Integer.toString(myCalc.divideNumbers(userNumberA, userNumberB)));
                    break;
                case 5:
                    closeApp = true;
                    break;
                default:
                    IO.print("Please input only whole numbers and try again.");
            }
        }

    }
}