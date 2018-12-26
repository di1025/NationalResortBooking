package com.chendi.project.repository;

import com.chendi.project.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByLastnameOrFirstname(String holderFristName, String holderLastName);

    @Query("select u from users where u.phone =?1")
    List<User> findByPhoneNumber(String phone);



}