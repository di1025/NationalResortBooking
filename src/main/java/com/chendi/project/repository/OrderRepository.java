package com.chendi.project.repository;

import com.chendi.project.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
//@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    Optional<Order> findById(Long id);

    @Query("select o from Order o where o.orderDate =?1")
    List<Order> findByPurchasedDate(Instant orderDate);
}
