package com.apiit.eirlss.sales_component.package_order_item;

import com.apiit.eirlss.sales_component.package_customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "item/")
public class OrderItemController {
    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping(path = "all")
    public Iterable<OrderItem> GetOrderItems () {
        return orderItemRepository.findAll();
    }

    @GetMapping(path = "{itemId}")
    public OrderItem getOrderItem(@PathVariable String itemId){
        return orderItemRepository.findById(itemId).get();
    }

    @PostMapping(path = "new")
    public OrderItem AddNewOrderItem (@RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @PutMapping(path = "/update")
    public OrderItem UpdateOrderItem(@RequestBody OrderItem orderItem){

        OrderItem item = orderItemRepository.save(orderItem);
        System.out.println(item.getOrderItemId() + " is updated");

        return item;
    }


    @DeleteMapping("/{itemId}")
    public Boolean DeleteCustomer(@PathVariable String itemId){

        Optional<OrderItem> c = orderItemRepository.findById(itemId);
        if(c.isPresent())
            orderItemRepository.deleteById(itemId);

        System.out.println(c.get().getOrderItemId() + " is deleted");

        return c.isPresent();
    }
}
