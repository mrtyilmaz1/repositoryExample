package com.repositoryExample.managementExample.model;

import com.repositoryExample.managementExample.enums.ProductEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_name")
    private ProductEnum productName;

    private double price;



}
