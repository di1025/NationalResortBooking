package com.chendi.project.api;


import com.chendi.project.domain.Payment;
import com.chendi.project.service.jms.MessageSQSService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping(value={"/api/message"})
public class MessageSQSController {

    @Autowired
    public MessageSQSService messageSQSService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method= RequestMethod.POST,params = {"messageBody"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean sendMessageRequest(@RequestParam(value = "messageBody") String messageBody){
//        Map<Long,String> result=new HashMap<>();
        String result;
        try{messageSQSService.sendMessageRequest(messageBody,5);
            result = messageBody;
            return true;
        }
        catch(ServiceException e){ //compile exception(not runtime exception)
            logger.error(" didn't send.",e);
        }
        return null;
    }
}