package com.chendi.project.service;


import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Order;
import com.chendi.project.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByIdTest() {
        Order o = new Order();
        Instant paidDate = Instant.now();
        o.setPaidDate(paidDate);
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderService.save(o);
        Optional<Order> testOrders = orderService.findById(o.getId());
        assertNotNull(testOrders);
        assertEquals(o.getId(), testOrders.get().getId());
    }

    @Test
    @Transactional
    public void findByPurchasedDateTest() {
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        orderService.save(o);
        List<Order> testOrders = orderService.findByPurchasedDate(o.getOrderDate());
        assertNotNull(testOrders);
        assertEquals(o.getId(), testOrders.get(0).getId());
    }

    @Test
    @Transactional
    public void findByUserIdTest() {
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPhone("88888888");
        userService.save(u);
        Order o = new Order();
        o.setPaidDate(Instant.now());
        o.setOrderDate(Instant.now());
        o.setOrderTotal(new BigDecimal("100"));
        o.setQuantity(3);
        o.setUser(u);
        orderService.save(o);
        List<Order> testOrders = orderService.findByUserId(u.getId());
        assertNotNull(testOrders);
        assertEquals(o.getId(), testOrders.get(0).getId());
    }
}
