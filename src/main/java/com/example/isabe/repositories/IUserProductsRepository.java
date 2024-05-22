package com.example.isabe.repositories;

import com.example.isabe.entities.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProductsRepository extends JpaRepository<UserProducts,Integer>
{
}
