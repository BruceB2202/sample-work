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
public class TriviaNight {
    public static void main(String[] args) {
        int answerOne, answerTwo, answerThree, userOne, userTwo, userThree, tally;
        
        
        answerOne = 2;
        answerTwo = 1;
        answerThree = 2;
        tally = 0;
        
        Scanner trivia = new Scanner(System.in);
        
        System.out.println("Which band performed the song 'Cold as Ice'");
        System.out.println("1- Survivor    2- Foreigner");
        System.out.println("3- Fleetwood Mac    4- Pink Floyd");
        userOne = trivia.nextInt();
        if(answerOne == userOne){
            tally++;}
        System.out.println("Who voices the character Meg Griffin on the TV show Family Guy");
        System.out.println("1- Mila Kunis    2- Miley Cyrus");
        System.out.println("3- Jennifer Lawrence    4- Michelle Obama");
        userTwo = trivia.nextInt();
        if(answerTwo == userTwo){
            tally++;}
        System.out.println("Who is the guitarist for Pink Floyd");
        System.out.println("1- Roger Waters    2- David Gilmour");
        System.out.println("3- Nick Mason   4- Richard Wright");
        userThree = trivia.nextInt();
        if(answerThree == userThree){
            tally++;
        }
        if(tally == 3){
            System.out.println("Good job you got them ALL right!");
        }
        if(tally == 0){
            System.out.println("Wow.... maybe you should get out more..");
        }
        System.out.println("Congratulations you got " + tally + " out of 3 correct answers.");
    }
}
