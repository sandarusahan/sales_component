package com.apiit.eirlss.sales_component.package_order_item;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    void deleteAllBySalesOrder(SalesOrder salesOrder);
    Iterable<OrderItem> findAllBySalesOrder(SalesOrder salesOrder);

}
