package com.rachelcampbell.RedStoreSA.Controller;

import com.rachelcampbell.RedStoreSA.Model.Product;
import com.rachelcampbell.RedStoreSA.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //get a list of all products
    @GetMapping("all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // get a product by id
    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

}
