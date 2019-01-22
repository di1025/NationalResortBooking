package com.chendi.project.extend.security;

import com.chendi.project.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Transactional
    @Test
    public void loadUserByUsernameTest() {
        UserDetails userDetails = userDetailsService.loadUserByUsername("");
        assertEquals(userDetails.getUsername(),"");
    }

}