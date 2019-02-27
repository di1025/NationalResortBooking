package com.chendi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.omg.CORBA.INTERNAL;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "payments_id_seq")
    @SequenceGenerator(name = "payments_id_seq", sequenceName = "payments_id_seq",allocationSize = 1)
    private Long id;
    @Column(name = "card_number")
    private Integer cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "holder_first_name")
    private String holderFirstName;
    @Column(name = "holder_last_name")
    private String holderLastName;
    @Column(name = "billing_address1")
    private String billingAddress1;
    @Column(name = "billing_address2")
    private String billingAddress2;
    @Column(name="billing_zip_code")
    private Integer billingZipCode;
    @Column(name = "billing_city")
    private String billingCity;
    @Column(name = "billing_state")
    private String billingState;
    @Column(name = "billing_country")
    private String billingCountry;
    @Column(name="billing_phone_number")
    private String billingPhoneNum;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public void setCardNumber(Integer cardNumber){ this.cardNumber=cardNumber;}
    public Integer getCardNumber(){return this.cardNumber;}

    public void setCardType(String cardType){ this.cardType=cardType;}
    public String getcardType(){return this.cardType;}

    public void setHolderFirstName(String holderFirstName){ this.holderFirstName=holderFirstName;}
    public String getHolderFirstName(){return this.holderFirstName;}

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

    public void setOrder(Order order){this.order = order;}
    public Long getOrderId(){return order.getId();}
    public Order getOrder(){return order;}


    public Long getId(){return this.id;}

}
