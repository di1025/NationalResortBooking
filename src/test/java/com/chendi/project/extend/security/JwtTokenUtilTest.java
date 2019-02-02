package com.chendi.project.extend.security;

import com.chendi.project.config.AppConfig;
import com.chendi.project.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDevice;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class JwtTokenUtilTest {
    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @Transactional
    @Test
    public void generateTokenTest(){
        User user = new User();
        Device device = new LiteDevice();
        user.setUsername("testusername3");
        user.setPassword("password3");
        System.out.println(jwtTokenUtil.generateToken(user,device));
    }
}
