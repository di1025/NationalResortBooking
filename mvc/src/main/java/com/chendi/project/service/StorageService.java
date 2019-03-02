package com.chendi.project.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.List;

public class StorageService {
    public AmazonS3 s3;
    public String bucket;
    public Logger logger;

    public StorageService(AmazonS3 s3){this.s3=s3;}
    public StorageService(){};

    public void uploadObject(String keyName, String filePath, String bucketName) {
        System.out.format("Uploading %s to S3 bucket %s...\n", filePath, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            s3.putObject(bucketName, keyName, new File(filePath));
        } catch (AmazonServiceException e) {
            logger.error("upload didn't succeed");
            System.exit(1);
        }
    }

    public void putObject(String S3key,File file){
        if(S3key !=null) {
            s3.putObject(bucket, S3key, file);
        }
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

    public String getBucket(){return bucket;}

    public ObjectListing listObject(String bucket){
        if(bucket==null) return null;
        else return s3.listObjects(bucket);
    }

    public ObjectListing listObject(){
        if(bucket==null) return null;
        else return s3.listObjects(bucket);
    }


    public void deleteObject(String bucket,String S3key){
        if(bucket!=null&&S3key!=null)
         s3.deleteObject(bucket,S3key);
    }

    public void deleteObject(String S3key){
        if(bucket!=null&&S3key!=null)
            s3.deleteObject(bucket,S3key);
    }

    public URL getUrl(String S3key) {
        if(S3key==null)return null;
        else
            return s3.getUrl(bucket, S3key);

    }



//    public static void main(String[] args) {
////        StorageService s = new StorageService();
////        s.uploadObject("test", "/Users/DiChen/Desktop/Interview Tech Examples.pdf.pdf", "nationalparkreservation");
////        }
    }


