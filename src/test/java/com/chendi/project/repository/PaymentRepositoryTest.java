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
//    @Query("select p from payments where p.order_id = ?1")
//    List<Payment> findByOrderIdis(Long id);
//
//    List<Payment> findByLastnameAndFirstname(String holderFristName, String holderLastName);

    @Autowired
    private PaymentRepository paymentRepository;

//    @Test
//    @Transactional
//    public void findByOrderIdTest() {
//        Payment p = new Payment();
//        p.setBillingAddress1("testBillingAddress1");
//        p.setBillingAddress2("testBillingAddress2");
//        p.setBillingCity("testCity");
//        p.setBillingCountry("testCountry");
//        p.setBillingPhoneNum("88888888");
//        p.setBillingState("testST");
//        p.setBillingZipCode(1000000);
//        p.setCardNumber(123);
//        p.setCardType("Visa");
//        p.setHolderFristName("testFN");
//        p.setHolderLastName("testLN");
//        paymentRepository.save(p);
//        List<Payment> testPayments = paymentRepository.findByOrderId(p.getOrderId());
//        assertNotNull(testPayments);
//        assertEquals(p.getId(),testPayments.get(0).getId())
//
//---order is null so cant pass. orderid is fk, how to retrieve?
//
//    }
    @Test
    @Transactional
    public void findByFirstNameAndLastNameTest(){
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
        paymentRepository.save(p);
        List<Payment> testPayments = paymentRepository.findByFirstNameAndLastName(p.getHolderFirstName(),p.getHolderLastName());
        assertNotNull(testPayments);
        assertEquals(p.getId(),testPayments.get(0).getId());
        //---order is null so cant pass. orderid is fk, how to retrieve?
    }
}
