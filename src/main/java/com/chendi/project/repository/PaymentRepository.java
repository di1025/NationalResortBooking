package com.chendi.project.repository;

import com.chendi.project.domain.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {

    Optional <Payment> findById(Long id);

    @Query("select p from Payment p LEFT JOIN FETCH p.order where p.order.id = ?1")
    List<Payment> findByOrderId(Long id);

    @Query("select p from Payment p where p.holderFirstName=?1 and p.holderLastName=?2")
    List<Payment> findByFirstNameAndLastName(String holderFirstName, String holderLastName);

}
