/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class LuckySevenGame {
    public void GameTime() {
        int money, rollsMaxMoney, rollsTotal, maxMoney, rollOne, rollTwo, score;
        Random dice = new Random();
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("How much money would you like to bet?");
        money = userInput.nextInt();
        maxMoney = money;
        
        
        rollsMaxMoney = 0;
        rollsTotal = 0;
      

       while (money > 0){
           rollsTotal++;
           rollOne = dice.nextInt(6)+1;
           rollTwo = dice.nextInt(6)+1;
           score = rollOne + rollTwo;
           if (score == 7){
               money += 4;
               if (money > maxMoney) {
                   maxMoney = money;
                   rollsMaxMoney = rollsTotal;
               }
           }else {
               money -= 1;
           }  
           
        }
      System.out.println("You are broke after " + rollsTotal + " rolls.");
      System.out.println("You should have quit after " + rollsMaxMoney + " rolls when you had $" + maxMoney + ".");
    }
}
