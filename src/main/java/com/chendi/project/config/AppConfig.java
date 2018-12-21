package com.chendi.project.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.chendi.project")
public class AppConfig {
    @Autowired
    private Environment environment;
    @Bean(name = "applicationProperties")
    public PropertiesFactoryBean getDbProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
//        logger.debug("applicationProperties is "+profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }

}
