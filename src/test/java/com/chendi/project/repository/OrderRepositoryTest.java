package com.chendi.project.repository;

import com.chendi.project.domain.Order;
import org.junit.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryTest {
//    Optional<Order> findById(Long id);
//
//    @Query("select o from orders where order_date >?1")
//    List<Order> findByPurchasedDate(Date orderDate);
    @Test
    @Transactional
    public void findByIdTest() {
        Order o  = new Order();
//        o.setOrderDate("toyota");
//        c.setoOrderTotal("xle");
        o.setPaidDate(2018,12,26);
//        carRepository.save(c);
//        Optional<Car> testCar = carRepository.findById(c.getId());
//        assertNotNull(testCar);
//        assertEquals(c.getId(),testCar.get().getId());
//    }
}
