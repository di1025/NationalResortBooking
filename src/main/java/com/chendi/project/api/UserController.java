package com.chendi.project.api;

import com.chendi.project.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value={"/api/users","/api/user"})
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method= RequestMethod.GET)
    public List<User> getUserList(){
        logger.debug("list users");
        return new ArrayList<User>();
    }
}

