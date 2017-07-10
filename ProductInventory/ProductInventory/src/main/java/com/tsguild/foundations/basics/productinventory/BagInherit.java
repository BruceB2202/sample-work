/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.productinventory;

/**
 *
 * @author Bruce_Breslin
 */
public class BagInherit extends ProductInherit {
    private boolean isRoller;
    private boolean hasShoulderStrap;
    private int capacity;

    public boolean isIsRoller() {
        return isRoller;
    }

    public void setIsRoller(boolean isRoller) {
        this.isRoller = isRoller;
    }

    public boolean isHasShoulderStrap() {
        return hasShoulderStrap;
    }

    public void setHasShoulderStrap(boolean hasShoulderStrap) {
        this.hasShoulderStrap = hasShoulderStrap;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
