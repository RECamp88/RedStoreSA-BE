package com.rachelcampbell.RedStoreSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String firstname;

   @Column(nullable = false)
   private String lastname;

   @Column(nullable = false, unique = true)
   private String email;

   @Column(nullable = false)
   private String password;

   private String shipping_address;
   private String billing_address;
   private String phone;
   private Double balance;

   @OneToMany
   @JsonManagedReference
   public List<Product> cart;
}
