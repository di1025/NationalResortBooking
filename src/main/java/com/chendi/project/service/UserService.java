package com.chendi.project.service;

import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
//        List<User> users = Lists.newArrayList(userRepository.findAll());
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }
}
