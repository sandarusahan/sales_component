package com.apiit.eirlss.sales_component.package_order_item;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {
    @Id
    @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "order_item_id")
    private String orderItemId;


    @ManyToOne
    @JoinColumn(name = "sales_order_id",nullable = false)
    @JsonIgnoreProperties("orderItems")
    private SalesOrder salesOrder;

    @Column(name = "order_item_product_id")
    private String productId;
    @Column(name = "order_item_product_name")
    private String productName;
    @Column(name = "order_item_product_price")
    private String productPrice;
    @Column(name = "order_item_is_available")
    private boolean isAvailable = false;
    @Column(name = "order_item_is_cancelled")
    private boolean isCancelled = false;
    @Column(name = "order_item_qty")
    private int qty;

    @Column(name = "order_item_reference")
    @Nullable
    private String reference;

    //status of each itm in the list

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

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

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
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
