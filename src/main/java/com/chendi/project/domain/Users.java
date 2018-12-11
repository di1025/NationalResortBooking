package com.chendi.project.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.sound.midi.Sequence;
import javax.sql.DataSource;
import java.util.Properties;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="users")
public class Users {
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name="username")
    String username;
    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "users_id_seq")
    @SequenceGenerator(name="users_id_seq",sequenceName="users_id_seq")
    private Long id;


}