/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.rockpaperscissorsstep1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class RockPaperScissors {
    static Scanner userInput = new Scanner(System.in);
    static Random RPS = new Random();
    /*
    Rock=1 Paper=2 Scissors=3.
    Get user string and use .equals to assign a number and evaluate vs. randomly picked number
    */
    public static void main(String[] args) {
        int cpuPick = getCpuPick();
        String userPick = getUserPick();
        int userPickInt = changeUserPickToInt(userPick);
        String whoWon = checkWhoWins(userPickInt, cpuPick);
        
        System.out.println(whoWon);
    }

    private static int getCpuPick() {
        int rv;
        rv = RPS.nextInt(3) + 1;
        return rv;
    }

    private static String getUserPick() {
        System.out.print("Do you pick rock, paper, or scissors?");
        String userPick = userInput.nextLine();
        
        return userPick;
    }

    private static int changeUserPickToInt(String userPick) {
        int rv = 0;
        if (userPick.equalsIgnoreCase("rock")){
            rv = 1;
        }else if (userPick.equalsIgnoreCase("paper")){
            rv = 2;
        }else if (userPick.equalsIgnoreCase("scissors")){
            rv = 3;
        }
        return rv;
    }

    private static String checkWhoWins(int userPickInt, int cpuPick) {
        String rv = "";
        switch (userPickInt) {
            case 1:
        switch (cpuPick) {
            case 1:
                rv = "You both pick rock.. Tie game!";
                break;
            case 2:
                rv = "Paper covers rock. You lose!";
                break;
            case 3:
                rv = "Rock crushes scissors. You win!";
                break;
            default:
                break;
        }
break;
            case 2:
        switch (cpuPick) {
            case 1:
                rv = "Paper covers rock. You win!";
                break;
            case 2:
                rv = "You both picked paper.. Tie game!";
                break;
            default:
                rv = "Scissors cut paper. You lose!";
                break;
        }
break;
            case 3:
        switch (cpuPick) {
            case 1:
                rv = "Rock crushes scissors. You lose!";
                break;
            case 2:
                rv = "Scissors cut paper. You win!";
                break;
            case 3:
                rv = "You both picked scissors.. You tie!";
                break;
            default:
                break;
        }
break;
            default:
                break;
        }
        return rv;
    }
}
