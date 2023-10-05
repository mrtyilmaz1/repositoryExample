package com.repositoryExample.managementExample.model;

import com.repositoryExample.managementExample.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter  // lombok
@Setter  // lombok
@Entity  // jakarta
@Table(name = "customer")  // jakarta
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive;

    @Enumerated(EnumType.STRING) /* Enum'dan gelen değerleri sistemde
    hangi veri tipinde tutmak istediğimizi belirtiriz. */
    @Column(name = "gender") //tablodaki isimle aynı oldugu icin koymak zorunda degiliz.
    private GenderEnum genderEnum;

}
