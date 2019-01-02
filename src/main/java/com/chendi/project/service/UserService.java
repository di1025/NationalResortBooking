package com.chendi.project.service;

import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
}
