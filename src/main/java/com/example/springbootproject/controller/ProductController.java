package com.example.springbootproject.controller;

import com.example.springbootproject.model.Product;
import com.example.springbootproject.repo.ProductRepository;
import com.example.springbootproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    List<Product> allProducts(){
        return productService.findAll();
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product product){
        System.out.println("test");
        return productService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updateProduct(product, id);
    }
    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
