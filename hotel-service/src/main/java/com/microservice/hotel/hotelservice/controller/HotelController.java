package com.microservice.hotel.hotelservice.controller;

import com.microservice.hotel.hotelservice.entity.Hotel;
import com.microservice.hotel.hotelservice.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelService hotelService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Hotel hotel){
        return hotelService.saveUserDetails(hotel);
    }
    @GetMapping("/getAllHotel")
    public ResponseEntity<?> getAllHotel(){
        return hotelService.getAllHotel();
    }
    @GetMapping("/getHotelById")
    public ResponseEntity<?> getHotelById(@RequestParam(name = "hotelId") String hotelId){
        return hotelService.getHotelById(hotelId);
    }
}
