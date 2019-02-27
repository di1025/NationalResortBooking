package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.Order;
import com.chendi.project.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.config.RepositoryConfigurationSourceSupport;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserRepositoryTest {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
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
        userRepository.save(u);
        Optional<User> testUsers = userRepository.findByPhoneNumber(u.getPhone());
        assertNotNull(testUsers);
        assertEquals(u.getId(),testUsers.get().getId());

    }
    @Test
    @Transactional
    public void findByLastnameOrFirstnameTest(){
        User u = new User();
        u.setEmail("testEmail@test.com");
        u.setFirstName("TestFN");
        u.setLastName("TestLN");
        u.setUsername("TestUserName");
        u.setPhone("88888888");
        userRepository.save(u);
        List<User> testUsers = userRepository.findByLastnameOrFirstname(u.getFirstName(),u.getLastName());
        assertNotNull(testUsers);
        assertEquals(u.getId(),testUsers.get(0).getId());
    }
}





