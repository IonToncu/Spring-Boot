package com.example.springbootproject.service;

import com.example.springbootproject.model.Product;
import com.example.springbootproject.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        return productRepository.findProductById(id);
    }

    public Product updateProduct(Product product, Long id){
        Product oldProduct = findById(id);
        if(product.getPrice() > 0)
            oldProduct.setPrice(product.getPrice());
        if(product.getName().length() > 0 && product.getName() != null)
            oldProduct.setName(product.getName());
        return productRepository.save(oldProduct);
    }

    public void deleteProduct(Long id){
        if(productRepository.findProductById(id) != null){
            productRepository.deleteById(id);
        }
    }
}
