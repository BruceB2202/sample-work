/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Bruce_Breslin
 */
public class Order {
    private int orderId;
    private String customerName;
    private BigDecimal areaOfProject;
    private State customerState;
    private Product customerProduct;
    private BigDecimal totalCostOfMaterials;
    private BigDecimal totalCostOfLabor;
    private BigDecimal totalOrderTaxes;
    private BigDecimal totalOrderPrice;
    private LocalDate orderDate;
    
    public Order(int orderId){
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer Name: " + customerName + ", Area Of Project: " + areaOfProject + ", Customer State: " + customerState.getStateName() + ", Customer Product: " + customerProduct.getProductName() + ", Total Cost Of Materials: " + totalCostOfMaterials.setScale(2, RoundingMode.HALF_UP) + ", Total Cost Of Labor: " + totalCostOfLabor.setScale(2, RoundingMode.HALF_UP) + ", Total Order Taxes: " + totalOrderTaxes.setScale(2, RoundingMode.HALF_UP) + ", Total Order Price: " + totalOrderPrice.setScale(2, RoundingMode.HALF_UP) + ", Order Date: " + orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.orderId;
        hash = 47 * hash + Objects.hashCode(this.customerName);
        hash = 47 * hash + Objects.hashCode(this.areaOfProject);
        hash = 47 * hash + Objects.hashCode(this.customerState);
        hash = 47 * hash + Objects.hashCode(this.customerProduct);
        hash = 47 * hash + Objects.hashCode(this.totalCostOfMaterials);
        hash = 47 * hash + Objects.hashCode(this.totalCostOfLabor);
        hash = 47 * hash + Objects.hashCode(this.totalOrderTaxes);
        hash = 47 * hash + Objects.hashCode(this.totalOrderPrice);
        hash = 47 * hash + Objects.hashCode(this.orderDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.areaOfProject, other.areaOfProject)) {
            return false;
        }
        if (!Objects.equals(this.customerState, other.customerState)) {
            return false;
        }
        if (!Objects.equals(this.customerProduct, other.customerProduct)) {
            return false;
        }
        if (!Objects.equals(this.totalCostOfMaterials, other.totalCostOfMaterials)) {
            return false;
        }
        if (!Objects.equals(this.totalCostOfLabor, other.totalCostOfLabor)) {
            return false;
        }
        if (!Objects.equals(this.totalOrderTaxes, other.totalOrderTaxes)) {
            return false;
        }
        if (!Objects.equals(this.totalOrderPrice, other.totalOrderPrice)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getAreaOfProject() {
        return areaOfProject;
    }

    public void setAreaOfProject(BigDecimal areaOfProject) {
        this.areaOfProject = areaOfProject;
    }

    public State getCustomerState() {
        return customerState;
    }

    public void setCustomerState(State customerState) {
        this.customerState = customerState;
    }

    public Product getCustomerProduct() {
        return customerProduct;
    }

    public void setCustomerProduct(Product customerProduct) {
        this.customerProduct = customerProduct;
    }

    public BigDecimal getTotalCostOfMaterials() {
        return totalCostOfMaterials;
    }

    public void setTotalCostOfMaterials(BigDecimal totalCostOfMaterials) {
        this.totalCostOfMaterials = totalCostOfMaterials;
    }

    public BigDecimal getTotalCostOfLabor() {
        return totalCostOfLabor;
    }

    public void setTotalCostOfLabor(BigDecimal totalCostOfLabor) {
        this.totalCostOfLabor = totalCostOfLabor;
    }

    public BigDecimal getTotalOrderTaxes() {
        return totalOrderTaxes;
    }

    public void setTotalOrderTaxes(BigDecimal totalOrderTaxes) {
        this.totalOrderTaxes = totalOrderTaxes;
    }

    public BigDecimal getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(BigDecimal totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }
    
    
    
}
