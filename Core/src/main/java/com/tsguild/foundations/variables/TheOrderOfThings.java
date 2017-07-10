/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables;

/**
 *
 * @author Bruce_Breslin
 */
public class TheOrderOfThings {
    public static void main(String[] args) {
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "Awesome ";
        size = "teensy-weensy ";
        age = "new ";
        shape = "oblong ";
        color = "Bright yellow ";
        origin = "AlphaCentaurian ";
        material = "platinum ";
        purpose = "good ";
        
        noun = "dragons ";
        
        // Using the + with strings ,doesn't add it concatenates! (sticks them together)
        System.out.println(number + opinion + size + age + shape + color + origin + material + purpose + noun);
        System.out.println(noun + material + size + age + color + origin + opinion + number + shape + purpose);
        System.out.println(opinion + shape + purpose + noun + size + material + age + color + number + origin);
        System.out.println(number + age + noun + size + purpose + opinion + color + material + origin + shape);
        System.out.println(number + opinion + size + age + shape + color + origin + purpose + material + noun); //I think they all sound weird but this is the closest to normal..
    }
}
