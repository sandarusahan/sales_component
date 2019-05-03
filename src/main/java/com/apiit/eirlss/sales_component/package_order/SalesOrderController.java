package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.CourierRepository;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import com.apiit.eirlss.sales_component.package_customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "order/")
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
    public SalesOrder getSalesOrder(@PathVariable String orderId){
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
    @PostMapping(path = "new")
    public SalesOrder AddNewOrder (@RequestBody SalesOrder salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }

    @PutMapping(path = "/update")
    public SalesOrder UpdateOrder(@RequestBody SalesOrder salesOrder){

        SalesOrder order = salesOrderRepository.save(salesOrder);
        System.out.println(order.getSalesOrderId() + " is updated");

        return order;
    }


    @DeleteMapping("/{orderId}")
    public Boolean DeleteCustomer(@PathVariable String orderId){

        Optional<SalesOrder> c = salesOrderRepository.findById(orderId);
        if(c.isPresent())
            salesOrderRepository.deleteById(orderId);

        System.out.println(c.get().getSalesOrderId() + " is deleted");

        return c.isPresent();
    }
}
