package com.example.demoJPA.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String lastName;
    private String firstName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    @OneToMany
    List<Payment> payments;
    @OneToMany
    List<Order> orders;
}

