package com.repositoryExample.managementExample.repository;

import com.repositoryExample.managementExample.enums.ProductEnum;
import com.repositoryExample.managementExample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> /*Long kullanma sebebimiz auto-increment */{

    Optional<Product> findByProductName(ProductEnum productName);

}
