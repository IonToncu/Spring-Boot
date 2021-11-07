package com.example.springbootproject.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private int age;
    @ManyToMany
    private Set<Product> products;

    public Product addProduct(Product product){
        if(products.isEmpty())
            products = new HashSet<>();

        products.add(product);
        return product;
    }
}
