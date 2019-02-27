package com.chendi.project.service;


import com.chendi.project.domain.Authority;
import com.chendi.project.domain.User;
import com.chendi.project.repository.AuthorityRepository;
import com.chendi.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    public  List<Authority> findAuthoritiesByUserId(Long userId){return authorityRepository.findAuthoritiesByUserId(userId);}

    public List<User> findUsersByAuthority(String authority){ return authorityRepository.findUsersByAuthority(authority);}

//    public void addAuthority(Collection<? extends GrantedAuthority> authorities, Long userId){ userRepository.findById(userId).get().setAuthorities(authorities);}

}
