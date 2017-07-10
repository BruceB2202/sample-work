/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.classmodeling;

/**
 *
 * @author Bruce_Breslin
 */
public class Room {
    private String purposeOfRoom;
    private double length;
    private double width;
    private double depth;
    private double squareFootageOfRoom;

    public String getPurposeOfRoom() {
        return purposeOfRoom;
    }

    public void setPurposeOfRoom(String purposeOfRoom) {
        this.purposeOfRoom = purposeOfRoom;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getSquareFootageOfRoom() {
        return squareFootageOfRoom;
    }

    public void setSquareFootageOfRoom(double squareFootageOfRoom) {
        this.squareFootageOfRoom = squareFootageOfRoom;
    }
    
}
