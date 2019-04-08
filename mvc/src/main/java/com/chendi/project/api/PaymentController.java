package com.chendi.project.api;


import com.chendi.project.domain.Order;
import com.chendi.project.domain.Payment;
import com.chendi.project.service.OrderService;
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

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/{Id}", method= RequestMethod.GET)
    public Payment getPaymentById(@PathVariable("Id") Long id){
        logger.debug("Payment is:"+ id);
        return paymentService.findById(id).get();
    }

    @RequestMapping(value="/order/{Id}", method = RequestMethod.POST)
    public Payment savePayment(@RequestBody Payment payment,@PathVariable("Id") Long orderId){
        logger.debug("Payment is: "+ payment+"Order Id is: "+orderId);
        Order order = orderService.findById(orderId).get();
        payment.setOrder(order);
        return paymentService.save(payment);

    }

    @RequestMapping(method = RequestMethod.GET, params = {"orderId"})
    public List <Payment> getPaymentByOrderId(@RequestParam(value="orderId") Long id){
        return paymentService.findByOrderId(id);
    }

    @RequestMapping(method = RequestMethod.GET, params={"holderFirstName","holderLastName"})
    public List <Payment> getPaymentByFirstNameAndLastName(@RequestParam(value="holderFirstName") String holderFirstName, @RequestParam(value = "holderLastName") String holderLastName){
        return paymentService.findByFirstNameAndLastName(holderFirstName,holderLastName);
    }


    @RequestMapping( method=RequestMethod.GET,params = {"orderId","s"})
    public List<Payment> getPayById(@RequestParam(value="orderId") Long id,@RequestParam(value="s") String s){
        return paymentService.findByOrderId(id);
    }
}