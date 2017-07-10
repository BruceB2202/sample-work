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
public abstract class Shape {
    private String color;
    
    public abstract int calculateArea();
    public abstract int calculatePerimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
