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
public class Car1 {
    private int yearMade;
    private String carMake;
    private String carModel;
    private double carPrice;
    private String carColor;
    private String carExtras[];
    private int carMileage;
    private int inventoryId;
    private String locationOnLot;

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String[] getCarExtras() {
        return carExtras;
    }

    public void setCarExtras(String[] carExtras) {
        this.carExtras = carExtras;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getLocationOnLot() {
        return locationOnLot;
    }

    public void setLocationOnLot(String locationOnLot) {
        this.locationOnLot = locationOnLot;
    }
    
}
