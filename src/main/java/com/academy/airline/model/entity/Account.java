package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;
    @Column(name = "user_name")
    String userName;
    @Column(name = "password")
    String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    Discount discount;
}
