package com.microservice.user.userservice.service;

import com.microservice.user.userservice.entity.Rating;
import com.microservice.user.userservice.entity.User;
import com.microservice.user.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> saveUserDetails(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        user.setName(user.getName());
        user.setAbout(user.getAbout());
        user.setEmail(user.getEmail());
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<?> getUserById(String userId) {
//        localhost:8082/api/rating/getRatingByUserId?userId=24acfa49-8288-4aea-a871-1acab6f4a7f7
        Optional<User> optionalUser = userRepository.findById(userId);  //db call
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            ArrayList<Rating> ratingArrayList=restTemplate.getForObject("http://localhost:8082/api/rating/getRatingByUserId?userId="+user.getUserId(), ArrayList.class);
            user.setRatingList(ratingArrayList);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("user id is not found");
    }
}
