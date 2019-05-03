package com.apiit.eirlss.sales_component.package_courier;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Courier {
    @Id
    @NotNull
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "courier_id")
    private String courierId;

    @Column(name = "courier_company")
    private String company;
    @Column(name = "courier_telephone")
    private String telephone;
    @Column(name = "courier_vehicle_type")
    private String vehicleType;
    @Column(name = "courier_vehicle_id")
    private String vehicleId;
//
//    @Column(name = "courier_sales_orders")
//    @OneToMany(mappedBy = "courier")
//    @JsonIgnoreProperties("courier")
//    private Set<SalesOrder> salesOrders;

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

//    public Set<SalesOrder> getSalesOrders() {
//        return salesOrders;
//    }
//
//    public void setSalesOrders(Set<SalesOrder> salesOrders) {
//        this.salesOrders = salesOrders;
//    }
}
