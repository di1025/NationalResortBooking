package com.chendi.project.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "payments_id_seq")
    @SequenceGenerator(name = "payments_id_seq", sequenceName = "payments_id_seq")
    private Long id;
    @Column(name = "card_number")
    Integer cardNumber;
    @Column(name = "card_type")
    String cardType;
    @Column(name = "holder_first_name")
    String holderFristName;
    @Column(name = "holder_last_name")
    String holderLastName;
    @Column(name = "billing_address1")
    String billingAddress1;
    @Column(name = "billing_address2")
    String billingAddress2;
    @Column(name="billing_zip_code")
    Integer billingZipCode;
    @Column(name = "billing_city")
    String billingCity;
    @Column(name = "billing_state")
    String billingState;
    @Column(name = "billing_country")
    String billingCountry;
    @Column(name="billing_phone_number")
    String billingPhoneNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public void setCardNumber(Integer cardNumber){ this.cardNumber=cardNumber;}
    public Integer getCardNumber(){return this.cardNumber;}

    public void setCardType(String cardType){ this.cardType=cardType;}
    public String getcardType(){return this.cardType;}

    public void setHolderFristName(String cardType){ this.holderFristName=holderFristName;}
    public String getHolderFristName(){return this.holderFristName;}



}
