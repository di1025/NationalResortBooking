package com.chendi.project.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.chendi.project.service.StorageService;
import com.chendi.project.service.jms.MessageSQSService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class MockConfig {


//    @Mock
    @Bean
    public AmazonS3 mocoS3(){
          AmazonS3 client = Mockito.mock(AmazonS3.class);
          return client;
    }

    @Bean
    public AmazonSQS mockSQS(){
        AmazonSQS client = Mockito.mock(AmazonSQS.class);
        return client;
    }

    @Value("#{sqsAWSProperties['sqs.url']}")
    private String sqsUrl;

    @Bean
    @Profile("unit")
    public MessageSQSService getSQSService(@Autowired AmazonSQS client){
        MessageSQSService messageSQSService = new MessageSQSService(client);
        messageSQSService.setSqsUrl(sqsUrl);
        return messageSQSService;
    }



    @Bean
    @Profile("unit")
    public StorageService getStorageService(@Autowired AmazonS3 client){
        StorageService storageService = new StorageService(client);
        storageService.setBucket("testBucket");
        return storageService;
    }
}
