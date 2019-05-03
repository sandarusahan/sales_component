package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.Courier;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_order_item.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class SalesOrder {
    @Id
    @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "sales_order_id")
    private String salesOrderId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sales_order_date")
    private Date order_date;
    @Column(name = "sales_order_type")
    private OrderType orderType = OrderType.INQUIRY;
    @Column(name = "sales_order_status")
    private OrderStatus order_status = OrderStatus.ACTIVE;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties("salesOrders")
    private Customer customer;

    @Column(name = "sales_order_items")
    @OneToMany(mappedBy = "salesOrder")
    @JsonIgnoreProperties("salesOrder")
    private Set<OrderItem> orderItems;
    @Column(name = "sales_order_due_date")
    private Date dueDate;
    @Column(name = "sales_order_shipment_type")
    private ShipmentType shipmentType = ShipmentType.POST;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    @JsonIgnoreProperties("salesOrders")
    private Courier courier;

    public enum OrderType {
        INQUIRY,
        ORDER,
        RETURN;
    }

    public enum OrderStatus {
        ACTIVE,
        CANCELLED,
        DELIVERED;
    }

    public enum ShipmentType {
        POST,
        COURIER;
    }

    public String  getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
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
}
