package com.apiit.eirlss.sales_component.package_customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "customer/")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "all")
    public Iterable<Customer> GetCustomers () {
        return customerRepository.findAll();
    }

    @GetMapping(path = "{custId}")
    public Customer getCustomer(@PathVariable String custId){
        return customerRepository.findById(custId).get();
    }

    @PostMapping(path = "new")
    public Customer AddNewCustomer (@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping(path = "/update")
    public Customer UpdateCustomer(@RequestBody Customer customer){

        Customer newcustomer = customerRepository.save(customer);
        System.out.println(newcustomer.getCustomerName() + " is updated");

        return newcustomer;
    }


    @DeleteMapping("/{custid}")
    public Boolean DeleteCustomer(@PathVariable String custid){

        Optional c = customerRepository.findById(custid);
        if(c.isPresent())
            customerRepository.deleteById(custid);

        System.out.println(c.get().toString() + " is deleted");

        return c.isPresent();
    }
}
