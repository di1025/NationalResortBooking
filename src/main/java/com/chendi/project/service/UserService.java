package com.chendi.project.service;

import com.chendi.project.domain.User;
import com.chendi.project.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User findByPhoneNumber(String phone) {
        return userRepository.findByPhoneNumber(phone).get();
    }

    @Transactional
    public User findByEmailOrUsername(String keyword) throws NotFoundException {
        if (keyword == null || "".equals(keyword.trim())){
            throw new NullPointerException("search keyword is null");
        }
        User user = userRepository.findByEmailIgnoreCase(keyword);
        if (user == null) {
            user = userRepository.findByUsernameIgnoreCase(keyword);
        }
        if (user==null){
            throw new NotFoundException("The user is not exist");
        }
        return user;
    }

    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();

    @Transactional
    public User createNewUser(User newUser) {
        String encodedPass = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPass);
        return userRepository.save(newUser);
    }
}
