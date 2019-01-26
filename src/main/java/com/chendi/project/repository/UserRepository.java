package com.chendi.project.repository;

import com.chendi.project.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();

    Optional<User> findById(Long userId);

    List<User> findByLastName(String lastName);

    @Query("select u from User u where u.firstName=?1 or u.lastName=?2")
    List<User> findByLastnameOrFirstname(String holderFristName, String holderLastName);

    @Query("select u from User u where u.phone =?1")
    Optional <User> findByPhoneNumber(String phone);

    User findByEmailIgnoreCase(String email);

    User findByUsernameIgnoreCase(String username);

}