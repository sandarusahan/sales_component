package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.Courier;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_order_item.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
public class SalesOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesOrderId;

    private Date orderDate;
    private OrderType orderType = OrderType.INQUIRY;
    private OrderStatus orderStatus = OrderStatus.ACTIVE;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("salesOrders")
    private Customer customer;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("salesOrder")
    private Set<OrderItem> orderItems;

    private Date dueDate;
    private ShipmentType shipmentType = ShipmentType.POST;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("salesOrders")
    private Courier courier;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp timestamp;

    public enum OrderType {
        INQUIRY,
        ORDER,
        RETURN_EXCHANGE,
        RETURN_CREDIT,
        RETURN_REPAIR
    }

    public enum OrderStatus {
        ACTIVE,
        CANCELLED,
        CLOSED
    }

    public enum ShipmentType {
        POST,
        COURIER
    }

    public int getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
        this.orderItems.forEach(orderItem -> orderItem.setSalesOrder(this));
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
