package com.chendi.project.api;


import com.chendi.project.domain.Payment;
import com.chendi.project.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value={"/api/payments"})
public class PaymentController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value="/{Id}", method= RequestMethod.GET)
    public Optional<Payment> getPaymentById(@PathVariable("Id") Long id){
        logger.debug("Payment is:");
        return null;
       // return paymentService.findById(id);
    }

    @RequestMapping(value="/savePayment", method = RequestMethod.POST)
    public Payment savePayment(@RequestBody Payment payment){
      //  return paymentService.save(payment);
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"orderId"})
    public List <Payment> getPaymentByOrderId(@RequestParam(value="orderId") Long id){
        return null;
     //   return paymentService.findByOrderId(id);
    }

    @RequestMapping(method = RequestMethod.GET, params={"holderFirstName","holderLastName"})
    public List <Payment> getPaymentByFirstNameAndLastName(@RequestParam(value="holderFirstName") String holderFirstName, @RequestParam(value = "holderLastName") String holderLastName){
        return null;
     //   return paymentService.findByFirstNameAndLastName(holderFirstName,holderLastName);
    }




}
