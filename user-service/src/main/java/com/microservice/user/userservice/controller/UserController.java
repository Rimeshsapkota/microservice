package com.microservice.user.userservice.controller;

import com.microservice.user.userservice.entity.User;
import com.microservice.user.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user){
        return userService.saveUserDetails(user);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUser();
    }
    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam(name = "userId") String userId){
        return userService.getUserById(userId);
    }

}
