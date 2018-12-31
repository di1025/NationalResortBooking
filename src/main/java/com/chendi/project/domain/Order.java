package com.chendi.project.domain;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy =SEQUENCE,generator = "orders_id_seq")
    @SequenceGenerator(name="orders_id_seq",sequenceName="orders_id_seq",allocationSize=1)
    private Long id;
    @Column(name="order_date")
    private Instant orderDate;
    @Column
    private Integer quantity;
    @Column(name="order_total")
    private BigDecimal orderTotal;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
//    @Column(name="payment_id")
    private List<Payment> payments;
    @Column(name="paid_date")
    private Instant paidDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;

    public void setOrderDate(Instant orderDate){ this.orderDate=orderDate;}
    public Instant getOrderDate(){return this.orderDate;}

    public void setOrderTotal(BigDecimal orderTotal){ this.orderTotal=orderTotal;}
    public BigDecimal getOrderTotal(){return this.orderTotal;}

    public void setPaidDate(Instant paidDate){ this.paidDate=paidDate;}
    public Instant getPaidDate(){return this.paidDate;}

    public void setQuantity(Integer quantity){this.quantity=quantity;}
    public Integer getQuantity(){return this.quantity;}

    public List<Payment> getPayments(){return payments;}

    public User getUser(){return this.user;}

    public Long getId(){return this.id;}





}

