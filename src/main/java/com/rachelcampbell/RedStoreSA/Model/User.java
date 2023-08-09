package com.rachelcampbell.RedStoreSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
   private Long id;

   @Column(nullable = false)
   private String firstname;

   @Column(nullable = false)
   private String lastname;

   private String shipping_address;
   private String billing_address;
   private String phone;
   private Double balance;

   @OneToOne(fetch = FetchType.EAGER)
   @JsonBackReference
   @JoinColumn(name="login_id")
   private Login login;

   @OneToMany
   public List<Product> cart;
}
