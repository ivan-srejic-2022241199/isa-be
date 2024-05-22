package com.example.isabe.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="products")
@Data
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "name")
    private String name;

    @Column(name="user_id")
    private Integer userId;

    @ManyToMany
    @JoinTable(name="products_categories",joinColumns = @JoinColumn(name="product_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="category_id",referencedColumnName = "id"))
    @JsonManagedReference

    private List<Category> categories;

}
