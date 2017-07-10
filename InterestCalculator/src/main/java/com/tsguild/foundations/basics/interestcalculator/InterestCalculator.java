/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class InterestCalculator {

    static Scanner userInput = new Scanner(System.in);

    public void Calculate() {

        BigDecimal initialPrincipal = getUserInvestment();
        String beginningOfYear = initialPrincipal.toString();
        BigDecimal annualInterestRate = getInterestRate();
        String timesCompoundYearly = getHowManyTimes();
        BigDecimal interestPerCompounding = annualInterestRate.divide(new BigDecimal(timesCompoundYearly));
        BigDecimal divisor = new BigDecimal("1").add(interestPerCompounding.divide(new BigDecimal("100")));
        int yearsInFund = getYearsInFund();

        for (int theYear = 0; theYear < yearsInFund; theYear++) {
            System.out.println("Year: " + (theYear + 1) + ". Beginning balance: $" + new BigDecimal(beginningOfYear).setScale(2, RoundingMode.HALF_UP) + ".");
            String currentBalance = beginningOfYear;
            for (int timesCompound = 0; timesCompound < Integer.parseInt(timesCompoundYearly); timesCompound++) {
                BigDecimal balanceAfterCompounding = new BigDecimal(currentBalance).multiply(divisor);
                currentBalance = balanceAfterCompounding.toString();
            }
            BigDecimal endOfYear = new BigDecimal(currentBalance);
            BigDecimal interestEarned = endOfYear.subtract(new BigDecimal(beginningOfYear));
            System.out.println("End of year balance: $" + endOfYear.setScale(2, RoundingMode.HALF_UP) + ". Total interest gained this year: $" + interestEarned.setScale(2, RoundingMode.HALF_UP) + ".");
            System.out.println("");
            beginningOfYear = currentBalance;
        }

    }

    private static BigDecimal getUserInvestment() {
        String userInvestment;
        System.out.println("How much money do you want to invest?");
        userInvestment = userInput.nextLine();
        BigDecimal rv = new BigDecimal(userInvestment);
        return rv;
    }

    private static BigDecimal getInterestRate() {
        String interestRate;
        System.out.println("What is your annual interest rate?");
        interestRate = userInput.nextLine();
        BigDecimal rv = new BigDecimal(interestRate);
        return rv;
    }

    private static int getYearsInFund() {
        int rv;
        System.out.println("How many years are you going to leave the money in the account?");
        rv = userInput.nextInt();
        return rv;
    }

    private static String getHowManyTimes() {
        String rv;
        System.out.println("How many times is your interest compounded annually? (Monthly = 12, Quarterly = 4, Daily = 365_)");
        rv = userInput.nextLine();
        return rv;
    }
}
