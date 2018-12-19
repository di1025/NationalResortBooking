package com.chendi.project.domain;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy =SEQUENCE,generator = "orders_id_seq")
    @SequenceGenerator(name="orders_id_seq",sequenceName="orders_id_seq")
    private Long id;
    @Column(name="order_date")
    Date orderDate;
    @Column
    Integer quantity;
    @Column(name="order_total")
    BigDecimal orderTotal;
    @Column(name="payment_id")
    Long paymentId;
    @Column(name="paid_date")
    Date paidDate;
    @Column(name="users_id")
    Long usersId;
    @Column(name="bill_address_id")
    Long billAddressId;




}

