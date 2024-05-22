package com.example.isabe.repositories;

import com.example.isabe.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer>
{

}
