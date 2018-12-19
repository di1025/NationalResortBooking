package com.chendi.project.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity
@Table(name="payments")
public class Payments{
    @Column(name = "card_number")
    Integer cardNumber;
    @Column(name = "card_type")
    String cardType;
    @Column(name = "holder_first_name")
    String holderFristName;
    @Column(name = "holder_last_name")
    String holderLastName;
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "payments_id_seq")
    @SequenceGenerator(name = "payments_id_seq", sequenceName = "payments_id_seq")
    private Long id;
}
