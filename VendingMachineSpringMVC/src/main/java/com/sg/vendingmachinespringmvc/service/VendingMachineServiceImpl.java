/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Snack;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    Change change = new Change();

    @Inject
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Snack addSnack(Snack snack) {
        return dao.addSnack(snack);
    }

    @Override
    public void removeSnack(int productId) {
        dao.removeSnack(productId);
    }

    @Override
    public void updateSnack(Snack snack) {
        dao.updateSnack(snack);
    }

    @Override
    public Snack getSnackById(int productId) {
        return dao.getSnackById(productId);
    }

    @Override
    public List<Snack> getAllSnacks() {
        return dao.getAllSnacks();
    }

    @Override
    public Change vendSnack(int productId, BigDecimal balance) throws VendingMachineNoInventoryException, VendingMachineInsufficientFundsException {
        Snack wantedSnack = dao.getSnackById(productId);
        if (wantedSnack.getProductInStock() > 0) {
            BigDecimal priceDifference = balance.subtract(wantedSnack.getProductCost());
            int differenceResult = priceDifference.compareTo(BigDecimal.ZERO);

            if (differenceResult >= 0) {
                wantedSnack.setProductInStock(wantedSnack.getProductInStock() - 1);
                dao.updateSnack(wantedSnack);
                change.getChangeDue(priceDifference.multiply(new BigDecimal("100")).setScale(0));
                return change;
            } else {
                throw new VendingMachineInsufficientFundsException("Please insert: $" + wantedSnack.getProductCost().subtract(balance), productId, balance);
            }
        } else {
            throw new VendingMachineNoInventoryException("SOLD OUT!!!", productId, balance);
        }
    }

    @Override
    public void loadInventoryList() {
        dao.loadInventoryList();
    }

    @Override
    public Change getChange(BigDecimal balance) {
        change.getChangeDue(balance.multiply(new BigDecimal("100")).setScale(0));
        return change;
    }

}
