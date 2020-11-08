package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.Courier;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_order.SalesOrder.OrderType;
import com.apiit.eirlss.sales_component.package_order.SalesOrder.PaymentStatus;
import com.apiit.eirlss.sales_component.package_order.SalesOrder.ShipmentType;
import com.apiit.eirlss.sales_component.package_order_item.OrderItem;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class SalesOrderRes {

    private int salesOrderId;

    private Date orderDate;
    private OrderType orderType = OrderType.INQUIRY;
    private String orderStatus;
    private Customer customer;
    private Set<OrderItem> orderItems;
    private Date dueDate;
    private ShipmentType shipmentType = ShipmentType.POST;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private Courier courier;
    private Timestamp timestamp;

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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    
}
