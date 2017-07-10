/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Controller;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryDataValidationException;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryDuplicateOrderIdException;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryOrderNotFoundException;
import brucebreslin.swg.flooringmastery.Service.FlooringMasteryServiceLayer;
import brucebreslin.swg.flooringmastery.View.FlooringMasteryView;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryController {

    FlooringMasteryView view;
    FlooringMasteryServiceLayer service;
    
    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryServiceLayer service){
        this.view = view;
        this.service = service;
    }
    
    private boolean keepRunning = true;

    public void run() {
        try {
            loadNextOrderNumber();
            service.loadOrders();
            service.loadStates();
            service.loadProducts();
            do {
                int menuChoice = view.displayMenuGetUserChoice();

                switch (menuChoice) {
                    case 1:
                        viewOrdersForDate();
                        break;
                    case 2:
                        createAnOrder();
                        break;
                    case 3:
                        editAnOrder();
                        break;
                    case 4:
                        removeAnOrder();
                        break;
                    case 5:
                        saveOrderList();
                        break;
                    case 6:
                        exitProgram();
                        break;
                    default:
                        unknownCommand();
                        break;
                }

            } while (keepRunning);
        } catch (FlooringMasteryDataPersistenceException | FlooringMasteryDuplicateOrderIdException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void viewOrdersForDate() {
        view.displayViewOrdersBanner();
        LocalDate desiredDate = view.getDesiredDate();
        List<Order> ordersFromDate = service.getOrdersFromDate(desiredDate);
        view.displayOrdersFromDate(ordersFromDate);
    }

    private void createAnOrder() throws FlooringMasteryDuplicateOrderIdException, FlooringMasteryDataPersistenceException {
        int nextOrderNumber = service.getNextOrderNumber();
        boolean hasErrors = false;
        List<Product> productList = service.getAllProducts();
        List<State> stateList = service.getAllStates();

        view.displayCreateOrderBanner();
        do {
            Order shellOrder = view.getOrderDetails(nextOrderNumber, productList, stateList);
            Order fullOrder = service.calculateCostsAndTaxes(shellOrder);
            boolean orderApprovedByUser = view.confirmOrderDetails(fullOrder);
            try {
                if (orderApprovedByUser) {
                    service.addOrder(fullOrder);
                    view.displayActionSuccessMessage();
                } else {
                    view.displayCancelActionMessage();
                }
                hasErrors = false;
            } catch (FlooringMasteryDataValidationException e) {
                view.displayErrorMessage(e.getMessage());
                hasErrors = true;
            }
        } while (hasErrors);
    }

    private void editAnOrder() throws FlooringMasteryDataPersistenceException {
        boolean hasErrors = false;
        List<Product> productList = service.getAllProducts();
        List<State> stateList = service.getAllStates();
        
        view.displayEditOrderBanner();
        do{
        LocalDate desiredDate = view.getDesiredDate();
        List<Order> ordersFromDate = service.getOrdersFromDate(desiredDate);
        view.displayOrdersFromDate(ordersFromDate);
        int orderId = view.getDesiredOrderId();
        Order orderToEdit = service.getOrder(orderId);
        Order editedOrder = view.getEditedOrderInformation(orderToEdit, productList, stateList);
        Order completedEditedOrder = service.calculateCostsAndTaxes(editedOrder);
        boolean editCorrect = view.confirmOrderDetails(completedEditedOrder);
        try{
        if (editCorrect) {
            service.editOrder(completedEditedOrder);
            if(service.getOrdersFromDate(desiredDate).isEmpty()){
                service.removeBlankOrderFile(desiredDate);
            }
            view.displayActionSuccessMessage();
            hasErrors = false;
        } else {
            view.displayCancelActionMessage();
            hasErrors = false;
        }
        }catch(FlooringMasteryOrderNotFoundException | FlooringMasteryDataValidationException e){
            view.displayErrorMessage(e.getMessage());
            hasErrors = true;
        }
        }while(hasErrors);
    }

    private void removeAnOrder() throws FlooringMasteryDataPersistenceException {
        view.displayRemoveOrderBanner();
        LocalDate desiredDate = view.getDesiredDate();
        List<Order> ordersFromDate = service.getOrdersFromDate(desiredDate);
        view.displayOrdersFromDate(ordersFromDate);
        int orderId = view.getDesiredOrderId();
        Order orderToRemove = service.getOrder(orderId);
        boolean removeOrder = view.confirmOrderDetails(orderToRemove);
        if (removeOrder) {
            service.removeOrder(orderToRemove);
            if(service.getOrdersFromDate(desiredDate).isEmpty()){
                service.removeBlankOrderFile(desiredDate);
            }
            view.displayActionSuccessMessage();
        } else {
            view.displayCancelActionMessage();
        }

    }

    private void saveOrderList() throws FlooringMasteryDataPersistenceException {
        view.displaySaveWorkBanner();
        boolean confirmSave = view.confirmSaveWork();
        if (confirmSave) {
            service.saveOrders();
            view.displayActionSuccessMessage();
        } else {
            view.displayCancelActionMessage();
        }
    }

    private void exitProgram() {
        view.displayExitBanner();
        boolean confirmExit = view.confirmExitProgram();
        if (confirmExit) {
            view.displayExitMessage();
            keepRunning = false;
        } else {
            view.displayCancelActionMessage();
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandMessage();
    }

    private void loadNextOrderNumber() throws FlooringMasteryDataPersistenceException {
        service.loadNextOrderNumber();
    }

}
