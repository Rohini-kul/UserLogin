package com.mfsa.da.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfsa.da.model.User;
import com.mfsa.da.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Map<String, Boolean>> fetchUserByUserId(String tempUserId) {
        // TODO Auto-generated method stub
          userRepository.findByUserId(tempUserId);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("user with " + tempUserId+ "is alredy exit", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
       
    }


    public User fetchUserByUserIdAndPassword(String tempUserId, String tempPass) {
        // TODO Auto-generated method stub
        return userRepository.findByUserIdAndPassword(tempUserId,tempPass);
   
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("UserID and Password Not exit", Boolean.FALSE);
//        return ResponseEntity.ok(response);
    }


    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

}
