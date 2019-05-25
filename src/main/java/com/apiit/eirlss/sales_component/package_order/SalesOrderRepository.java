package com.apiit.eirlss.sales_component.package_order;

import com.apiit.eirlss.sales_component.package_courier.Courier;
import com.apiit.eirlss.sales_component.package_customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder, String> {
    Iterable<SalesOrder> findAllByCourier(Courier courier);

    Iterable<SalesOrder> findAllByCustomer(Customer customer);

    Iterable<SalesOrder> findAllByOrderType(SalesOrder.OrderType orderType);

    Iterable<SalesOrder> findAllByOrderTypeAndCustomer(SalesOrder.OrderType orderType, Customer customer);

}
