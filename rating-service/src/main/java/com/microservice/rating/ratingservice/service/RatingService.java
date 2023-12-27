package com.microservice.rating.ratingservice.service;

import com.microservice.rating.ratingservice.entity.Rating;
import com.microservice.rating.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public ResponseEntity<?> saveRating(Rating rating) {
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        ratingRepository.save(rating);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllRating() {
        return ResponseEntity.ok(ratingRepository.findAll());
    }

    public ResponseEntity<?> getRatingById(String userId) {
        Optional<Rating> optionalHotel = ratingRepository.findById(userId);
        if (optionalHotel.isPresent()) {
            return ResponseEntity.ok(optionalHotel.get());
        }
        return ResponseEntity.badRequest().body("hotel id is not found");
    }
    public ResponseEntity<?> getRatingByUserId(String userId){
        List<Rating> rating = ratingRepository.findByUserId(userId);
        if (rating.isEmpty()){
            return ResponseEntity.badRequest().body("Rating of hotel is not found");
        }

        return ResponseEntity.ok(rating);
    }
    public ResponseEntity<?> getRatingByHotelId(String hotelId){
        List<Rating> rating = ratingRepository.findByHotelId(hotelId);
        if (rating.isEmpty()){
            return ResponseEntity.badRequest().body("Rating of hotel is not found");
        }

        return ResponseEntity.ok(rating);
    }
}
