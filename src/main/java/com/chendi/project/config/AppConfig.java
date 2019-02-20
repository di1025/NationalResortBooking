package com.chendi.project.config;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.chendi.project.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.chendi.project", excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="com.chendi.project.api.*"))
public class AppConfig {
    @Autowired
    private Environment environment;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = "applicationProperties")
    public PropertiesFactoryBean getDbProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is "+profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }

    @Bean(name = "shareProperties")
    public PropertiesFactoryBean getTKProperties() {
        PropertiesFactoryBean shareProperties = new PropertiesFactoryBean();
        shareProperties.setLocation(new ClassPathResource("META-INF/shareProperties.properties"));
        return shareProperties;
    }

    @Bean
    @Profile({"dev","test","stage","prod"})
    public StorageService getStorageService(){
        AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        StorageService storageService = new StorageService(s3);
        storageService.setBucket("nationalparkreservation");
        return storageService;
    }

}
