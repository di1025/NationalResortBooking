package com.chendi.project.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.File;
import java.util.List;

public class StorageService {
    public AmazonS3 s3;
    public String bucket;

    public StorageService(AmazonS3 s3){};
    public StorageService(){};

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

    public void putObject(String S3key,File file){
        s3.putObject(bucket,S3key,file);
    }

    public void putObject(String bucket,String S3key,File file){
        s3.putObject(bucket,S3key,file);
    }

    public S3Object getObject(String S3key){
        if(S3key==null) return null;
        else return s3.getObject(bucket,S3key);
    }

    public S3Object getObject(String bucket, String S3key){
        if(S3key==null) return null;
        else return s3.getObject(bucket,S3key);
    }

    public void setBucket(String bucket){
        this.bucket=bucket;
    }

//    public static void main(String[] args) {
////        StorageService s = new StorageService();
////        s.uploadObject("test", "/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf", "nationalparkreservation");
////        }
    }


