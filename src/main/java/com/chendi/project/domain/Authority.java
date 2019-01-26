package com.chendi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.AuthProvider;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="authorities")
public class Authority implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "authorities_id_seq")
    @SequenceGenerator(name="authorities_id_seq",sequenceName = "authorities_id_seq",allocationSize = 1)
    private Long id;

    @NotNull
    private String authority;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="users_id")
    @JsonIgnore
    private User user;

    public Authority(){}

    public Authority(User user, String authority){
        this.user= user;
        this.authority = authority;
    }

    public Long getId(){return id;}

    public void setAuthority(String authority){this.authority= authority;}

    public String getAuthority() { return authority; }

    public User getUser(){return user;}

}
