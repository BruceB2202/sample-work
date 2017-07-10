/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Snack;
import java.util.List;

/**
 *
 * @author brucebreslin22
 */
public interface VendingMachineDao {
    //add the given Snack to the inventory
    public Snack addSnack(Snack snack);
    
    //remove the snack associated with the given snackId from the inventory
    public void removeSnack(int snackId);
    
    //updates the given Snack in the inventory
    public void updateSnack(Snack snack);
    
    //finds and returns the Snack in the inventory associated with the given snackId
    public Snack getSnackById(int snackId);
    
    //returns a list of all snacks in the inventory
    public List<Snack> getAllSnacks();
    
    //based upon the particular implementation of the app, loads in an inventory list from the appropriate source
    public void loadInventoryList();
}
