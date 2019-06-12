package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.CourierRepository;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_customer.CustomerRepository;
import com.apiit.eirlss.sales_component.package_order_item.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    public SalesOrder getSalesOrder(@PathVariable int orderId){
        return salesOrderRepository.findById(orderId).get();
    }

    @GetMapping(path = "courier/{courierId}")
    public Iterable<SalesOrder> getSalesOrderByCourierId(@PathVariable String courierId){

        return salesOrderRepository.findAllByCourier(courierRepository.findById(courierId).get());
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
    public SalesOrder AddNewOrder (@RequestBody SalesOrder salesOrder) {

        return salesOrderRepository.save(salesOrder);
    }

    @PutMapping(path = "update")
    public SalesOrder UpdateOrder(@RequestBody SalesOrder salesOrder){

        SalesOrder order = salesOrderRepository.save(salesOrder);
        System.out.println(order.getSalesOrderId() + " is updated");

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
