package com.chendi.project.domain;

import org.omg.CORBA.INTERNAL;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

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

    public void setHolderLastName(String holderLastName){ this.holderLastName=holderLastName;}
    public String getHolderLastName(){return this.holderLastName;}

    public void setBillingAddress1(String billingAddress1){ this.billingAddress1=billingAddress1;}
    public String getBillingAddress1(){return this.billingAddress1;}

    public void setBillingAddress2(String billingAddress2){ this.billingAddress2=billingAddress2;}
    public String getBillingAddress2(){return this.billingAddress2;}

    public void setBillingZipCode(Integer billingZipCode){ this.billingZipCode=billingZipCode;}
    public Integer getBillingZipCode(){return this.billingZipCode;}

    public void setBillingCity(String billingCity){ this.billingCity=billingCity;}
    public String getBillingCity(){return this.billingCity;}

    public void setBillingState(String billingState){ this.billingState=billingState;}
    public String getBillingState(){return this.billingState;}

    public void setBillingCountry(String billingCountry){ this.billingCountry=billingCountry;}
    public String getBillingCountry(){return this.billingCountry;}

    public void setBillingPhoneNum(String billingPhoneNum){ this.billingPhoneNum=billingPhoneNum;}
    public String getBillingPhoneNum(){return this.billingPhoneNum;}

    public Order getOrder(){return order;}

}
