/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import static brucebreslin.swg.flooringmastery.Dao.FlooringMasteryProductionOrderDaoFileImpl.DELIMITER;
import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryTrainingOrderDaoFileImpl implements FlooringMasteryOrderDao {

    public static final String ORDERNUMBERFILE = "ordernumber.txt";

    Map<Integer, Order> orderList = new HashMap<>();
    int nextOrderNumber;

    @Override
    public Order addOrder(Order order) throws FlooringMasteryDataPersistenceException {
        Order newOrder = orderList.put(order.getOrderId(), order);
        nextOrderNumber++;
        return newOrder;
    }

    @Override
    public Order getOrder(int orderId) {
        return orderList.get(orderId);
    }

    @Override
    public Map<LocalDate, List<Order>> getAllOrdersByDate() {
        return orderList.values()
                .stream()
                .collect(Collectors.groupingBy(Order::getOrderDate));
    }

    @Override
    public List<Order> getOrdersFromDate(LocalDate desiredDate) {
        return orderList.values()
                .stream()
                .filter(order -> order.getOrderDate().equals(desiredDate))
                .collect(Collectors.toList());
    }

    @Override
    public Order editOrder(Order editedOrder) {
        Order modifiedOrder = orderList.put(editedOrder.getOrderId(), editedOrder);
        return modifiedOrder;
    }

    @Override
    public Order removeOrder(Order orderToRemove) {
        Order removedOrder = orderList.remove(orderToRemove.getOrderId());
        return removedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderList.values());
    }

    @Override
    public void saveOrders(List<Order> orderList) {
        return;
    }

    @Override
    public void loadOrders() throws FlooringMasteryDataPersistenceException {
        File folder = new File("orders/orderLog");
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("Orders_");
            }
        });

        Scanner scanner;
        for (File file : files) {

            try {
                scanner = new Scanner(new BufferedReader(new FileReader(file)));
            } catch (FileNotFoundException e) {
                throw new FlooringMasteryDataPersistenceException("Could not load order data into memory.", e);
            }

            String currentLine;
            String[] currentTokens;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
                currentOrder.setCustomerName(currentTokens[1]);
                State customerState = new State(Integer.parseInt(currentTokens[2]));
                customerState.setStateName(currentTokens[3]);
                customerState.setStateTaxRate(new BigDecimal(currentTokens[4]));
                currentOrder.setCustomerState(customerState);
                Product customerProduct = new Product(Integer.parseInt(currentTokens[5]));
                customerProduct.setProductName(currentTokens[6]);
                currentOrder.setAreaOfProject(new BigDecimal(currentTokens[7]));
                customerProduct.setMaterialCostPerSqFt(new BigDecimal(currentTokens[8]));
                customerProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[9]));
                currentOrder.setCustomerProduct(customerProduct);
                currentOrder.setTotalCostOfMaterials(new BigDecimal(currentTokens[10]));
                currentOrder.setTotalCostOfLabor(new BigDecimal(currentTokens[11]));
                currentOrder.setTotalOrderTaxes(new BigDecimal(currentTokens[12]));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
                currentOrder.setOrderDate(LocalDate.parse(currentTokens[13], formatter));

                orderList.put(currentOrder.getOrderId(), currentOrder);
            }
            scanner.close();
        }
    }

    @Override
    public int getNextOrderNumber() {
        int newOrderNumber = nextOrderNumber;
        nextOrderNumber++;
        return newOrderNumber;
    }

    @Override
    public void loadNextOrderNumber() throws FlooringMasteryDataPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ORDERNUMBERFILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryDataPersistenceException("-_- Could not load next order # file.", e);
        }

        String currentLine;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            nextOrderNumber = Integer.parseInt(currentLine);
        }
        scanner.close();

    }

    @Override
    public void saveNextOrderNumber() throws FlooringMasteryDataPersistenceException {
        return;
    }

    @Override
    public void removeBlankOrderFile(LocalDate dateToBlankOut) {
        return;
    }

}
