/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.shapesandperimeters;

/**
 *
 * @author Bruce_Breslin
 */
public class Square extends Shape {
    private int sideLength;
    @Override
    public int calculateArea() {
        int area= sideLength * sideLength;
        return area;
    }

    @Override
    public int calculatePerimeter() {
        int perimeter = sideLength * 4;
        return perimeter;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
    
}
