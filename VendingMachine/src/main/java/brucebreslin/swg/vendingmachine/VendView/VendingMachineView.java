/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendView;

import brucebreslin.swg.vendingmachine.VendDto.Snack;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineView {

    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMainMenuGetUserChoice() {
        io.print("1- Add Money  || 2. Order Item  || 3. Exit Program");
        return io.readInt("What would you like to do? (1-3): ", 1, 3);

    }

    public void displayAddMoneyBanner() {
        io.print("======Add Funds to Balance======");
    }

    public BigDecimal getAmountToAdd() {
        boolean stillAddingMoney = true;
        String currentlyAdding = "0.00";
        do {
            io.print("1. $1.00 || 2. $0.25 || 3. $0.10 || 4. $0.05 || 5. $0.01 || 6. Finished adding money.");

            int userAmountAdded = io.readInt("How much money are you adding?", 1, 6);
            switch (userAmountAdded) {
                case 1:
                    currentlyAdding = new BigDecimal(currentlyAdding).add(new BigDecimal("1.00"))
                            .toString();
                    break;
                case 2:
                    currentlyAdding = new BigDecimal(currentlyAdding).add(new BigDecimal("0.25"))
                            .toString();
                    break;
                case 3:
                    currentlyAdding = new BigDecimal(currentlyAdding).add(new BigDecimal("0.10"))
                            .toString();
                    break;
                case 4:
                    currentlyAdding = new BigDecimal(currentlyAdding).add(new BigDecimal("0.05"))
                            .toString();
                    break;
                case 5:
                    currentlyAdding = new BigDecimal(currentlyAdding).add(new BigDecimal("0.01"))
                            .toString();
                    break;
                case 6:
                    stillAddingMoney = false;
                    break;
                default:
                    displayUnknownCommandBanner();
            }

            io.print("Current Total to Add to Balance: " + new BigDecimal(currentlyAdding).setScale(2, RoundingMode.HALF_UP));
        } while (stillAddingMoney);
        return new BigDecimal(currentlyAdding);
    }

    public void displayActionSuccessBanner() {
        io.print("======Action Completed Successfully======");
    }

    public void displayOrderBanner() {
        io.print("======Make An Order======");
    }

    public void printAllItemsInStock(List<Snack> snackList) {
        io.print("  Item Location || Item Name || Cost");
        io.print("======================================");
        snackList.stream()
                .filter(s -> s.getAmountInStock() > 0)
                .collect(Collectors.toList())
                .forEach(s -> io.print(s.getLocationInMachine() + " || " + s.getName() + " || " + s.getCost().toString()));

    }

    public String getWantedItemLocation() {
        return io.readString("Enter the location of the item you would like(To go back enter 'exit': ");
    }

    public void displayUnknownCommandBanner() {
        io.print("!!!!!!  UNKNOWN COMMAND  !!!!!!!!");
    }

    public void displayChangeDue(int quarters, int dimes, int nickels, int pennies) {
        io.print("Change Due: Quarters- " + quarters + " Dimes- " + dimes + " Nickels- " + nickels + " Pennies- " + pennies);
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

}
