/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.View;

import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryView {

    UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public int displayMenuGetUserChoice() {
        io.print("=====================\n Flooring Program\n  1. Display Orders\n  2. Add an Order\n  3. Edit an Order\n  4. Remove an Order\n  5. Save Current Work\n  6. Quit");
        return io.readInt("What would you like to do?: (Enter number)", 1, 6);
    }

    public void displayViewOrdersBanner() {
        io.print("====View Orders====");
    }

    public LocalDate getDesiredDate() {
        boolean hasErrors;

        LocalDate desiredDate = null;
        do {
            try {
                desiredDate = io.readLocalDate("Please input the date for which you would like to see orders.(mm/dd/yyyy)");
                hasErrors = false;
            } catch (DateTimeParseException e) {
                io.print("Invalid date format. Please try again.");
                hasErrors = true;
            }
        }while(hasErrors);

            return desiredDate;
        }

    

    public void displayOrdersFromDate(List<Order> ordersFromDate) {
        for (Order order : ordersFromDate) {
            io.print(order.toString());
        }
    }

    public void displayCreateOrderBanner() {
        io.print("=====Create An Order=====");
    }

    public Order getOrderDetails(int nextOrderNumber, List<Product> productList, List<State> stateList) {
        String customerName = io.readString("Please enter customer name: ");

        BigDecimal areaOfProject = io.readBigDecimal("Enter Area of Project(sq. ft.): ");

        //get and convert product id number into product object
        io.print("Product ID: Product Name  ||  Material Cost/Sq Ft, Labor Cost/Sq Ft");
        for (Product product : productList) {
            io.print(product.toString());
        }

        int productIdOrdered = io.readInt("Enter the product ID of the ordered product: ", 1, productList.size());
        List<Product> productOrdered = productList.stream()
                .filter(product -> product.getProductId() == productIdOrdered)
                .collect(Collectors.toList());

        //get and convert state id number to state object
        io.print("State ID: State Name || Tax Rate");
        for (State state : stateList) {
            io.print(state.toString());
        }
        int stateIdOrderedFrom = io.readInt("Enter State ID of customer state: ", 1, stateList.size());
        List<State> stateOrderedFrom = stateList.stream()
                .filter(state -> state.getStateId() == stateIdOrderedFrom)
                .collect(Collectors.toList());

        LocalDate dateOrdered = io.readLocalDate("Please input the order date: (MM/dd/yyyy)");

        Order newOrder = new Order(nextOrderNumber);
        newOrder.setCustomerName(customerName);
        newOrder.setCustomerProduct(productOrdered.get(0));
        newOrder.setAreaOfProject(areaOfProject);
        newOrder.setCustomerState(stateOrderedFrom.get(0));
        newOrder.setOrderDate(dateOrdered);

        return newOrder;

    }

    public boolean confirmOrderDetails(Order fullOrder) {
        boolean userInputValid = false;
        boolean userApproval = false;

        do {
            io.print(fullOrder.toString());
            String userAnswer = io.readString("Is the information shown correct? (Y/N)");
            if (userAnswer.equalsIgnoreCase("y")) {
                userApproval = true;
                userInputValid = true;
            } else if (userAnswer.equalsIgnoreCase("n")) {
                userApproval = false;
                userInputValid = true;
            } else {
                io.print("Invalid entry, please enter either 'y' for yes or 'n' for no.");
            }
        } while (!userInputValid);
        return userApproval;
    }

    public void displayCancelActionMessage() {
        io.readString("Action has been cancelled. Press Enter to continue.");
    }

    public void displayActionSuccessMessage() {
        io.readString("Action has been completed successfully. Please press enter to continue.");
    }

    public void displayEditOrderBanner() {
        io.print("====Edit Order====");
    }

    public int getDesiredOrderId() {
        int wantedId = io.readInt("Please enter the ID of the order you wish to access: ");
        return wantedId;
    }

    public Order getEditedOrderInformation(Order orderToEdit, List<Product> productList, List<State> stateList) {

        String editedName = io.readString("Current name: " + orderToEdit.getCustomerName() + "|| Please enter the correct name for the order, if this name is correct please press enter to continue.");
        if (editedName.trim().length() > 0) {
            orderToEdit.setCustomerName(editedName);
        } else {
            orderToEdit.setCustomerName(orderToEdit.getCustomerName());
        }

        String editedArea = io.readString("Current Area of Order: " + orderToEdit.getAreaOfProject().toString() + " || If this value is correct press enter to continue, otherwise input the new value and press enter.");
        if (editedArea.trim().length() > 0) {
            orderToEdit.setAreaOfProject(new BigDecimal(editedArea));
        } else {
            orderToEdit.setAreaOfProject(orderToEdit.getAreaOfProject());
        }

        for (Product product : productList) {
            io.print(product.toString());
        }
        String editedProductId = io.readString("Current Product: " + orderToEdit.getCustomerProduct().toString() + " || If this is correct please press enter, otherwise input the ID of the product desired.");
        if (editedProductId.trim().length() > 0) {
            int productId = Integer.parseInt(editedProductId);
            orderToEdit.setCustomerProduct(productList.get(productId));
        }
        
        for(State state : stateList){
            io.print(state.toString());
        }
        String editedStateId = io.readString("Current state: " + orderToEdit.getCustomerState().toString() + " || If this is correct please press enter, otherwise input the ID of the state desired.");
        if (editedStateId.trim().length() > 0) {
            int stateId = Integer.parseInt(editedStateId);
            orderToEdit.setCustomerState(stateList.get(stateId));
        }

        String editedOrderDate = io.readString("Current order date: " + orderToEdit.getOrderDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + " || If this is correct please press enter, otherwise input the correct Date.(MM/dd/yyyy)");
        if (editedOrderDate.trim().length() > 0) {
            LocalDate orderDate = LocalDate.parse(editedOrderDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            orderToEdit.setOrderDate(orderDate);
        }

        return orderToEdit;

    }

    public void displayRemoveOrderBanner() {
        io.print("====Remove Order====");
    }

    public void displaySaveWorkBanner() {
        io.print("====Save Work====");
    }

    public boolean confirmSaveWork() {
        String userApproved = io.readString("Are you sure you would like to save your current work?(y/n) \n NOTE!!: WORK WILL ONLY BE SAVED IN PROD SETTING. IN TRAINING MODE NO FILES WILL BE WRITTEN TO MEMORY.");
        if (userApproved.equalsIgnoreCase("y")) {
            io.print("Work is being saved.");
            return true;
        } else if (userApproved.equalsIgnoreCase("n")) {
            io.print("Work will not be saved!");
            return false;
        } else {
            io.print("Unknown command.. please try again. If you feel you have received this message in error please contact your administrator.");
            return false;
        }
    }

    public void displayExitBanner() {
        io.print("====Exit Program====");
    }

    public boolean confirmExitProgram() {
        String userApproved = io.readString("Are you sure you would like to exit the program?(y/n)");
        if (userApproved.equalsIgnoreCase("y")) {
            io.print("Work is being saved. Then the program will exit.");
            return true;
        } else if (userApproved.equalsIgnoreCase("n")) {
            io.print("Returning to program.");
            return false;
        } else {
            io.print("Unknown command.. please try again. If you feel you have received this message in error please contact your administrator.");
            return false;
        }
    }

    public void displayExitMessage() {
        io.print("Thank you for using Flooring Mastery!");
    }

    public void displayUnknownCommandMessage() {
        io.print("Unknown Command!!");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

}
