/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import java.math.BigDecimal;

/**
 *
 * @author brucebreslin22
 */
public class VendingMachineInsufficientFundsException extends Exception{
    private int productId;
    private BigDecimal balance;
    
    public VendingMachineInsufficientFundsException(String message, int productId, BigDecimal balance){
        super(message);
        this.productId = productId;
        this.balance = balance;
    }
    public VendingMachineInsufficientFundsException(String message, Throwable cause, int productId, BigDecimal balance){
        super(message, cause);
        this.productId = productId;
        this.balance = balance;
    }

    public int getProductId() {
        return productId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    
}
