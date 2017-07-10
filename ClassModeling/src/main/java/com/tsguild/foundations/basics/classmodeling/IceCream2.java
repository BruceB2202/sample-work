/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.classmodeling;

/**
 *
 * @author bruceb
 */
public class IceCream2 {
    private String brandName;
    private String flavor;
    private double orderPrice;
    private double retailPrice;
    private int stockAmount;
    private int lowStockWarning;
    private int inventoryIdNumber;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getLowStockWarning() {
        return lowStockWarning;
    }

    public void setLowStockWarning(int lowStockWarning) {
        this.lowStockWarning = lowStockWarning;
    }

    public int getInventoryIdNumber() {
        return inventoryIdNumber;
    }

    public void setInventoryIdNumber(int inventoryIdNumber) {
        this.inventoryIdNumber = inventoryIdNumber;
    }
    
}
