package com.chendi.project.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.File;
import java.util.List;

public class StorageService {

    public void uploadObject(String keyName, String filePath, String bucketName) {
        System.out.format("Uploading %s to S3 bucket %s...\n", filePath, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            s3.putObject(bucketName, keyName, new File(filePath));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        StorageService s = new StorageService();
        s.uploadObject("test", "/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf", "nationalparkreservation");


        }
    }


