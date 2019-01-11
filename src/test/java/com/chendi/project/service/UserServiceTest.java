package com.chendi.project.service;

import com.chendi.project.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByPhoneNumberTest(){
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPhone("88888888");
        userService.save(u);
        User testUsers = userService.findByPhoneNumber(u.getPhone());
        assertNotNull(testUsers);
        assertEquals(u.getId(),testUsers.getId());

    }
}
