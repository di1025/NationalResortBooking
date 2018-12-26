package com.chendi.project.domain;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
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
    Date orderDate;
    @Column
    Integer quantity;
    @Column(name="order_total")
    BigDecimal orderTotal;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
//    @Column(name="payment_id")
    private List<Payment> payments;
    @Column(name="paid_date")
    Date paidDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;

    public void setOrderDate(Date orderDate){ this.orderDate=orderDate;}
    public Date getOrderDate(){return this.orderDate;}

    public void setoOrderTotal(BigDecimal orderTotal){ this.orderTotal=orderTotal;}
    public BigDecimal getOrderTotal(){return this.orderTotal;}

    public void setPaidDate(Date paidDate){ this.paidDate=paidDate;}
    public Date getPaidDate(){return this.paidDate;}



}

