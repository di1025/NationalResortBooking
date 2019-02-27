package com.chendi.project.extend.security;
import com.chendi.project.domain.Authority;
import com.chendi.project.domain.User;
import com.chendi.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    protected MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailorUsername){//used in :1. security config; 2. login controller: authenticationManager.authenticate()
        User domainUser=null;
        try{
            domainUser = userService.findByEmailOrUsername(emailorUsername);
        }catch (Exception repositoryProblem){
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider");
        }
        if (domainUser ==null){
//            throw new BadCredentialsException("AbstractUserDetailsAuthenticationProvider.UsernameNotFound", new Object
        }
        List<Authority> userAuthorities = userService.findAuthorities(domainUser);
        domainUser.setAuthorities(userAuthorities);
        return domainUser;
    }
}