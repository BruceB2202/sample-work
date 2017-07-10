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
public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int calculateArea() {
        int area = (int) (Math.PI * Math.pow(radius, 2));
        return area;
    }

    @Override
    public int calculatePerimeter() {
        int perimeter = (int) (2 * Math.PI * radius);
        return perimeter;
    }
}
