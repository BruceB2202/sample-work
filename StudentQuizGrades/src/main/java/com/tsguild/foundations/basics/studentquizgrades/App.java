/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.studentquizgrades;

import static com.tsguild.foundations.basics.studentquizgrades.Admin.IO;

/**
 *
 * @author Bruce_Breslin
 */
public class App {

    static UserIO IO = new UserIO();

    public static void main(String[] args) {
        
        boolean isDone = false;

        while (!isDone) {
            IO.print("Please select the action you would like to perform.");
            int userInput = IO.readInt(" 1- View student grades \n 2- View all class grades \n 3- Add a student \n 4- Remove a student \n 5- Exit program");
            switch(userInput){
                case 1: 
                    Admin.showStudent();
                break;
                
                case 2: 
                    Admin.showClass();
                break;
                
                case 3: 
                    Admin.addStudent();
                break;
                
                case 4: 
                    Admin.removeStudent();
                break;
                
                case 5: 
                    isDone = true;
                break;
                
            }
        }
    }

}
