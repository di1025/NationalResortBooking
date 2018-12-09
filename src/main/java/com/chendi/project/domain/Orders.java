package com.chendi.project.domain;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.sql.Date;
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
    Number quantity;
    @Column(name="order_price")
    Number orderPrice;
    @Column(name="payment_id")
    Number paymentId;
    @Column(name="paid_date")
    Date paidDate;
    @Column(name="users_id")
    Long usersId;
    @Column(name="bill_address_id")
    Long billAddressId;




}

