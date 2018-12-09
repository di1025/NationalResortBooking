package com.chendi.project.domain;

import javax.persistence.*;

@Entity
@Table(name="bill_address")
public class BillAddress {
    @Id
    @GeneratedValue(strategy =SEQUENCE,generator = "bill_address_id_seq")
    @SequenceGenerator(name="bill_address_id_seq",sequenceName="bill_address_id_seq")
    private Long id;
    @Column
    String address1;
    @Column
    String address2;
    @Column(name="zip_code")
    Number zipCode;
    @Column
    String city;
    @Column
    String state;
    @Column
    String country;
    @Column(name="phone_number")
    Number phoneNum;

}
