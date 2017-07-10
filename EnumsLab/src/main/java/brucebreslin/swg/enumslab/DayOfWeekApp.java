/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.enumslab;

import static brucebreslin.swg.enumslab.DayOfWeek.FRIDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.MONDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.SATURDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.SUNDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.THURSDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.TUESDAY;
import static brucebreslin.swg.enumslab.DayOfWeek.WEDNESDAY;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class DayOfWeekApp {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("What day is it today?: ");
        String userDayInput = userInput.nextLine();
        userDayInput = userDayInput.toUpperCase();
        DayOfWeek dayToday = DayOfWeek.valueOf(userDayInput);

        switch (dayToday) {
            case MONDAY:
                System.out.println("4 days until Friday.");
                break;
            case TUESDAY:
                System.out.println("3 days until Friday.");
                break;
            case WEDNESDAY:
                System.out.println("2 days until Friday.");
                break;
            case THURSDAY:
                System.out.println("Tomorrow is Friday.");
                break;
            case FRIDAY:
                System.out.println("IT'S FRIDAY!!");
                break;
            case SATURDAY:
                System.out.println("6 days until Friday.");
                break;
            case SUNDAY:
                System.out.println("5 days until Friday.");
                break;
            default:
                System.out.println("That is not a valid input please try again.");
        }

    }

}
