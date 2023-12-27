package com.microservice.hotel.hotelservice.service;

import com.microservice.hotel.hotelservice.entity.Hotel;
import com.microservice.hotel.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<?> saveUserDetails(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllHotel() {
        return ResponseEntity.ok(hotelRepository.findAll());
    }

    public ResponseEntity<?> getHotelById(String userId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(userId);
        if (optionalHotel.isPresent()) {
            return ResponseEntity.ok(optionalHotel.get());
        }
        return ResponseEntity.badRequest().body("hotel id is not found");
    }

}
