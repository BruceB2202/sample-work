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
public interface ProductInterface {

    public String getName();

    public void setName(String name);
            
    public String getBrand();
           
    public void setBrand(String brand);
    
    public String getColor();

    public void setColor(String color);

    public double getPrice();

    public void setPrice(double price);
    
}