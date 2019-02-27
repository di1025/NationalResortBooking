package com.chendi.project.repository;

import com.chendi.project.domain.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image,Long> {
    List<Image> findImagesByUser_Id(Long userId);

    List<Image> findImagesByBucket(String bucketName);


}
