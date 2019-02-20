package com.chendi.project.api;

import com.chendi.project.service.StorageService;
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




    @RequestMapping(method = RequestMethod.POST,consumes={"multipart/form-data"})
    public Map<String,URL> uploadImage(@RequestParam(value="pic")MultipartFile multipartFile) throws IOException {
        String fileName=multipartFile.getOriginalFilename();
        File convFile=new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(convFile);
        storageService.putObject(fileName,convFile);
        URL url=storageService.getUrl(fileName);
        Map<String,URL> result=new HashMap<>();
        result.put("s3_url",url);
        return result;
    }




}
