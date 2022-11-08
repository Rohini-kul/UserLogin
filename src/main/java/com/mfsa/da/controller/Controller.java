package com.mfsa.da.controller;

import java.util.List;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfsa.da.model.User;
import com.mfsa.da.service.UserService;


@RestController
@RequestMapping("/api/v1/")
public class Controller {
    @Autowired
    private  UserService  userService;
    
    @PostMapping("/user")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempUserId=user.getUserId();
        if(tempUserId != null && !"".equals(tempUserId)) {
            ResponseEntity<Map<String, Boolean>> userObj=userService.fetchUserByUserId(tempUserId);
            
            if(userObj != null) {
                System.out.println("user with " + tempUserId+ "is alredy exist");
            }
        }
        
        User userObj= null;
        userObj= userService.saveUser(user);
        return userObj;
    }
    
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempUserId=user.getUserId();
        String tempPass=user.getPassword();
       
        User userObj=null;
        if( tempUserId != null && tempPass != null ) {
            userObj=userService.fetchUserByUserIdAndPassword(tempUserId, tempPass);
            
        }
        if(userObj == null) {
            
            System.out.println("UserID and Password Not exist ");
        }
        return userObj;
        
    }
    
    @GetMapping("/all")  
    private List<User> getAllUser()   
    {  
    return userService.getAllUser();  
    }  
      

}
