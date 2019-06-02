package com.apiit.eirlss.sales_component.package_order_item;


import com.apiit.eirlss.sales_component.package_order.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "item/")
public class OrderItemController {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    SalesOrderRepository salesOrderRepository;

    @GetMapping(path = "all")
    public Iterable<OrderItem> getOrderItems () {
        return orderItemRepository.findAll();
    }

    @GetMapping(path = "{itemId}")
    public OrderItem getOrderItem(@PathVariable int itemId){
        return orderItemRepository.findById(itemId).get();
    }

//    @PostMapping(path = "new")
//    public OrderItem AddNewOrderItem (@RequestBody OrderItem newOrderItem) {
//        OrderItem orderItem = null;
//        for(OrderItem item : getOrderItems()){
//            if (item.getProductId().equals(newOrderItem.getProductId()) && item.getSalesOrder().getSalesOrderId().equals(newOrderItem.getSalesOrder().getSalesOrderId())) {
//                orderItem = item;
//            }
//
//        }
//
//        if(orderItem==null){
//            orderItem = newOrderItem;
//        }else {
//            orderItem.setQty(newOrderItem.getQty());
//        }
//        return orderItemRepository.save(orderItem);
//
//    }
//


    @PutMapping(path = "update")
    public OrderItem UpdateOrderItem(@RequestBody OrderItem orderItem){

        OrderItem item = orderItemRepository.save(orderItem);
        System.out.println(item.getOrderItemId() + " is updated");

        return item;
    }


    @DeleteMapping("{itemId}")
    public Boolean DeleteOrderItem(@PathVariable int itemId){

        Optional<OrderItem> c = orderItemRepository.findById(itemId);
        if(c.isPresent())
            orderItemRepository.deleteById(itemId);

        System.out.println(c.get().getOrderItemId() + " is deleted");

        return c.isPresent();
    }


}
