package com.chendi.project.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;
import java.util.Properties;
@Entity
@Table(name="users")
public class User {
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Id
    private Long id;

    public User(){
    }


}
