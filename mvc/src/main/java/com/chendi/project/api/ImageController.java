package com.chendi.project.api;

import com.chendi.project.domain.Image;
import com.chendi.project.service.ImageService;
import com.chendi.project.service.StorageService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value={"/api/image"})
public class ImageController {

    @Autowired
    public StorageService storageService;

    @Autowired
    public ImageService imageService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.POST,consumes={"multipart/form-data"})
    public Map<String,String> uploadImage(@RequestParam(value="pic")MultipartFile multipartFile)  {
//        if (multipartFile==null||multipartFile.isEmpty()) throw new ServiceException("File must not be null!");
//        String fileName=multipartFile.getOriginalFilename();
//        File convFile=new File(multipartFile.getOriginalFilename());
        Map<String,String> result=new HashMap<>();
        try{
            Image image = imageService.saveUUIDImage(multipartFile);
            result.put("s3_url",image.getUrl().toString());
            result.put("s3_uuid",image.getUuid());
            return result;
        }
        catch(ServiceException e){ //compile exception(not runtime exception)
            logger.error("Upload didn't succeed.",e);
        }
        return null;
    }
//url,s3key(uuid+extension),uuid,bucket,extension,userid
    //twillio
}
