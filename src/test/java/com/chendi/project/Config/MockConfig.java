package com.chendi.project.Config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.chendi.project.service.StorageService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class MockConfig {

    @Mock
    private AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Bean
    @Primary
    public StorageService getStorageService(){
        StorageService storageService = new StorageService(client);
        storageService.setBucket("testBucket");
        return storageService;
    }
}
