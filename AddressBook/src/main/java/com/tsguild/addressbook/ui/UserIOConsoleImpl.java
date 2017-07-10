/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.ui;

import com.tsguild.addressbook.ui.UserIO;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class UserIOConsoleImpl implements UserIO {
    
    static Scanner userInput = new Scanner(System.in);
    
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double userDouble = userInput.nextDouble();
        return userDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double userDouble;
        do{System.out.println(prompt);
        userDouble = userInput.nextDouble();
                }while(userDouble < min || userDouble > max);
        return userDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float userFloat = userInput.nextFloat();
        return userFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userFloat;
        do{System.out.println(prompt);
        userFloat = userInput.nextFloat();
                }while(userFloat < min || userFloat > max);
        return userFloat;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String userNumber = userInput.nextLine();
        int userInt = Integer.parseInt(userNumber);
        return userInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userInt;
        do{System.out.println(prompt);
        String userNumber = userInput.nextLine();
         userInt = Integer.parseInt(userNumber);
                }while(userInt < min || userInt > max);
        return userInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long userLong = userInput.nextLong();
        return userLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userLong;
        do{System.out.println(prompt);
        userLong = userInput.nextLong();
                }while (userLong < min || userLong > max);
        return userLong;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userString = userInput.nextLine();
        return userString;
    }
    
}
