package com.repositoryExample.managementExample.repository;

import com.repositoryExample.managementExample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer , Long> {

    Optional<Customer> findByFirstName(String firsName);

    @Query("SELECT c FROM Customer c WHERE c.firstName = :firsName")
    Optional<Customer> findByFirstNameJPQL (@Param("firstName") String firstName);

    //JPQL: JPQL, Java nesnelerine dayalıdır ve sorgular,
    // Java sınıfları ve alanları üzerinde çalışır. Bu nedenle,
    // JPQL sorguları, sınıfların ve alanların isimlerini kullanır ve tip güvenliğine sahiptir.

    @Query(value = "select * FROM Customer c where c.firstName = :firstName" , nativeQuery = true)
    Optional<Customer> findByFirstNameNative (@Param("firstName") String firstName );
    //Spring Data JPA'da "nativeQuery = true" seçeneği kullanıldığında,
    // geliştiriciye SQL sorgularını doğrudan yazma ve çalıştırma yeteneği verilir.



}
