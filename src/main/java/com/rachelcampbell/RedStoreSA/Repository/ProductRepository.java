package com.rachelcampbell.RedStoreSA.Repository;

import com.rachelcampbell.RedStoreSA.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
