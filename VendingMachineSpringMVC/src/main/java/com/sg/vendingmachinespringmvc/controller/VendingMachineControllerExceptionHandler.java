/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Snack;
import com.sg.vendingmachinespringmvc.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.VendingMachineNoInventoryException;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author bruce_breslin
 */
@ControllerAdvice
public class VendingMachineControllerExceptionHandler {
    VendingMachineDao dao;
    
    @Inject
    public VendingMachineControllerExceptionHandler(VendingMachineDao dao){
        this.dao = dao;
    }
    
    
    @ExceptionHandler(VendingMachineInsufficientFundsException.class)
    public String processVendingMachineInsufficientFundsException(VendingMachineInsufficientFundsException e, Model model){
        
        String errorMessage = e.getMessage();
        int productId = e.getProductId();
        BigDecimal balance = e.getBalance();
        List<Snack> inventory = dao.getAllSnacks();
        model.addAttribute("inventory", inventory);
        model.addAttribute("productId", productId);
        model.addAttribute("balance", balance);
        model.addAttribute("errorMessage", errorMessage);
        
        return "index";
    }
    
    @ExceptionHandler(VendingMachineNoInventoryException.class)
    public String processVendingMachineNoInventoryException(VendingMachineNoInventoryException e, Model model){
        
        String errorMessage = e.getMessage();
        int productId = e.getProductId();
        BigDecimal balance = e.getBalance();
        List<Snack> inventory = dao.getAllSnacks();
        model.addAttribute("inventory", inventory);
        model.addAttribute("productId", productId);
        model.addAttribute("balance", balance);
        model.addAttribute("errorMessage", errorMessage);
        
        return "index";
    }
}
