package com.chendi.project.api;

import com.chendi.project.domain.User;
import com.chendi.project.domain.UserLogin;
import com.chendi.project.extend.security.JwtAuthenticationResponse;
import com.chendi.project.extend.security.JwtTokenUtil;
import com.chendi.project.repository.UserRepository;
import com.chendi.project.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
//    @Qualifier(BeanIds.AUTHENTICATION_MANAGER)
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User generateUser(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,
                             @RequestParam("phone") String phone) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstname);
        newUser.setLastName(lastname);
        newUser.setPhone(phone);
        return userService.createNewUser(newUser);
    }



    @RequestMapping(method = RequestMethod.GET, params = {"lastName"})
    public List<User> getUserByLN(@RequestParam(value = "lastName") String lastName) {
        logger.debug("parameter last name is: " + lastName);
        return userService.findByLastName(lastName);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"phoneNumber"})
    public User getUserByPhoneNumber(@RequestParam(value = "phoneNumber") String phone) {
        logger.debug("parameter phone number is " + phone);
        return userService.findByPhoneNumber(phone);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@RequestBody UserLogin userLogin, Device device) {
        try {
            Authentication notFullyAuthenticated = new UsernamePasswordAuthenticationToken(
                    userLogin.getUsername(),
                    userLogin.getPassword());//用usernamepasswordAuthenticationToken这个class 来创造一个新的instance
//authentication shiyige interface, yong UsernamePasswordAuthenticationToken lai zuo yi ge instance
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);//diao yong zhengge xilie liu cheng, kan zhe ge neng bu neng
//            yong authenticationManager.authenticate() this method to authenticate it: find userDetails and encoder, compare the username and password
            SecurityContextHolder.getContext().setAuthentication(authentication);
//
            try {
                final UserDetails userDetails = userService.findByEmailOrUsername(userLogin.getUsername());
                final String token = jwtTokenUtil.generateToken(userDetails, device);
               return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//    above equals to    JwtAuthenticationResponse jsontoken= new JwtAuthenticationResponse(token);
//                return new ResponseEntity<>(HttpStatus.ok);
            } catch (NotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed, please check your username and password");
        }
    }
}
