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
public class ShoesInherit extends ProductInherit {
    private String slideFoot;
    private String genderFor;
    private double size;

    public String getSlideFoot() {
        return slideFoot;
    }

    public void setSlideFoot(String slideFoot) {
        this.slideFoot = slideFoot;
    }

    public String getGenderFor() {
        return genderFor;
    }

    public void setGenderFor(String genderFor) {
        this.genderFor = genderFor;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
