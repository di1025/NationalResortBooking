package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Order;
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
import java.util.Optional;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;


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

}

