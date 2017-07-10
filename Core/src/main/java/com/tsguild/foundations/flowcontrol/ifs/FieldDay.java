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
public class FieldDay {
    public static void main(String[] args) {
        String playerName, baggins, dresden, howl, potter, vimes;
        
        baggins = "Baggins";
        dresden = "Dresden";
        howl = "Howl";
        potter = "Potter";
        vimes = "Vimes";
        
        Scanner teamPicker = new Scanner(System.in);
        
        System.out.println("What is your last name?");
        playerName = teamPicker.nextLine();
        
        if (playerName.compareTo(baggins) < 0){
            System.out.println("You are on the Red Dragons.");
        }else if (playerName.compareTo(baggins) > 0 && playerName.compareTo(dresden) < 0){
            System.out.println("You are on the Dark Wizards.");
        }else if (playerName.compareTo(dresden) > 0 && playerName.compareTo(howl) < 0){
            System.out.println("You are on the Moving Castles.");
        }else if (playerName.compareTo(howl) > 0 && playerName.compareTo(potter) < 0){
            System.out.println("You are on the Golden Snitches.");
        }else if (playerName.compareTo(potter) > 0 && playerName.compareTo(vimes) < 0){
            System.out.println("You are on the Night Guards");
        }else if (playerName.compareTo(vimes) > 0){
            System.out.println("You are on the Black Holes");
        }else {
            System.out.println("Error please try again!");
        }

    }
}
