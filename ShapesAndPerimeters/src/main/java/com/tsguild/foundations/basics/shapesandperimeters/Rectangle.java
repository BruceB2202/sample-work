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
public class Rectangle extends Shape{

    private int length;
    private int width;
    
    @Override
    public int calculateArea() {
        int area = length * width;
        return area;
    }

    @Override
    public int calculatePerimeter() {
        int perimeter = 2 * (length + width);
        return perimeter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
}
