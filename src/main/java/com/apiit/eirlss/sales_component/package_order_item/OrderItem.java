package com.apiit.eirlss.sales_component.package_order_item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.lang.Nullable;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("orderItems")
    private SalesOrder salesOrder;

    private String productId;
    private String productName;
    private Double productPrice;
    private boolean isAvailable;
    private boolean isCancelled;
    private int qty;

    @Nullable
    private String reference;

    //status of each itm in the list

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }


//    public String getOrderItemId() {
//        return orderItemId;
//    }
//
//    public void setOrderItemId(String orderItemId) {
//        this.orderItemId = orderItemId;
//    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
