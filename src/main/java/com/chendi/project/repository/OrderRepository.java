package com.chendi.project.repository;

import com.chendi.project.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Long> {

    Optional<Order> findById(Long id);

    @Query("select o from orders where order_date >?1")
    List<Order> findByPurchasedDate(Date orderDate);
}
