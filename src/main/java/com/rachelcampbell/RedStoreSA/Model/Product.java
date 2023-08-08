package com.rachelcampbell.RedStoreSA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id; // primary key
    private String name; // name of item (will not be unique)
    private String dept; // (clothing, shoes, or accessories)
    private String type; // (tshirt, polo, athletic pants, shoes, watch, fitness tracker, etc)
    private String description; // description of the product
    private String size; // each record will reflect a particular size
    private Double price; // price per item
    private int quantity; // number of units in stock, default will be 25
    private String img; // image of the item as found in the resources/static/images

    public void incrementQuantity(){
        this.quantity ++;
    }

    public void decrementQuantity(){
        this.quantity --;
    }
}


