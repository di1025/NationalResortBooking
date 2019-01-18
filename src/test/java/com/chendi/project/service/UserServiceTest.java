package com.chendi.project.service;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findByPhoneNumberTest(){
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPhone("88888888");
        userService.createNewUser(u);
        User testUsers = userService.findByPhoneNumber(u.getPhone());
        assertNotNull(testUsers);
        assertEquals(u.getId(),testUsers.getId());
    }
    @Test
    @Transactional
    public void findByEmailOrUsernameTest()throws NotFoundException {
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPassword("TestPassword");
        u.setPhone("88888888");
        userService.createNewUser(u);
        User testUsers = userService.findByEmailOrUsername(u.getEmail());
        assertEquals(u.getId(),testUsers.getId());
    }


    @Test
    @Transactional
    public void createNewUserTest(){
        String password = "TestPassword";
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPassword(password);
        u.setPhone("88888888");
        userRepository.save(u);
        User testUser = userService.createNewUser(u);
        assertNotEquals(password,testUser.getPassword());
        assertEquals(u.getPassword(),testUser.getPassword());
    }
}
