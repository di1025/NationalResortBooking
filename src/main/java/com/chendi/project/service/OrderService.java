package com.chendi.project.service;

import com.chendi.project.domain.Order;
import com.chendi.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public List<Order> findByPurchasedDate(Instant orderDate){
        return orderRepository.findByPurchasedDate(orderDate);
    }

    public List<Order> findByUserId(Long id){
        return orderRepository.findByUserId(id);
    }
}
