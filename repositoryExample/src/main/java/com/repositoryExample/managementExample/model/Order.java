package com.repositoryExample.managementExample.model;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ifadesi, anahtar değerlerinin otomatik olarak oluşturulmasını sağlar.
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;

    private double price;



}
