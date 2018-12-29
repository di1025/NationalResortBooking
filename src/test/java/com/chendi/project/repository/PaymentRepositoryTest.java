package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Order;
import com.chendi.project.domain.Payment;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("unit")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentRepositoryTest {
//    @Query("select p from payments where p.order_id = ?1")
//    List<Payment> findByOrderIdis(Long id);
//
//    List<Payment> findByLastnameAndFirstname(String holderFristName, String holderLastName);

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void findByOrderIdTest() {
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderRepository.save(o);

        Payment p1 = new Payment();
        p1.setBillingAddress1("testBillingAddress1");
        p1.setBillingAddress2("testBillingAddress2");
        p1.setBillingCity("testCity");
        p1.setBillingCountry("testCountry");
        p1.setBillingPhoneNum("88888888");
        p1.setBillingState("testST");
        p1.setBillingZipCode(1000000);
        p1.setCardNumber(123111);
        p1.setCardType("Visa");
        p1.setHolderFirstName("testFN");
        p1.setHolderLastName("testLN");
        p1.setOrder(o);
        paymentRepository.save(p1);

        Payment p2 = new Payment();
        p2.setBillingAddress1("testBillingAddress1111");
        p2.setBillingAddress2("testBillingAddress2222");
        p2.setBillingCity("testCity1");
        p2.setBillingCountry("testCountry1");
        p2.setBillingPhoneNum("999999");
        p2.setBillingState("testST1");
        p2.setBillingZipCode(999999);
        p2.setCardNumber(123222);
        p2.setCardType("Visa");
        p2.setHolderFirstName("testFN");
        p2.setHolderLastName("testLN");
        p2.setOrder(o);
        paymentRepository.save(p2);
        List<Payment> testPayments = paymentRepository.findByOrderId(p1.getOrderId());
        assertNotNull(testPayments);
//        assertEquals(p1.getId(),testPayments.get(0).getId());
        TestCase.assertEquals(testPayments.size(),2);


    }
    @Test
    @Transactional
    public void findByFirstNameAndLastNameTest(){
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderRepository.save(o);

        Payment p = new Payment();
        p.setBillingAddress1("testBillingAddress1");
        p.setBillingAddress2("testBillingAddress2");
        p.setBillingCity("testCity");
        p.setBillingCountry("testCountry");
        p.setBillingPhoneNum("88888888");
        p.setBillingState("testST");
        p.setBillingZipCode(1000000);
        p.setCardNumber(123);
        p.setCardType("Visa");
        p.setHolderFirstName("testFN");
        p.setHolderLastName("testLN");
        p.setOrder(o);
        paymentRepository.save(p);

        List<Payment> testPayments = paymentRepository.findByFirstNameAndLastName(p.getHolderFirstName(),p.getHolderLastName());
        assertNotNull(testPayments);
        assertEquals(p.getId(),testPayments.get(0).getId());
    }
}
