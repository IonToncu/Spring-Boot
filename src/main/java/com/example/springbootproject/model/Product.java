package com.example.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
@Setter
@Getter
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private String name;
    @ManyToMany
    private Set<User> owners;

    public User addOwner(User owner){
        if(owners.isEmpty())
            owners = new HashSet<>();

        owners.add(owner);
        return owner;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
