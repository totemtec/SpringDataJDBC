package com.example.auditing;

import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Insert
     */
    public Order createOrder(Order order)
    {
        return orderRepository.save(order);
    }

    /**
     * Update
     */
    public Order updateOrder(Long orderId, Long totalPrice)
    {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setTotalPrice(totalPrice);
            order = orderRepository.save(order);
        }
        return order;
    }
}
