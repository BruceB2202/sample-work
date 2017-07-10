/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Snack;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brucebreslin22
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao{
    
    Map<Integer, Snack> inventory = new HashMap<>();

    @Override
    public Snack addSnack(Snack snack) {
        inventory.put(snack.getProductId(), snack);
        return snack;
    }

    @Override
    public void removeSnack(int snackId) {
        inventory.remove(snackId);
    }

    @Override
    public void updateSnack(Snack snack) {
        inventory.put(snack.getProductId(), snack);
    }

    @Override
    public Snack getSnackById(int snackId) {
        Snack wantedSnack = inventory.get(snackId);
        return wantedSnack;
    }

    @Override
    public List<Snack> getAllSnacks() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public void loadInventoryList() {
        Snack snickers = new Snack(1);
        snickers.setProductName("Snickers");
        snickers.setProductCost(new BigDecimal("1.25"));
        snickers.setProductInStock(0);
        inventory.put(snickers.getProductId(), snickers);
        
        Snack twix = new Snack(2);
        twix.setProductName("Twix");
        twix.setProductCost(new BigDecimal("1.25"));
        twix.setProductInStock(10);
        inventory.put(twix.getProductId(), twix);
        
        Snack milkyWay = new Snack(3);
        milkyWay.setProductName("Milky Way");
        milkyWay.setProductCost(new BigDecimal("1.25"));
        milkyWay.setProductInStock(10);
        inventory.put(milkyWay.getProductId(), milkyWay);
        
        Snack hershey = new Snack(4);
        hershey.setProductName("hershey");
        hershey.setProductCost(new BigDecimal("1.25"));
        hershey.setProductInStock(10);
        inventory.put(hershey.getProductId(), hershey);
        
        Snack carmello = new Snack(5);
        carmello.setProductName("carmello");
        carmello.setProductCost(new BigDecimal("1.25"));
        carmello.setProductInStock(10);
        inventory.put(carmello.getProductId(), carmello);
        
        Snack mAndMs = new Snack(6);
        mAndMs.setProductName("M & Ms");
        mAndMs.setProductCost(new BigDecimal("1.25"));
        mAndMs.setProductInStock(10);
        inventory.put(mAndMs.getProductId(), mAndMs);
        
        Snack reeses = new Snack(7);
        reeses.setProductName("reeses");
        reeses.setProductCost(new BigDecimal("1.25"));
        reeses.setProductInStock(10);
        inventory.put(reeses.getProductId(), reeses);
        
        Snack pringles = new Snack(8);
        pringles.setProductName("pringles");
        pringles.setProductCost(new BigDecimal("1.25"));
        pringles.setProductInStock(10);
        inventory.put(pringles.getProductId(), pringles);
        
        Snack funions = new Snack(9);
        funions.setProductName("funions");
        funions.setProductCost(new BigDecimal("1.25"));
        funions.setProductInStock(10); 
        inventory.put(funions.getProductId(), funions);
    }
    
}
