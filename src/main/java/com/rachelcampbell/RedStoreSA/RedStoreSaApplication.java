package com.rachelcampbell.RedStoreSA;

import com.rachelcampbell.RedStoreSA.Model.Product;
import com.rachelcampbell.RedStoreSA.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RedStoreSaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedStoreSaApplication.class, args);
	}

	// There are several ways that you can get information to persist to a database so that it is already there.
	// You can have an admin have access on the front end to be able to load new products into the system.
	// You can utilize a data.sql and schema.sql file as well
	// I chose this route as I was not looking to load a tremendous amaount of products into my database.

	@Bean
	public CommandLineRunner cmd (ProductRepository productRepo) {
		return args -> {
			Product p = new Product(1, "Mi Smart Band 4", "Accessories" , "Peak fitness tech – the High-End Fitness Tracker Watch. Beyond timekeeping, it seamlessly enhances your active life.", 275.00, 0 , "images/exclusive.png");
			productRepo.save(p);
			p = new Product(2, "Printed Red T-Shirt", "Clothing", "Sizes for everyone. Red Printed T-Shirt combines comfort and style. Elevate fashion with lasting quality, redefining sophistication.", 35.00, 0 , "images/product-1.jpg");
			productRepo.save(p);
			p = new Product(3, "Black Cross Trainer Sneakers", "Shoes", "Elevate training with precision Black Cross Training Sneakers. Innovation meets style, responsive cushioning, superior traction for intense workouts.", 95.00, 0,  "images/product-2.jpg");
			productRepo.save(p);
			p = new Product(4, "Gray Athletic Pants", "Clothing", "Comfort and style in Gray Athletic Pants. Crafted for an active wardrobe with cozy fabric. Gym or casual day, ergonomic design for adaptable style.",  65.00, 0, "images/product-3.jpg");
			productRepo.save(p);
			p = new Product(5, "Navy Blue Polo Shirt","Clothing",  "Casual elegance blending style and breathability. Make a timeless statement in charm and comfort.",  50.00, 0,  "images/product-4.jpg");
			productRepo.save(p);
			p = new Product(6, "Gray High Top Sneakers", "Shoes", "Urban style Gray High Top Sneakers with  a sleek gray, high-top silhouette that bridges casual and chic. Comfortable and durable for everyday wear.",  125.00, 0,  "images/product-5.jpg");
			productRepo.save(p);
			p = new Product(7, "Black Printed T-Shirt", "Clothing", "Explore casual cool with our Black Printed T-Shirt. Merging classic and contemporary for soft touch, making a bold statement.",  30.00, 0,  "images/product-6.jpg");
			productRepo.save(p);
			p = new Product(8, "Athletic Ankle Socks", "Clothing",  "Elevate comfort with 3-Pack Athletic Ankle Socks. Cushioned soles, moisture-wicking for superior comfort. Embrace functionality and comfort.",  15.00, 0, "images/product-7.jpg");
			productRepo.save(p);
			p = new Product(9, "Sleek Black Watch", "Accessories",  "Embrace timeless sophistication with Sleek Black Watch. Crafted for understated elegance, modern minimalism personified.", 375.00, 0 , "images/product-8.jpg");
			productRepo.save(p);
			p = new Product(10, "High Performance Modern Watch", "Accessories", "Embrace watch innovation with High-Performance Modern Watch. Fusing tech and sleek design, each detail exudes sophistication and function.", 325.00, 0 , "images/product-9.jpg");
			productRepo.save(p);
			p = new Product(11, "Gray Slide-On Sneakers", "Shoes",  "Experience comfort and style with Gray Slide-On Sneakers. Seamlessly blending relaxation and sophistication, redefine modern comfort. ",  75.00, 0, "images/product-11.jpg");
			productRepo.save(p);
			p = new Product(12, "Black Athletic Pants", "Clothing", "Discover peak comfort and style with Black Athletic Jogger Pants redefining casual wear. Elevate leisure with contemporary style.",  50.00, 0, "images/product-12.jpg");
			productRepo.save(p);

		};
	}

}
