package com.microservice.user.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "name" , length = 20)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "about")
    private String about;

    @Transient //This annotation is used if you do not want to save it
    private List<Rating> ratingList= new ArrayList<>();
}
