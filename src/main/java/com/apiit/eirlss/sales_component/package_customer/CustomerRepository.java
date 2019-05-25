package com.apiit.eirlss.sales_component.package_customer;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Customer findCustomerByCustomerEmail(String email);
}
