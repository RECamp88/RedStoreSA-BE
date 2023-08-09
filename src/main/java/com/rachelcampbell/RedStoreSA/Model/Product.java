package com.rachelcampbell.RedStoreSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // primary key
    private String name; // name of item (will not be unique)
    private String dept; // (clothing, shoes, or accessories)
    private String type; // (tshirt, polo, athletic pants, shoes, watch, fitness tracker, etc)
    private String description; // description of the product
    private String size; // each record will reflect a particular size
    private Double price; // price per item
    private int quantity; // number of units in cart, default will be 0
    private String img; // image of the item as found in the resources/static/images

    public void incrementQuantity(){
        this.quantity ++;
    }

    public void decrementQuantity(){
        this.quantity --;
    }



}


