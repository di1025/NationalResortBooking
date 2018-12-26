package com.chendi.project.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.sound.midi.Sequence;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="users")
public class User {
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column
    String username;
    @Column
    String email;
    @Column
    String phone;
    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "users_id_seq")
    @SequenceGenerator(name="users_id_seq",sequenceName="users_id_seq")
    private Long id;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> orders;

    public void setUsername(String username){ this.username=username; }
    public String getUsername(){ return this.username; }

    public void setFirstName(String firstname){this.firstName=firstname;}
    public String getFirstName(){ return this.firstName;}

    public void setLastName(String lastname){ this.lastName=lastname;}
    public String getLastName(){return this.lastName;}

    public void setEmail(String email){ this.email=email;}
    public String getEmail(){return this.email;}

    public void setPhone(String phone){ this.phone=phone;}
    public String getPhone(){return this.phone;}


}

//string1.equals(string2)
//int1 == int2