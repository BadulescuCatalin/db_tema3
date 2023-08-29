package com.example.demoJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Date orderDate;
    private Date shippedDate;
    private String status;
    private String comments;
    @ManyToOne
    Customer customer;
    @OneToMany
    List<OrderDetail> orderDetailList;

}
