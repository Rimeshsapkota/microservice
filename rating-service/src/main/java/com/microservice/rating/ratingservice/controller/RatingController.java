package com.microservice.rating.ratingservice.controller;

import com.microservice.rating.ratingservice.entity.Rating;
import com.microservice.rating.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rating")
public class RatingController {
    private final RatingService ratingService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }
    @GetMapping("/getAllRating")
    public ResponseEntity<?> getAllRating(){
        return ratingService.getAllRating();
    }
    @GetMapping("/getRatingById")
    public ResponseEntity<?> getRatingById(@RequestParam(name = "ratingId") String ratingId){
        return ratingService.getRatingById(ratingId);
    }
    @GetMapping("/getRatingByUserId")
    public ResponseEntity<?> getRatingByUserId(@RequestParam(name = "userId") String userId){
        return ratingService.getRatingByUserId(userId);
    }
    @GetMapping("/getRatingByHotelId")
    public ResponseEntity<?> getRatingByHotelId(@RequestParam(name = "hotelId") String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }

}
