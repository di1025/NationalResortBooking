package com.chendi.project.api;


import com.chendi.project.domain.Order;
import com.chendi.project.domain.User;
import com.chendi.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value={"/api/orders"})
public class OrderController {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private OrderService orderService;
//
//
//    @RequestMapping(value="/newOrder",method=RequestMethod.POST)
//    public Order generateOrder(@RequestBody Order order){
//        return orderService.save(order);
////        return null;
//    }


//    @RequestMapping(value="/{Id}", method = RequestMethod.GET)//http method
//    public Optional<Order> getOrderById(@PathVariable("Id") Long id){
//        logger.debug("Order:"+ id);
////        return orderService.findById(id);
//        return null;
//    }

//    @RequestMapping(method = RequestMethod.GET,params={"orderDate"})
//    public List<Order> getOrderByPurchasedDate(@RequestParam(value="orderDate") Instant orderDate){
//        return orderService.findByPurchasedDate(orderDate);
//    }

}
