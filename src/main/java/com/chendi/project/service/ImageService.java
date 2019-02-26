package com.chendi.project.service;


import com.chendi.project.domain.Image;
import com.chendi.project.repository.ImageRepository;
import org.hibernate.service.spi.ServiceException;
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

    public Image saveUUIDImage(MultipartFile multipartFile) {
//        if (multipartFile==null||multipartFile.isEmpty()) throw new ServiceException("File must not be null!")
//        String fileName=multipartFile.getOriginalFilename();
//        File convFile=new File(multipartFile.getOriginalFilename());
//        Map<String,URL> result=new HashMap<>();
//        try{
//            multipartFile.transferTo(convFile);
//            storageService.putObject(fileName,convFile);
//            URL url=storageService.getUrl(fileName);
//            result.put("s3_url",url);
//            result.put("s3_uuid",s3)
//            return result;
//        }
//        catch(IOException e){ //compile exception(not runtime exception)
//            logger.error("Upload didn't succeed.",e);
//        }
        return null;
    }
}
