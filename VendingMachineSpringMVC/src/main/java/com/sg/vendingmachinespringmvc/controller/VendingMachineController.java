/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Snack;
import com.sg.vendingmachinespringmvc.service.Change;
import com.sg.vendingmachinespringmvc.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.VendingMachineNoInventoryException;
import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author brucebreslin22
 */
@Controller
public class VendingMachineController {

    VendingMachineService service;

    @Inject
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        service.loadInventoryList();
        List<Snack> inventory = service.getAllSnacks();
        int productIdHolder = 1;
        BigDecimal balance = new BigDecimal("0.00");
        model.addAttribute("productId", productIdHolder);
        model.addAttribute("balance", balance);
        model.addAttribute("inventory", inventory);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayIndexPage(Model model) {
        List<Snack> inventory = service.getAllSnacks();
        model.addAttribute("inventory", inventory);
        return "index";
    }

    @RequestMapping(value = "/vendProduct", method = RequestMethod.GET)
    public String displayTransactionResultPage(HttpServletRequest request, Model model) throws VendingMachineNoInventoryException, VendingMachineInsufficientFundsException {
        String balanceString = request.getParameter("balance");
        BigDecimal balance = new BigDecimal(balanceString);
        String productIdString = request.getParameter("productId");
        int productId = Integer.parseInt(productIdString);
        Change change = service.vendSnack(productId, balance);
        int quarters = change.getQuarters();
        int dimes = change.getDimes();
        int nickels = change.getNickels();
        int pennies = change.getPennies();
        balance = new BigDecimal("0.00");
        model.addAttribute("quarters", quarters);
        model.addAttribute("dimes", dimes);
        model.addAttribute("nickels", nickels);
        model.addAttribute("pennies", pennies);
        model.addAttribute("productId", productId);
        model.addAttribute("balance", balance);
        String message = "Thank You!";
        model.addAttribute("message", message);
        List<Snack> inventory = service.getAllSnacks();
        model.addAttribute("inventory", inventory);

        return "index";

    }
    
    @RequestMapping(value = "/getChange", method = RequestMethod.GET)
    public String changeReturnButtonPressed(HttpServletRequest request, Model model){
        String balanceString = request.getParameter("balance");
        BigDecimal balance = new BigDecimal(balanceString);
        int productId = 1;
        List<Snack> inventory = service.getAllSnacks();
        Change change = service.getChange(balance);
        int quarters = change.getQuarters();
        int dimes = change.getDimes();
        int nickels = change.getNickels();
        int pennies = change.getPennies();
        balance = new BigDecimal("0.00");
        model.addAttribute("inventory", inventory);
        model.addAttribute("quarters", quarters);
        model.addAttribute("dimes", dimes);
        model.addAttribute("nickels", nickels);
        model.addAttribute("pennies", pennies);
        model.addAttribute("productId", productId);
        model.addAttribute("balance", balance);
        
        return "index";
    }

}
