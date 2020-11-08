package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_customer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> {
    Iterable<SalesOrder> findAllByCourierId(String courierId);

    Iterable<SalesOrder> findAllByCustomer(Customer customer);

    Iterable<SalesOrder> findAllByOrderType(SalesOrder.OrderType orderType);

    Iterable<SalesOrder> findAllByOrderTypeAndCustomer(SalesOrder.OrderType orderType, Customer customer);

    Iterable<SalesOrder> findAllByOrderTypeAndSalesOrderId(SalesOrder.OrderType orderType, String salesOrderId);


}
