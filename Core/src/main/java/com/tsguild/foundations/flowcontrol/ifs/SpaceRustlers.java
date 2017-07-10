/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

/**
 *
 * @author Bruce_Breslin
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        }else{
            System.out.println(" There aren't enough green guys to drive these ships!");
        }
        
        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        }else if(cows > spaceships){
            System.out.println("Dangit! I don't know how we're going to fit all these cows in here!");
        }else {
            System.out.println("Too many ships! Not enough cows.");
        }
        
        if(aliens > cows){
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
            }else {
            System.out.println("Oh no! The herds got restless and took over! Looks like_we're_hamburger now!!");
        }
    }
}

/*
    If statements take a condition and if it is true run a code block.

    Else if statements will run their code block only if their condition is true and the condition listed in the first if statement is false.

If you remove the else from else if the code block in the second if statement will then run regardless of whether or not the first condition is true.
*/