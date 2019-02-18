package com.chendi.project.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.chendi.project.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class StorageServiceTest {
//    public AmazonS3 s3;
    public String keyName = "unittestfile";
    public String testBucket;// test bukect name

    @Autowired
    private StorageService storageService;

    private AmazonS3 client = Mockito.mock(AmazonS3.class);



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

    @Test
    @Transactional
    public void uploadObjectTest(){
        File file = new File("/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf");
        storageService.putObject(testBucket,keyName,file);
        verify(client,times(1));
//        storageService.putObject(testBucket,null,file);
//        verify(client,times(1));
    }
}
