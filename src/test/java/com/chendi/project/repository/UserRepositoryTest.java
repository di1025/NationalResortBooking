package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
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

import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserRepositoryTest {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    private UserRepository userRepository;
//    @Test
////    @Transactional
//    public void findByIdTest() {
//        logger.debug("run findByIdTest");
//        assertTrue(false);
//    }
}





