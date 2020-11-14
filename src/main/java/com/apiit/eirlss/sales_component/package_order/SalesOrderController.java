package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.Courier;
import com.apiit.eirlss.sales_component.package_courier.CourierRepository;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_customer.CustomerRepository;
import com.apiit.eirlss.sales_component.package_order.SalesOrder.ShipmentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales-orders/")
public class SalesOrderController {

    @Autowired
    SalesOrderRepository salesOrderRepository;

    @Autowired
    CourierRepository courierRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "all")
    public Iterable<SalesOrder> GetOrders () {
        return salesOrderRepository.findAll();
    }

    @GetMapping(path = "{orderId}")
    public SalesOrderRes getSalesOrder(@PathVariable int orderId){
        SalesOrder salesOrder = salesOrderRepository.findById(orderId).get();
        SalesOrderRes orderRes = new SalesOrderRes();
        Courier courier = new Courier();
        
        if(salesOrder.getShipmentType() == ShipmentType.COURIER && salesOrder.getCourier() != null){
            courier = courierRepository.findById(salesOrder.getCourier()).get();
        }
        
        orderRes.setCourier(courier);
        orderRes.setCustomer(salesOrder.getCustomer());
        orderRes.setDueDate(salesOrder.getDueDate());
        orderRes.setOrderDate(salesOrder.getOrderDate());
        orderRes.setOrderItems(salesOrder.getOrderItems());
        orderRes.setOrderStatus(salesOrder.getOrderStatus());
        orderRes.setOrderType(salesOrder.getOrderType());
        orderRes.setPaymentStatus(salesOrder.getPaymentStatus());
        orderRes.setSalesOrderId(salesOrder.getSalesOrderId());
        orderRes.setShipmentType(salesOrder.getShipmentType());
        orderRes.setTimestamp(salesOrder.getTimestamp());

        return orderRes;
    }

    @GetMapping(path = "courier/{courierId}")
    public Iterable<SalesOrder> getSalesOrderByCourierId(@PathVariable String courierId){

        return salesOrderRepository.findAllByCourierId(courierId);
    }

    @GetMapping(path = "customer/{custId}")
    public Iterable<SalesOrder> getSalesOrderByCustomerId(@PathVariable String custId){

        Customer customer = customerRepository.findById(custId).get();
        return salesOrderRepository.findAllByCustomer(customer);
    }

    @GetMapping(path = "type/{type}")
    public Iterable<SalesOrder> getSalesOrderByOrderType(@PathVariable String type){

        return salesOrderRepository.findAllByOrderType(SalesOrder.OrderType.valueOf(type.toUpperCase()));
    }

    @GetMapping(path = "type/{type}/customer/{custId}")
    public Iterable<SalesOrder> getSalesOrderByOrderTypeAndCustomer(@PathVariable String type,@PathVariable String custId){

        Customer customer = customerRepository.findById(custId).get();
        return salesOrderRepository.findAllByOrderTypeAndCustomer(SalesOrder.OrderType.valueOf(type.toUpperCase()), customer);
    }

    @GetMapping(path = "type/{type}/orderId/{orderId}")
    public Iterable<SalesOrder> getSalesOrderByOrderTypeAndOrderId(@PathVariable String type,@PathVariable String orderId){

        return salesOrderRepository.findAllByOrderTypeAndSalesOrderId(SalesOrder.OrderType.valueOf(type.toUpperCase()), orderId);
    }

    @PostMapping(path = "new")
    public SalesOrder AddNewOrder (@RequestBody SalesOrderRes salesOrder) {
        
        SalesOrder order = new SalesOrder();
        if(salesOrder.getShipmentType().equals(ShipmentType.POST)){
            order.setCourier("");
        }else {
            order.setCourier(salesOrder.getCourier().getCourierId());
        }
        order.setCustomer(salesOrder.getCustomer());
        order.setDueDate(salesOrder.getDueDate());
        order.setOrderDate(salesOrder.getOrderDate());
        order.setOrderItems(salesOrder.getOrderItems());
        order.setOrderStatus(salesOrder.getOrderStatus());
        order.setOrderType(salesOrder.getOrderType());
        order.setPaymentStatus(salesOrder.getPaymentStatus());
        order.setSalesOrderId(salesOrder.getSalesOrderId());
        order.setShipmentType(salesOrder.getShipmentType());
        order.setTimestamp(salesOrder.getTimestamp());
        return salesOrderRepository.save(order);
    }

    @PutMapping(path = "update")
    public SalesOrder UpdateOrder(@RequestBody SalesOrderRes salesOrder){
        SalesOrder order = new SalesOrder();
        if(salesOrder.getShipmentType().equals(ShipmentType.POST)){
            order.setCourier("");
        }else {
            order.setCourier(salesOrder.getCourier().getCourierId());
        }
        order.setCustomer(salesOrder.getCustomer());
        order.setDueDate(salesOrder.getDueDate());
        order.setOrderDate(salesOrder.getOrderDate());
        order.setOrderItems(salesOrder.getOrderItems());
        order.setOrderStatus(salesOrder.getOrderStatus());
        order.setOrderType(salesOrder.getOrderType());
        order.setPaymentStatus(salesOrder.getPaymentStatus());
        order.setSalesOrderId(salesOrder.getSalesOrderId());
        order.setShipmentType(salesOrder.getShipmentType());
        order.setTimestamp(salesOrder.getTimestamp());

        order = salesOrderRepository.save(order);
        return order;
    }

    
    @DeleteMapping("/{orderId}")
    public Boolean DeleteCustomer(@PathVariable int orderId){

        Optional<SalesOrder> c = salesOrderRepository.findById(orderId);
        if(c.isPresent())
            salesOrderRepository.deleteById(orderId);

        return c.isPresent();
    }

}
