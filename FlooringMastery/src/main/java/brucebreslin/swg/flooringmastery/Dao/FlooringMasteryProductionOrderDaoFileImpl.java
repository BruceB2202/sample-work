/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryProductionOrderDaoFileImpl implements FlooringMasteryOrderDao {

    public static final String ORDERNUMBERFILE = "orderNumber.txt";
    public static final String DELIMITER = ",";

    Map<Integer, Order> orderList = new HashMap<>();
    int nextOrderNumber;

    @Override
    public Order addOrder(Order order) throws FlooringMasteryDataPersistenceException {
        Order newOrder = orderList.put(order.getOrderId(), order);
        nextOrderNumber++;
        saveNextOrderNumber();
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
    public void saveOrders(List<Order> orderList) throws FlooringMasteryDataPersistenceException {

        Map<LocalDate, List<Order>> sortedOrderList = orderList.stream()
                .collect(Collectors.groupingBy(Order::getOrderDate));
        PrintWriter out;
        Set<LocalDate> dateKeys = sortedOrderList.keySet();

        for (LocalDate dateKey : dateKeys) {
            String SAVE_FILE = "orders/orderLog/Orders_" + dateKey.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
            List<Order> ordersFromDate = orderList.stream()
                    .filter(order -> order.getOrderDate().equals(dateKey))
                    .collect(Collectors.toList());

            try {
                out = new PrintWriter(new FileWriter(SAVE_FILE));
            } catch (IOException e) {
                throw new FlooringMasteryDataPersistenceException("Could not save order data.", e);
            }

            for (Order order : ordersFromDate) {
                out.println("\"" + order.getOrderId() + "\"" + DELIMITER + "\"" + order.getCustomerName() + "\"" + DELIMITER + "\"" + order.getCustomerState().getStateId() + "\"" + DELIMITER + "\"" + order.getCustomerState().getStateName() + "\"" + DELIMITER + "\"" + order.getCustomerState().getStateTaxRate().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getCustomerProduct().getProductId() + "\"" + DELIMITER + "\"" + order.getCustomerProduct().getProductName() + "\"" + DELIMITER + "\"" + order.getAreaOfProject() + "\"" + DELIMITER + "\"" + order.getCustomerProduct().getMaterialCostPerSqFt().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getCustomerProduct().getLaborCostPerSqFt().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getTotalCostOfMaterials().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getTotalCostOfLabor().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getTotalOrderTaxes().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getTotalOrderPrice().setScale(2, RoundingMode.HALF_UP) + "\"" + DELIMITER + "\"" + order.getOrderDate().format(DateTimeFormatter.ofPattern("MMddyyyy")) + "\"");

                out.flush();
            }
            out.close();

        }

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
                Order currentOrder = new Order(Integer.parseInt(currentTokens[0].substring(1, currentTokens[0].length() - 1)));
                currentOrder.setCustomerName(currentTokens[1].substring(1, currentTokens[1].length() - 1));
                State customerState = new State(Integer.parseInt(currentTokens[2].substring(1, currentTokens[2].length() - 1)));
                customerState.setStateName(currentTokens[3].substring(1, currentTokens[3].length() - 1));
                customerState.setStateTaxRate(new BigDecimal(currentTokens[4].substring(1, currentTokens[4].length() - 1)));
                currentOrder.setCustomerState(customerState);
                Product customerProduct = new Product(Integer.parseInt(currentTokens[5].substring(1, currentTokens[5].length() - 1)));
                customerProduct.setProductName(currentTokens[6].substring(1, currentTokens[6].length() - 1));
                currentOrder.setAreaOfProject(new BigDecimal(currentTokens[7].substring(1, currentTokens[7].length() - 1)));
                customerProduct.setMaterialCostPerSqFt(new BigDecimal(currentTokens[8].substring(1, currentTokens[8].length() - 1)));
                customerProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[9].substring(1, currentTokens[9].length() - 1)));
                currentOrder.setCustomerProduct(customerProduct);
                currentOrder.setTotalCostOfMaterials(new BigDecimal(currentTokens[10].substring(1, currentTokens[10].length() - 1)));
                currentOrder.setTotalCostOfLabor(new BigDecimal(currentTokens[11].substring(1, currentTokens[11].length() - 1)));
                currentOrder.setTotalOrderTaxes(new BigDecimal(currentTokens[12].substring(1, currentTokens[12].length() - 1)));
                currentOrder.setTotalOrderPrice(new BigDecimal(currentTokens[13].substring(1, currentTokens[13].length() - 1)));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
                currentOrder.setOrderDate(LocalDate.parse(currentTokens[14].substring(1, currentTokens[14].length() - 1), formatter));

                orderList.put(currentOrder.getOrderId(), currentOrder);
            }

            scanner.close();
        }
    }

    @Override
    public int getNextOrderNumber() {
        int newOrderNumber = nextOrderNumber;
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
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDERNUMBERFILE));
        } catch (IOException e) {
            throw new FlooringMasteryDataPersistenceException("Could not save order number to file.");
        }
        out.println(nextOrderNumber);
        out.flush();

    }

    @Override
    public void removeBlankOrderFile(LocalDate dateToBlankOut) throws FlooringMasteryDataPersistenceException {
        try {
            String SAVE_FILE = "orders/orderLog/Orders_" + dateToBlankOut.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt";
            Path path = Paths.get(SAVE_FILE);
            
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            throw new FlooringMasteryDataPersistenceException("File could not be deleted, duplicate orders may occur.");
        }

    }

}
