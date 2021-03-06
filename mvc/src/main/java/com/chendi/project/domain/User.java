package com.chendi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.sound.midi.Sequence;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="users")
public class User implements UserDetails {
    @Column(name="first_name")
    @NotNull
    private String firstName;

    @Column(name="last_name")
    @NotNull
    private String lastName;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;
//    @Column
//    private Instant lastResetAt;

    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "users_id_seq")
    @SequenceGenerator(name="users_id_seq",sequenceName="users_id_seq",allocationSize = 1)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)//mappedBy the join columns in the ordertable
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> images;

    @Transient
    @JsonIgnore
    //@OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<? extends GrantedAuthority> authorities;


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

    public void setPassword(String password){ this.password=password;}
    public String getPassword(){return this.password;}

    public List<Order> getOrders() { return orders; }

//    public void setLastResetAt(Instant lastResetAt) { this.lastResetAt = lastResetAt; }

//    public Instant getLastResetAt() { return lastResetAt; }

    public Long getId(){return this.id;}

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired(){return true;}
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked(){return true;}
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired(){return true;}
    @JsonIgnore
    @Override
    public boolean isEnabled(){return true;}

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}

