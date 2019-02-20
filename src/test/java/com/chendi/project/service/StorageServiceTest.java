package com.chendi.project.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.chendi.project.config.AppConfig;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class StorageServiceTest {
    public String keyName = "unittestfile";

    public String testBucket="testBucket";// test bukect name

//    @InjectMocks
    @Autowired
    private StorageService storageService;

    @Autowired
    public AmazonS3 client;


//if dont use MocoCofig, then use code below to replace MocoConfig

//    @Before
//    public void setUp() throws Exception{
//        MockitoAnnotations.initMocks(this);
//    }
//    @After
//    public void tearDown() throws Exception{
//        validateMockitoUsage();
//    }



// test method one
//    @Test
//    @Transactional
//    public void uploadObjectTest() {
//        StorageService s = new StorageService();
//        s.uploadObject(keyName,"/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf","nationalparkreservation");
//        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
//        ListObjectsV2Result result = s3.listObjectsV2("nationalparkreservation");
//        List<S3ObjectSummary> objects = result.getObjectSummaries();
//        for (S3ObjectSummary os: objects) {
//            if(keyName.equals(os.getKey())) {assertEquals(keyName,os.getKey());}
//        }
//    }


//    test method two
    @Test
    public void uploadObjectTest(){
        File file = new File("/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf");
        storageService.putObject(keyName,file);
        verify(client,times(1)).putObject(testBucket,keyName,file);
        storageService.putObject(testBucket,null,file);
        verify(client,times(1)).putObject(testBucket,keyName,file);
    }

    @Test
    public void deleteObjectTest(){
        storageService.deleteObject(keyName);
        verify(client,times(1)).deleteObject(testBucket,keyName);
        storageService.deleteObject(null);
        verify(client,times(1));
    }


}
