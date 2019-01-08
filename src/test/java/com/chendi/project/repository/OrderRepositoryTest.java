package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Order;
import com.chendi.project.domain.Payment;
import com.chendi.project.domain.User;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.hibernate.type.TrueFalseType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Optional;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("unit")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryTest {
//    Optional<Order> findById(Long id);
//
//    @Query("select o from orders where order_date >?1")
//    List<Order> findByPurchasedDate(Instant orderDate);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Order o = new Order();
        Instant paidDate = Instant.now();
        o.setPaidDate(paidDate);
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderRepository.save(o);
        Optional<Order> testOrders = orderRepository.findById(o.getId());
        assertNotNull(testOrders);
        assertEquals(o.getId(),testOrders.get().getId());
    }

    @Test
    @Transactional
    public void findByPurchasedDateTest(){
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderRepository.save(o);
        List<Order> testOrders = orderRepository.findByPurchasedDate(o.getOrderDate());
        assertNotNull(testOrders);
        assertEquals(o.getId(),testOrders.get(0).getId());
    }

    @Test
    @Transactional
    public void findByUserIdTest(){
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPhone("88888888");
        userRepository.save(u);
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        o.setUser(u);
        orderRepository.save(o);
        List<Order> testOrders = orderRepository.findByUserId(u.getId());
        assertNotNull(testOrders);
        assertEquals(o.getId(),testOrders.get(0).getId());
    }

}

