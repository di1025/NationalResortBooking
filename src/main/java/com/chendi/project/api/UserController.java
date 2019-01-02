package com.chendi.project.api;

import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import com.chendi.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value={"/api/users","/api/user"}) // url specification
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)//http method
    public List<User> getUserList() {
        logger.debug("list users");
        return userService.findAll();
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET) //get request
    public User getUserById(@PathVariable("Id") Long userId) {
        logger.debug("list users by id:" + userId);
        return userService.findById(userId);
    }

    @RequestMapping(method=RequestMethod.POST)
    public User generateUser(@RequestBody User user) {
        return userService.save(user);
    }

}
