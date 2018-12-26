package com.chendi.project.repository;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.User;
import org.junit.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.config.RepositoryConfigurationSourceSupport;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@WebAppConfiguration
@ActiveProfiles("unit")
@ContextConfiguration(classes = {AppConfig.class})
public class UserRepositoryTest {
//    @Test
//    @Transactional
//    public void findByIdTest() {
//        User c = new User();
//        c.setBrand("toyota");
//        c.setModel("xle");
//        carRepository.save(c);
//        Optional<Car> testCar = carRepository.findById(c.getId());
//        assertNotNull(testCar);
//        assertEquals(c.getId(),testCar.get().getId());
//    }
}





