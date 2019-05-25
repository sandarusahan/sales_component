package com.apiit.eirlss.sales_component.package_order_item;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
    void deleteAllBySalesOrder(SalesOrder salesOrder);
    Iterable<OrderItem> findAllBySalesOrder(SalesOrder salesOrder);

}
