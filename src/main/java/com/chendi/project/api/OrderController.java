package com.chendi.project.api;


import com.chendi.project.domain.User;
import com.chendi.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value={"/api/order"})
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @RequestMapping( method = RequestMethod.GET)//http method
    public List<User> getUserList() {
        logger.debug("list users");
        return null;
    }
}
