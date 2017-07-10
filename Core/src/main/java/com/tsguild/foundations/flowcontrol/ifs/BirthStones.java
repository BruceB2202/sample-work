/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class BirthStones {
    public static void main(String[] args) {
        int month;
        Scanner number = new Scanner(System.in);
        
        System.out.println("What is the number of the month you wish to know the birthstone for?");
        month = number.nextInt();
        
        if(month == 1){
            System.out.println("January-Garnet");
        }else if(month == 2){
            System.out.println("February-Amethyst");
        }else if(month == 3){
            System.out.println("March-Aquamarine");
        }else if(month == 4){
            System.out.println("April-Diamond");
        }else if(month == 5){
            System.out.println("May-Emerald");
        }else if(month == 6){
            System.out.println("June-Pearl");
        }else if(month == 7){
            System.out.println("July-Ruby");
        }else if(month == 8){
            System.out.println("August-Peridot");
        }else if(month == 9){
            System.out.println("September-Sapphire");
        }else if(month == 10){
            System.out.println("October-Opal");
        }else if(month == 11){
            System.out.println("November-Topaz");
        }else if(month == 12){
            System.out.println("December-Turquoise");
        }else{
            System.out.println("You must be mistaken there are only 12 months in a year...");
        }
    }
}
