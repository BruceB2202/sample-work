/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.windowmaster;

import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class Window {
    public static void main(String[] args){
        float height;
        float width;
        float glassPrice;
        float trimPrice;
        
        String stringHeight;
        String stringWidth;
        String stringGlass;
        String stringTrim;
        
        float windowArea;
        float cost;
        float windowPerimeter;
        
        Scanner sc = new Scanner(System.in);
        //get input
        System.out.println("Please enter window height:");
        stringHeight = sc.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = sc.nextLine();
        System.out.println("Please enter glass price:");
        stringGlass = sc.nextLine();
        System.out.println("Please enter trim price:");
        stringTrim = sc.nextLine();
        
        //parse to Floats
       height = Float.parseFloat(stringHeight);
       width = Float.parseFloat(stringWidth);
       glassPrice = Float.parseFloat(stringGlass);
       trimPrice = Float.parseFloat(stringTrim);
        
        //calculate
        windowArea = height*width;
        windowPerimeter = 2*(height+width);
        cost = (glassPrice*windowArea)+(trimPrice*windowPerimeter);
        
        System.out.println("Window height= "+ stringHeight);
        System.out.println("Window width= "+ stringWidth);
        System.out.println("Window area= "+ windowArea);
        System.out.println("Window perimeter= "+ windowPerimeter);
        System.out.println("Glass price= "+ stringGlass + " per sq/ft");
        System.out.println("Trim price= "+ stringTrim + " per sq/ft");
        System.out.println("Total cost= "+ cost);
        
    }
}
