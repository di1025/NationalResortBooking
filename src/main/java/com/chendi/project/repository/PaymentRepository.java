package com.chendi.project.repository;

import com.chendi.project.domain.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment,Long> {
    @Query("select p from payments where p.order_id = ?1")
    List<Payment> findByOrderIdis(Long id);

    List<Payment> findByLastnameAndFirstname(String holderFristName, String holderLastName);
}
