/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Service;

import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryDataPersistenceException;
import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryOrderDao;
import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryProductDao;
import brucebreslin.swg.flooringmastery.Dao.FlooringMasteryStateDao;
import brucebreslin.swg.flooringmastery.Model.Order;
import brucebreslin.swg.flooringmastery.Model.Product;
import brucebreslin.swg.flooringmastery.Model.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    FlooringMasteryOrderDao orderDao;
    FlooringMasteryProductDao productDao;
    FlooringMasteryStateDao stateDao;
    
    public FlooringMasteryServiceLayerImpl(FlooringMasteryOrderDao orderDao, FlooringMasteryProductDao productDao, FlooringMasteryStateDao stateDao){
        this.orderDao = orderDao;
        this.stateDao = stateDao;
        this.productDao = productDao;
    }

    @Override
    public void addOrder(Order order) throws FlooringMasteryDuplicateOrderIdException, FlooringMasteryDataValidationException , FlooringMasteryDataPersistenceException{

        if (orderDao.getOrder(order.getOrderId()) != null) {
            throw new FlooringMasteryDuplicateOrderIdException("An order already exists with this ID.");
        }
        validateOrderData(order);

        orderDao.addOrder(order);

    }

    @Override
    public Order getOrder(int orderId) {
        return orderDao.getOrder(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<Order> getOrdersFromDate(LocalDate desiredDate) {
        return orderDao.getOrdersFromDate(desiredDate);
    }

    @Override
    public Order editOrder(Order editedOrder) throws FlooringMasteryOrderNotFoundException, FlooringMasteryDataValidationException {
        if (orderDao.getOrder(editedOrder.getOrderId()) == null) {
            throw new FlooringMasteryOrderNotFoundException("An order cannot be found with the ID : " + editedOrder.getOrderId());
        }
        validateOrderData(editedOrder);

        orderDao.editOrder(editedOrder);
        return editedOrder;

    }

    @Override
    public Order removeOrder(Order orderToRemove) {
        return orderDao.removeOrder(orderToRemove);
    }

    @Override
    public void addProduct(Product product) throws FlooringMasteryDuplicateProductIdException, FlooringMasteryDataValidationException {
        if (productDao.getProduct(product.getProductId()) != null) {
            throw new FlooringMasteryDuplicateProductIdException("Product ID is already in use, cannot create a product with this ID.");
        }

        validateProductData(product);
        productDao.addProduct(product);

    }

    @Override
    public Product getProduct(int productId) {
        return productDao.getProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product editProduct(Product modifiedProduct) throws FlooringMasteryProductNotFoundException, FlooringMasteryDataValidationException {
        if (productDao.getProduct(modifiedProduct.getProductId()) == null) {
            throw new FlooringMasteryProductNotFoundException("No product can be found with ID: " + modifiedProduct.getProductId());
        }
        validateProductData(modifiedProduct);
        productDao.editProduct(modifiedProduct);
        return modifiedProduct;

    }

    @Override
    public Product removeProduct(int productId) {
        return productDao.removeProduct(productId);
    }

    @Override
    public void addState(State state) throws FlooringMasteryDuplicateStateIdException, FlooringMasteryDataValidationException {
        if (stateDao.getState(state.getStateId()) != null) {
            throw new FlooringMasteryDuplicateStateIdException("A state already exists with the ID, " + state.getStateId() + "; please try again.");
        }
        validateStateData(state);

        stateDao.addState(state);

    }

    @Override
    public State getState(int stateId) {
        return stateDao.getState(stateId);
    }

    @Override
    public List<State> getAllStates() {
        return stateDao.getAllStates();
    }

    @Override
    public State editState(State modifiedState) throws FlooringMasteryStateNotFoundException, FlooringMasteryDataValidationException {
        if (stateDao.getState(modifiedState.getStateId()) == null) {
            throw new FlooringMasteryStateNotFoundException("No state found with Id: " + modifiedState.getStateId());
        }
        validateStateData(modifiedState);

        return stateDao.editState(modifiedState);

    }

    @Override
    public State removeState(int stateId) {
        return stateDao.removeState(stateId);
    }

    @Override
    public Order calculateCostsAndTaxes(Order shellOrder) {
        BigDecimal area = shellOrder.getAreaOfProject();
        BigDecimal materialCost = shellOrder.getCustomerProduct().getMaterialCostPerSqFt().multiply(area);
        shellOrder.setTotalCostOfMaterials(materialCost);
        BigDecimal laborCost = shellOrder.getCustomerProduct().getLaborCostPerSqFt().multiply(area);
        shellOrder.setTotalCostOfLabor(laborCost);
        BigDecimal totalCostForProduct = laborCost.add(materialCost);
        BigDecimal taxesTotal = totalCostForProduct.multiply(shellOrder.getCustomerState().getStateTaxRate().movePointLeft(2));
        shellOrder.setTotalOrderTaxes(taxesTotal);
        shellOrder.setTotalOrderPrice(totalCostForProduct.add(taxesTotal));

        return shellOrder;

    }

    @Override
    public void saveOrders() throws FlooringMasteryDataPersistenceException{
        orderDao.saveOrders(orderDao.getAllOrders());
    }

    @Override
    public int getNextOrderNumber() {
        return orderDao.getNextOrderNumber();
    }

    private void validateOrderData(Order order) throws FlooringMasteryDataValidationException {
        if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0 || order.getAreaOfProject() == null || order.getAreaOfProject().equals(BigDecimal.ZERO) || order.getCustomerState() == null || stateDao.getState(order.getCustomerState().getStateId()) == null || order.getCustomerProduct() == null || productDao.getProduct(order.getCustomerProduct().getProductId()) == null || order.getTotalCostOfMaterials() == null || order.getTotalCostOfLabor() == null || order.getTotalOrderTaxes() == null || order.getTotalOrderPrice() == null || order.getOrderDate() == null) {
            throw new FlooringMasteryDataValidationException("Error: Invalid order data!!");
        }
    }

    private void validateProductData(Product product) throws FlooringMasteryDataValidationException {
        if (product.getProductName() == null || product.getProductName().trim().length() == 0 || product.getLaborCostPerSqFt() == null || product.getMaterialCostPerSqFt() == null) {
            throw new FlooringMasteryDataValidationException("Error: Product Name, Material Cost, and Labor Cost are all required fields.");
        }
    }

    private void validateStateData(State state) throws FlooringMasteryDataValidationException {
        if (state.getStateName() == null || state.getStateName().trim().length() == 0 || state.getStateTaxRate() == null) {
            throw new FlooringMasteryDataValidationException("Error: State Name and Tax Rate are required.");
        }
    }

    @Override
    public void loadNextOrderNumber() throws FlooringMasteryDataPersistenceException{
        orderDao.loadNextOrderNumber();
    }

    @Override
    public void loadStates() throws FlooringMasteryDataPersistenceException{
        stateDao.loadStates();
    }

    @Override
    public void loadProducts() throws FlooringMasteryDataPersistenceException {
        productDao.loadProducts();
    }

    @Override
    public void loadOrders() throws FlooringMasteryDataPersistenceException {
        orderDao.loadOrders();
    }

    @Override
    public void saveOrderNumber() throws FlooringMasteryDataPersistenceException {
        orderDao.saveNextOrderNumber();
    }

    @Override
    public void removeBlankOrderFile(LocalDate dateToBlankOut) throws FlooringMasteryDataPersistenceException{
        orderDao.removeBlankOrderFile(dateToBlankOut);
    }

}
