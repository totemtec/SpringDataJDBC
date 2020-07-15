package com.example.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/create")
    public Order createOrder()
    {
        Order order = new Order();
        order.setUserId(1L);
        order.setTotalPrice(100L);
        order.setMerchandiseName("CocaCola 1L");

        return orderService.createOrder(order);
    }

    @GetMapping("/order/update/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @RequestParam Long totalPrice)
    {
        return orderService.updateOrder(id, totalPrice);
    }
}
