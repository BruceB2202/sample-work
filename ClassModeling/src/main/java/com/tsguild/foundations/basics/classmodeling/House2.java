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
public class House2 {
    private double squareFootage;
    private int numberOfRooms;
    private Room[] roomList;

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Room[] getRoomList() {
        return roomList;
    }

    public void setRoomList(Room[] roomList) {
        this.roomList = roomList;
    }
    
}
