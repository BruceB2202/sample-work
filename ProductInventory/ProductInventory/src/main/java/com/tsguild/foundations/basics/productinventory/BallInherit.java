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
public class BallInherit extends ProductInherit {
    private int weight;
    private String coverstock;
    private String coreType;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCoverstock() {
        return coverstock;
    }

    public void setCoverstock(String coverstock) {
        this.coverstock = coverstock;
    }

    public String getCoreType() {
        return coreType;
    }

    public void setCoreType(String coreType) {
        this.coreType = coreType;
    }
}
