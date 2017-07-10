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
public class Triangle extends Shape {

    private int baseSideLength;
    private int leftSideLength;
    private int rightSideLength;
    private int height;
    
    @Override
    public int calculateArea() {
        int area = (baseSideLength * height) / 2;
        return area;
    }

    @Override
    public int calculatePerimeter() {
        int perimeter = baseSideLength + leftSideLength + rightSideLength;
        return perimeter;
    }

    public int getBaseSideLength() {
        return baseSideLength;
    }

    public void setBaseSideLength(int baseSideLength) {
        this.baseSideLength = baseSideLength;
    }

    public int getLeftSideLength() {
        return leftSideLength;
    }

    public void setLeftSideLength(int leftSideLength) {
        this.leftSideLength = leftSideLength;
    }

    public int getRightSideLength() {
        return rightSideLength;
    }

    public void setRightSideLength(int rightSideLength) {
        this.rightSideLength = rightSideLength;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
