package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("unit")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentRepositoryTest {
////    @Query("select p from payments where p.order_id = ?1")
////    List<Payment> findByOrderIdis(Long id);
////
////    List<Payment> findByLastnameAndFirstname(String holderFristName, String holderLastName);
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Test
//    @Transactional
//    public void findByOrderIdis() {
//        Payment p = new Payment();
//    }
}
