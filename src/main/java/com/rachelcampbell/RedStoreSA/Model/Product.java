package com.rachelcampbell.RedStoreSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // primary key
    private String name; // name of item (will not be unique)
    private String dept; // (clothing, shoes, or accessories)
    private String description; // description of the product
    private Double price; // price per item
    private int quantity; // number of units in cart, default will be 0
    private String img; // image of the item as found in the resources/static/images

    public void incrementQuantity(){
        this.quantity ++;
    }

    public void decrementQuantity(){
        this.quantity --;
    }



    public Product(int id, String name, String dept, String description, Double price, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
    }
}


