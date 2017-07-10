/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendControl;

import brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException;
import brucebreslin.swg.vendingmachine.VendDto.Snack;
import brucebreslin.swg.vendingmachine.VendService.Change;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineInsufficientInventoryException;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineInsufficientFundsException;
import brucebreslin.swg.vendingmachine.VendService.VendingMachineService;
import brucebreslin.swg.vendingmachine.VendView.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineService service;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void runVendingMachine() {
        boolean keepRunning = true;
        int menuSelection;

        try {
            printInventory();
            while (keepRunning) {

                menuSelection = getMainMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addMoneyToBalance();
                        break;
                    case 2:
                        orderItem();
                        break;
                    case 3:
                        keepRunning = false;
                    default:
                        unknownCommand();
                }

            }
        } catch (VendFilePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void printInventory() throws VendFilePersistenceException {
        List<Snack> snackList = service.getAllSnacksInInventory();
        view.printAllItemsInStock(snackList);
    }

    private int getMainMenuSelection() {
        return view.printMainMenuGetUserChoice();
    }

    private String addMoneyToBalance() {
        view.displayAddMoneyBanner();
        BigDecimal amountToAdd = view.getAmountToAdd();
        return service.addMoney(amountToAdd);

    }

    private void orderItem() throws VendFilePersistenceException {

        boolean validSale = true;
        boolean wantToGoBack = false;

        view.displayOrderBanner();

        do {
            printInventory();
            String wantedItemLocation = view.getWantedItemLocation();
            if (wantedItemLocation.equalsIgnoreCase("exit")) {
                wantToGoBack = true;
            } else {
                try {
                    Change change = service.vendService(wantedItemLocation);
                    view.displayChangeDue(change.getQuarters(), change.getDimes(), change.getNickels(), change.getPennies());
                    view.displayActionSuccessBanner();
                    validSale = true;
                    wantToGoBack = false;
                } catch (VendingMachineInsufficientInventoryException | VendingMachineInsufficientFundsException e) {
                    validSale = false;
                    view.displayErrorMessage(e.getMessage());
                }
            }
        }while (!validSale && !wantToGoBack);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

}
