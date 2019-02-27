package com.chendi.project.service;


import com.chendi.project.domain.Image;
import com.chendi.project.repository.ImageRepository;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {
    @Autowired
    public StorageService storageService;

    @Autowired
    public ImageRepository imageRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Image saveUUIDImage(MultipartFile multipartFile) throws ServiceException {
        if (multipartFile==null||multipartFile.isEmpty()) throw new ServiceException("File must not be null!");
        String extension= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String homeDir = System.getProperty("catalina.base") !=null ? System.getProperty("catalina.base") : "/tmp/";
        Image image = new Image();
        String s3Key = FilenameUtils.getBaseName(multipartFile.getOriginalFilename()) + "_" + image.getUuid()+"."+ extension;
        File localFile =new File(homeDir+s3Key);
        try{
            multipartFile.transferTo(localFile);
            storageService.putObject(s3Key,localFile);
            URL url=storageService.getUrl(s3Key);
            image.setUrl(url);
            image.setBucket(storageService.getBucket());//?? if need
            image.setExtension(extension);
            image.setS3Key(s3Key);
            return image;
        }
        catch(IOException e){ //compile exception(not runtime exception)
            logger.warn("can't find image file");
        }
        return null;
    }
}
