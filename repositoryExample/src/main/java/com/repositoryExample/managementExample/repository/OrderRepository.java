package com.repositoryExample.managementExample.repository;

import com.repositoryExample.managementExample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Bu anotasyon genellikle veritabanı işlemlerini gerçekleştiren,
// sorguları yöneten ve verileri döndüren metotları içerir.
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProductId(Long customerId);

    @Query("SELECT o.customerId from Order o where o.productId = :productId")
    List<Long> findByProductIdJPQL(@Param("productId")Long productID);

}
