package com.example.demoJPA.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostalDetailsUserDTO {
    private String address;
    private String city;
    private String phoneNumber;

    public PostalDetailsUserDTO(Customer customer) {
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.phoneNumber = customer.getPhone();
    }
}

