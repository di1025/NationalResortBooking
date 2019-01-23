package com.chendi.project.extend.security;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import com.chendi.project.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Transactional
    @Test
    public void loadUserByUsernameTest() {
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPassword("TestPassword");
        u.setPhone("88888888");
        userRepository.save(u);
        UserDetails userDetails = userDetailsService.loadUserByUsername("testEmail@test.com");
        assertEquals(userDetails.getUsername(),"TestUserName");
    }
}