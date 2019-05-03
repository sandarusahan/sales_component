package com.apiit.eirlss.sales_component.package_customer;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "customer_id")
    String customerId;

    @Column(name = "customer_name")
    String customerName;

    @Column(unique = true, name = "customer_email")
    @Email
    public String customerEmail;

    @Column(name = "customer_main_location")
    private String customerMainLocation;

    @Column(name = "customer_delivery_location")
    private String customerDeliveryLocation;

    @Column(name = "customer_collection_location")
    private String customerCollectionLocation;

    @Column(name = "customer_telephone")
    private String customerTelephone;

    @Column(name = "customer_type")
    private String customerType; // lead or customer

    @Column(name = "customer_payment_flag")
    private CustomerPaymentStatus customerPaymentFlag = CustomerPaymentStatus.CLEAR;

    @Column(name = "customer_sales_orders")
    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private Set<SalesOrder> salesOrders;

    public Customer() {
    }

    public Customer(String customerName, @Email String customerEmail, String customerMainLocation, String customerDeliveryLocation, String customerCollectionLocation, String customerTelephone, String customerType, CustomerPaymentStatus customerPaymentFlag) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerMainLocation = customerMainLocation;
        this.customerDeliveryLocation = customerDeliveryLocation;
        this.customerCollectionLocation = customerCollectionLocation;
        this.customerTelephone = customerTelephone;
        this.customerType = customerType;
        this.customerPaymentFlag = customerPaymentFlag;
    }

    public enum CustomerPaymentStatus {
        CLEAR,
        BLOCKED,
        PENDING;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMainLocation() {
        return customerMainLocation;
    }

    public void setCustomerMainLocation(String customerMainLocation) {
        this.customerMainLocation = customerMainLocation;
    }

    public String getCustomerDeliveryLocation() {
        return customerDeliveryLocation;
    }

    public void setCustomerDeliveryLocation(String customerDeliveryLocation) {
        this.customerDeliveryLocation = customerDeliveryLocation;
    }

    public String getCustomerCollectionLocation() {
        return customerCollectionLocation;
    }

    public void setCustomerCollectionLocation(String customerCollectionLocation) {
        this.customerCollectionLocation = customerCollectionLocation;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public CustomerPaymentStatus getCustomerPaymentFlag() {
        return customerPaymentFlag;
    }

    public void setCustomerPaymentFlag(CustomerPaymentStatus customerPaymentFlag) {
        this.customerPaymentFlag = customerPaymentFlag;
    }

    public Set<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public void setSalesOrders(Set<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }
}
