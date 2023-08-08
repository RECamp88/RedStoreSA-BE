package com.rachelcampbell.RedStoreSA.Service;

import com.rachelcampbell.RedStoreSA.Model.Product;
import com.rachelcampbell.RedStoreSA.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /* Product Story 1: Get all Products
    * @param: no parameters
    * @return: return a list of products
    * */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    /* Product Story 2: Get a product by its id
    * @param: id
    * @return: return a product object
    * */
    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }
}
