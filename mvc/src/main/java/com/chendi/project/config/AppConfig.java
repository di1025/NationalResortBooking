package com.chendi.project.config;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.chendi.project.service.StorageService;
import com.chendi.project.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Bean(name = "sqsAWSProperties")
    public PropertiesFactoryBean getSQSProperties(){
        PropertiesFactoryBean sqsAWSProperties = new PropertiesFactoryBean();
        sqsAWSProperties.setLocation(new ClassPathResource("META-INF/env/sqsAWSProperties.properties"));
        return sqsAWSProperties;
    }

    @Bean(name = "s3AWSProperties")
    public PropertiesFactoryBean getS3Properties(){
        PropertiesFactoryBean s3AWSProperties = new PropertiesFactoryBean();
        s3AWSProperties.setLocation(new ClassPathResource("META-INF/env/s3AWSProperties.properties"));
        return s3AWSProperties;
    }

//    @Value("#{s3AWSProperties['s3.bucketName']}")
//    String bucketName;


    @Bean
    @Profile({"dev","test","stage","prod"})
    public StorageService getStorageService(){
        AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        StorageService storageService = new StorageService(s3);
        storageService.setBucket("nationalparkreservation");
        return storageService;
    }


//    @Bean
//    @Profile({"dev","test","stage","prod"})
//    public MessageSQSService getMessageSQSService(){
//        AmazonSQS sqs= AmazonSQSClientBuilder.defaultClient();
//        MessageSQSService messageSQSService = new MessageSQSService(sqs);
//        messageSQSService.setSqsUrl("https://sqs.us-east-1.amazonaws.com/452279762309/NationalParkReservation-dev");
//        return messageSQSService;
//    }

    @Bean
    @Profile({"dev","test","stage","prod"})
    public AmazonSQS getSQSService(){
        AmazonSQS client = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return client;
    }

}
