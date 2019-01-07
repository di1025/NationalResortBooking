package com.chendi.project.service;

import com.chendi.project.domain.Payment;
import com.chendi.project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }

    public List <Payment> findByOrderId(Long id){
        return paymentRepository.findByOrderId(id);
    }

    public List <Payment> findByFirstNameAndLastName(String holderFirstName, String holderLastName){
        return paymentRepository.findByFirstNameAndLastName( holderFirstName,  holderLastName);
    }

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }
}
