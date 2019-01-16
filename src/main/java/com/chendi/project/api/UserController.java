package com.chendi.project.api;

import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import com.chendi.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value={"/api/users"}) // url specification
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

    @RequestMapping(value="/signup", method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
    public User generateUser( @RequestBody User user)
// @RequestParam("s_username") String username,@RequestParam("s_email") String email,
//                             @RequestParam("s_password") String password,
//                             @RequestParam("s_firstname", required= false) String firstname,
//                             @RequestParam("s_lastname", required = false) String lastname)
    {
//        User newUser = new User();
//        newUser.setUsername(username);
//        newUser.setEmail(email);
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.GET,params={"lastName"})
    public List<User> getUserByLN(@RequestParam(value="lastName") String lastName ){
        logger.debug("parameter last name is: "+lastName);
        return userService.findByLastName(lastName);
    }

    @RequestMapping(method=RequestMethod.GET,params = {"phoneNumber"})
    public User getUserByPhoneNumber(@RequestParam(value="phoneNumber") String phone){
        logger.debug("parameter phone number is "+phone);
        return userService.findByPhoneNumber(phone);
    }

    @RequestMapping(value="/login",method = RequestMethod.POST,params = {"username","password"})
    public void userLogin(@RequestParam(value="username") String username, String password){
//        User user = new User();
        logger.debug("user info is: "+username + password);

    }


}
