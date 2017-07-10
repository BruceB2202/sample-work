/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Snack;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author bruce_breslin
 */
public interface VendingMachineService {
    // all dao methods
    
    public Snack addSnack(Snack snack);
    public void removeSnack(int productId);
    public void updateSnack(Snack snack);
    public Snack getSnackById(int productId);
    public List<Snack> getAllSnacks();
    
    public Change vendSnack(int productId, BigDecimal balance)throws VendingMachineNoInventoryException, VendingMachineInsufficientFundsException;

    public void loadInventoryList();
    public Change getChange(BigDecimal balance);
}
