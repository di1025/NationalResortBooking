package com.chendi.project.api;


import com.chendi.project.domain.Order;
import com.chendi.project.domain.User;
import com.chendi.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.chendi.project.service.UserService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value={"/api/orders"})
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
    public Order generateOrder(@RequestBody Order order,@PathVariable("id") Long userId){
        order.setOrderDate(Instant.now());
        User owner = userService.findById(userId);
        order.setUser(owner);
        return orderService.save(order);
    }

    @RequestMapping(value="/{Id}",method=RequestMethod.PATCH)
    public Order updatePaidDate(@PathVariable Long orderId){
        Order order = orderService.findById(orderId).get();
        order.setPaidDate(Instant.now());
        return orderService.save(order);
    }


    @RequestMapping(value="/{Id}", method = RequestMethod.GET)//http method
    public Order getOrderById(@PathVariable("Id") Long id){
        logger.debug("Order:"+ id);
        return orderService.findById(id).get();
    }


}
