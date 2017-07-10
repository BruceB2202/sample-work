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
public class MiniZork {
    public static void main(String[] args) {
        String action;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house or open the mailbox?");
        action = userInput.nextLine();
        
        if (action.equals("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in?");
            action = userInput.nextLine();
            
            if (action.equals("look inside")){
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking?");
                action = userInput.nextLine();
                
                if (action.equals("keep looking")){
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                }else if (action.equals("run away")){
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            }else if (action.equals("stick your hand in")){
                System.out.println("You stick your hand in and feel cobwebs.");
                System.out.println("Do these guys ever get mail?!? It's so dark.");
                System.out.print("Keep reaching for the back or leave?");
                action = userInput.nextLine();
                
                if (action.equals("keep reaching")){
                    System.out.println("You get sucked in to another dimension in which people think you are a god.");
                    System.out.println("You live here happily for the rest of your life.");
                }else if (action.equals("leave")){
                    System.out.println("You walk away from the mailbox and the house never knowing what may have happened.");
                    System.out.println("Maybe you should take risks instead of playing it safe forever!");
                }
            }
        }else if (action.equals("go to the house")){
            System.out.println("You walk up to the house.. slowly");
            System.out.println("The house seems empty... hmm");
            System.out.print("Do you knock on the door or just go in?");
            action = userInput.nextLine();
            
            if (action.equals("knock on the door")){
                System.out.println("You knock and there is a long wait...");
                System.out.println("Still nothing happening.. what should you do?");
                System.out.print("Go in or wait some more?");
                action = userInput.nextLine();
                
                if (action.equals("go in")){
                    System.out.println("You walk in and the house is filled with noise coming from the ballroom.");
                    System.out.println("Surprise!!!!!! What took you so long everyone has been waiting on you to walk in for your surprise party!!");
                }else if (action.equals("wait some more")){
                    System.out.println("You keep waiting and still no one answers.");
                    System.out.println("Hmm.. maybe no one is home.. you leave and decide to try again later.");
                }
                
            }else if (action.equals("go in")){
                System.out.println("You walk in and turn on the lights.");
                System.out.println("In front of you there is a grand staircase and a hallway off to the right.");
                System.out.print("Do you go up the stairs or down the hall?");
                action = userInput.nextLine();
                
                if (action.equals("go up the stairs")){
                    System.out.println("You begin up the stairs and notice a light on up there.");
                    System.out.println("As you get closer you realize your grandmother must have been napping and didn't hear you arrive, you wake her up and have a lovely evening together.");
                }else if (action.equals("go down the hall")){
                    System.out.println("You begin down the hall and smell a wonderful aroma coming from the kitchen.");
                    System.out.println("As you enter grandma is at the stove dancing and singing to the radio that drowned out your knocking. She invites you to sit down and have a few cookies before you help her with her computer.");
                }
            }
        }
        
        
        
        
    }
}
