/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.rockpaperscissorsstep4;

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
    public void GameTime() {
        int min = 1, max = 10, userWins, cpuWins, tieGames;
        
        boolean donePlaying = false;
    
    while(donePlaying == false){
        int userRounds = askUserRounds(min, max);
        int timesPlayed = 0;
        userWins = 0;
        cpuWins = 0;
        tieGames = 0;
        if (userRounds > min && userRounds < max) {
            do {
                String userPick = getUserPick();
                int userPickInt = changeUserPickToInt(userPick);
                int cpuPick = getCpuPick();
                int whoWon = checkWhoWins(userPickInt, cpuPick);
                switch (whoWon) {
                    case 1:
                        userWins++;
                        break;
                    case 2:
                        cpuWins++;
                        break;
                    case 3:
                        tieGames++;
                        break;
                    default:
                        break;
                }
                timesPlayed++;
                if (timesPlayed == userRounds) {
                    System.out.println("You have won: " + userWins + " rounds. You lost " +                          cpuWins + " rounds. There were " + tieGames + " tie games.");
                    if (userWins > cpuWins) {
                        System.out.println("Congratulations you are the match winner!!!");
                    } else if (userWins < cpuWins) {
                        System.out.println("You lose!!! Better luck next time!");
                    } else {
                        System.out.println("You tied the match... how not fun!!");
                    }
                donePlaying = isDonePlaying();    
                }
            } while (timesPlayed < userRounds);
        } else {
            System.out.println("You must pick a number of rounds between " + min + " and " + max + "            !! Please start over and try again.");
        }
    }
    }

    private static int getCpuPick() {
        int rv;
        rv = RPS.nextInt(3) + 1;
        return rv;
    }

    private static String getUserPick() {
        System.out.println("Do you pick rock, paper, or scissors? ");
        String userPick = userInput.next();

        return userPick;
    }

    private static int changeUserPickToInt(String userPick) {
        int rv = 0;
        if (userPick.equalsIgnoreCase("rock")) {
            rv = 1;
        } else if (userPick.equalsIgnoreCase("paper")) {
            rv = 2;
        } else if (userPick.equalsIgnoreCase("scissors")) {
            rv = 3;
        }
        return rv;
    }

    private static int checkWhoWins(int userPickInt, int cpuPick) {
        int rv = 0;
         switch (userPickInt) {
            case 1:
                switch (cpuPick) {
                    case 1:
                        rv = 3;
                        System.out.println("You both pick rock.. Tie game!");
                        break;
                    case 2:
                        rv = 2;
                        System.out.println("Paper covers rock. You lose!");
                        break;
                    case 3:
                        rv = 1;
                        System.out.println("Rock crushes scissors. You win!");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (cpuPick) {
                    case 1:
                        rv = 1;
                        System.out.println("Paper covers rock. You win!");
                        break;
                    case 2:
                        rv = 3;
                        System.out.println("You both picked paper.. Tie game!");
                        break;
                    default:
                        rv = 2;
                        System.out.println("Scissors cut paper. You lose!");
                        break;
                }
                break;
            case 3:
                switch (cpuPick) {
                    case 1:
                        rv = 2;
                        System.out.println("Rock crushes scissors. You lose!");
                        break;
                    case 2:
                        rv = 1;
                        System.out.println("Scissors cut paper. You win!");
                        break;
                    case 3:
                        rv = 3;
                        System.out.println("You both picked scissors.. You tie!");
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

    private static int askUserRounds(int min, int max) {

        System.out.print("How many rounds would you like to play? Must be between " + min + " and " + max + ": ");
        int userRounds = userInput.nextInt();
        return userRounds;
    }

    private static boolean isDonePlaying() {
        boolean rv = false;
        System.out.println("Are you finished playing? (y/n) ");
        String userAnswer = userInput.next();
        if(userAnswer.equalsIgnoreCase("y")){
            rv = true;
        }else if(userAnswer.equalsIgnoreCase("n")){
            rv = false;
        }
        return rv;
    }

}
