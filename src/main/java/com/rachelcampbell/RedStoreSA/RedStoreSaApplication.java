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
			Product p = new Product(1, "Fitness Tracker", "Accessories", "Watch", "Peak fitness tech – the High-End Fitness Tracker Watch. Beyond timekeeping, it seamlessly enhances your active life.", null, 275.00, 25 , "images/exclusive.png");
			productRepo.save(p);
			p = new Product(2, "Printed Red T-Shirt", "Clothing", "T-Shirt", "Sizes for everyone. Red Printed T-Shirt combines comfort and style. Elevate fashion with lasting quality, redefining sophistication.", "M", 35.00, 25 , "images/product-1.jpg");
			productRepo.save(p);
			p = new Product(3, "Printed Red T-Shirt", "Clothing", "T-Shirt", "Sizes for everyone. Red Printed T-Shirt combines comfort and style. Elevate fashion with lasting quality, redefining sophistication.", "L", 35.00, 25 , "images/product-1.jpg");
			productRepo.save(p);
			p = new Product(4, "Printed Red T-Shirt", "Clothing", "T-Shirt", "Sizes for everyone. Red Printed T-Shirt combines comfort and style. Elevate fashion with lasting quality, redefining sophistication.", "XL", 35.00, 25 , "images/product-1.jpg");
			productRepo.save(p);
			p = new Product(5, "Printed Red T-Shirt", "Clothing", "T-Shirt", "Sizes for everyone. Red Printed T-Shirt combines comfort and style. Elevate fashion with lasting quality, redefining sophistication.", "2XL", 35.00, 25 , "images/product-1.jpg");
			productRepo.save(p);
			p = new Product(6, "Black Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with precision Black Cross Training Sneakers. Innovation meets style, responsive cushioning, superior traction for intense workouts.", "10", 95.00, 25,  "images/product-2.jpg");
			productRepo.save(p);
			p = new Product(7, "Black Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with precision Black Cross Training Sneakers. Innovation meets style, responsive cushioning, superior traction for intense workouts.", "11", 95.00, 25,  "images/product-2.jpg");
			productRepo.save(p);
			p = new Product(8, "Black Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with precision Black Cross Training Sneakers. Innovation meets style, responsive cushioning, superior traction for intense workouts.", "12", 95.00, 25,  "images/product-2.jpg");
			productRepo.save(p);
			p = new Product(9, "Black Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with precision Black Cross Training Sneakers. Innovation meets style, responsive cushioning, superior traction for intense workouts.", "13", 95.00, 25,  "images/product-2.jpg");
			productRepo.save(p);
			p = new Product(10, "Gray Athletic Pants", "Clothing", "Pants","Comfort and style in Gray Athletic Pants. Crafted for an active wardrobe with cozy fabric. Gym or casual day, ergonomic design for adaptable style.", "M", 65.00, 25, "images/product-3.jpg");
			productRepo.save(p);
			p = new Product(11, "Gray Athletic Pants", "Clothing", "Pants","Comfort and style in Gray Athletic Pants. Crafted for an active wardrobe with cozy fabric. Gym or casual day, ergonomic design for adaptable style.", "L", 65.00, 25, "images/product-3.jpg");
			productRepo.save(p);
			p = new Product(12, "Gray Athletic Pants", "Clothing", "Pants","Comfort and style in Gray Athletic Pants. Crafted for an active wardrobe with cozy fabric. Gym or casual day, ergonomic design for adaptable style.", "XL", 65.00, 25, "images/product-3.jpg");
			productRepo.save(p);
			p = new Product(13, "Gray Athletic Pants", "Clothing", "Pants","Comfort and style in Gray Athletic Pants. Crafted for an active wardrobe with cozy fabric. Gym or casual day, ergonomic design for adaptable style.", "2XL", 65.00, 25, "images/product-3.jpg");
			productRepo.save(p);
			p = new Product(14, "Navy Blue Polo Shirt","Clothing", "Polo Shirt", "Casual elegance blending style and breathability. Make a timeless statement in charm and comfort.", "M", 50.00, 25,  "images/product-4.jpg");
			productRepo.save(p);
			p = new Product(15, "Navy Blue Polo Shirt","Clothing", "Polo Shirt", "Casual elegance blending style and breathability. Make a timeless statement in charm and comfort.", "L", 50.00, 25,  "images/product-4.jpg");
			productRepo.save(p);
			p = new Product(16, "Navy Blue Polo Shirt","Clothing", "Polo Shirt", "Casual elegance blending style and breathability. Make a timeless statement in charm and comfort.", "XL", 50.00, 25,  "images/product-4.jpg");
			productRepo.save(p);
			p = new Product(17, "Navy Blue Polo Shirt","Clothing", "Polo Shirt", "Casual elegance blending style and breathability. Make a timeless statement in charm and comfort.", "2XL", 50.00, 25,  "images/product-4.jpg");
			productRepo.save(p);
			p = new Product(18, "Gray High Top Sneakers", "Shoes", "Sneakers","Urban style Gray High Top Sneakers with  a sleek gray, high-top silhouette that bridges casual and chic. Comfortable and durable for everyday wear.", "10", 125.00, 25,  "images/product-5.jpg");
			productRepo.save(p);
			p = new Product(19, "Gray High Top Sneakers", "Shoes", "Sneakers","Urban style Gray High Top Sneakers with  a sleek gray, high-top silhouette that bridges casual and chic. Comfortable and durable for everyday wear.", "11", 125.00, 25,  "images/product-5.jpg");
			productRepo.save(p);
			p = new Product(20, "Gray High Top Sneakers", "Shoes", "Sneakers","Urban style Gray High Top Sneakers with  a sleek gray, high-top silhouette that bridges casual and chic. Comfortable and durable for everyday wear.", "12", 125.00, 25,  "images/product-5.jpg");
			productRepo.save(p);
			p = new Product(21, "Gray High Top Sneakers", "Shoes", "Sneakers","Urban style Gray High Top Sneakers with  a sleek gray, high-top silhouette that bridges casual and chic. Comfortable and durable for everyday wear.", "13", 125.00, 25,  "images/product-5.jpg");
			productRepo.save(p);
			p = new Product(22, "Black Printed T-Shirt", "Clothing", "T-Shirt", "Explore casual cool with our Black Printed T-Shirt. Merging classic and contemporary for soft touch, making a bold statement.", "M", 30.00, 25,  "images/product-6.jpg");
			productRepo.save(p);
			p = new Product(23, "Black Printed T-Shirt", "Clothing", "T-Shirt", "Explore casual cool with our Black Printed T-Shirt. Merging classic and contemporary for soft touch, making a bold statement.", "L", 30.00, 25,  "images/product-6.jpg");
			productRepo.save(p);
			p = new Product(24, "Black Printed T-Shirt", "Clothing", "T-Shirt", "Explore casual cool with our Black Printed T-Shirt. Merging classic and contemporary for soft touch, making a bold statement.", "XL", 30.00, 25,  "images/product-6.jpg");
			productRepo.save(p);
			p = new Product(25, "Black Printed T-Shirt", "Clothing", "T-Shirt", "Explore casual cool with our Black Printed T-Shirt. Merging classic and contemporary for soft touch, making a bold statement.", "2XL", 30.00, 25,  "images/product-6.jpg");
			productRepo.save(p);
			p = new Product(26, "Athletic Ankle Socks", "Clothing", "Socks", "Elevate comfort with 3-Pack Athletic Ankle Socks. Cushioned soles, moisture-wicking for superior comfort. Embrace functionality and comfort.", "8-12", 15.00, 25, "images/product-7.jpg");
			productRepo.save(p);
			p = new Product(26, "Athletic Ankle Socks", "Clothing", "Socks", "Elevate comfort with 3-Pack Athletic Ankle Socks. Cushioned soles, moisture-wicking for superior comfort. Embrace functionality and comfort.", "12+", 15.00, 25, "images/product-7.jpg");
			productRepo.save(p);
			p = new Product(27, "Sleek Black Watch", "Accessories", "Watch", "Embrace timeless sophistication with Sleek Black Watch. Crafted for understated elegance, modern minimalism personified.",null, 375.00, 25 , "images/product-8.jpg");
			productRepo.save(p);
			p = new Product(28, "High Performance Modern Watch", "Accessories", "Watch", "Embrace watch innovation with High-Performance Modern Watch. Fusing tech and sleek design, each detail exudes sophistication and function.", null, 325.00, 25 , "images/product-9.jpg");
			productRepo.save(p);
			p = new Product(29, "Black/Red Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with Black Cross Trainer Sneakers, accented in vibrant red. Merging style and function, redefining athletic footwear. ", "10", 125.00, 25, "images/product-10.jpg");
			productRepo.save(p);
			p = new Product(30, "Black/Red Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with Black Cross Trainer Sneakers, accented in vibrant red. Merging style and function, redefining athletic footwear. ", "11", 125.00, 25, "images/product-10.jpg");
			productRepo.save(p);
			p = new Product(31, "Black/Red Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with Black Cross Trainer Sneakers, accented in vibrant red. Merging style and function, redefining athletic footwear. ", "12", 125.00, 25, "images/product-10.jpg");
			productRepo.save(p);
			p = new Product(32, "Black/Red Cross Trainer Sneakers", "Shoes", "Sneakers", "Elevate training with Black Cross Trainer Sneakers, accented in vibrant red. Merging style and function, redefining athletic footwear. ", "13", 125.00, 25, "images/product-10.jpg");
			productRepo.save(p);
			p = new Product(33, "Gray Slide-On Sneakers", "Shoes", "Sneakers", "Experience comfort and style with Gray Slide-On Sneakers. Seamlessly blending relaxation and sophistication, redefine modern comfort. ", "10", 75.00, 25, "images/product-11.jpg");
			productRepo.save(p);
			p = new Product(34, "Gray Slide-On Sneakers", "Shoes", "Sneakers", "Experience comfort and style with Gray Slide-On Sneakers. Seamlessly blending relaxation and sophistication, redefine modern comfort. ", "11", 75.00, 25, "images/product-11.jpg");
			productRepo.save(p);
			p = new Product(35, "Gray Slide-On Sneakers", "Shoes", "Sneakers", "Experience comfort and style with Gray Slide-On Sneakers. Seamlessly blending relaxation and sophistication, redefine modern comfort. ", "12", 75.00, 25, "images/product-11.jpg");
			productRepo.save(p);
			p = new Product(36, "Gray Slide-On Sneakers", "Shoes", "Sneakers", "Experience comfort and style with Gray Slide-On Sneakers. Seamlessly blending relaxation and sophistication, redefine modern comfort. ", "13", 75.00, 25, "images/product-11.jpg");
			productRepo.save(p);
			p = new Product(37, "Black Athletic Pants", "Clothing", "Pants","Discover peak comfort and style with Black Athletic Jogger Pants redefining casual wear. Elevate leisure with contemporary style.", "M", 50.00, 25, "images/product-12.jpg");
			productRepo.save(p);
			p = new Product(38, "Black Athletic Pants", "Clothing", "Pants","Discover peak comfort and style with Black Athletic Jogger Pants redefining casual wear. Elevate leisure with contemporary style.", "L", 50.00, 25, "images/product-12.jpg");
			productRepo.save(p);
			p = new Product(39, "Black Athletic Pants", "Clothing", "Pants","Discover peak comfort and style with Black Athletic Jogger Pants redefining casual wear. Elevate leisure with contemporary style.", "XL", 50.00, 25, "images/product-12.jpg");
			productRepo.save(p);
			p = new Product(40, "Black Athletic Pants", "Clothing", "Pants","Discover peak comfort and style with Black Athletic Jogger Pants redefining casual wear. Elevate leisure with contemporary style.", "2XL", 50.00, 25, "images/product-12.jpg");
			productRepo.save(p);

		};
	}

}
