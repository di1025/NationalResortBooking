package com.chendi.project.repository;

import com.chendi.project.domain.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {

//    @Query("select p from Payment p where p.order = ?1")
//    List<Payment> findByOrderId(Long id);
    @Query("select p from Payment p where p.holderFirstName=?1 and p.holderLastName=?2")
    List<Payment> findByFirstNameAndLastName(String holderFirstName, String holderLastName);
}
