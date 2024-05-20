package com.example.isabe.controllers;

import com.example.isabe.entities.Product;
import com.example.isabe.repositories.IProductRepository;
import com.example.isabe.repositories.IUserProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController
{
    private final IProductRepository productRepository;
    private final IUserProductsRepository userProductsRepository;

    @GetMapping("get-list")
    public List<Product> getList()
    {
        return productRepository.findAll();
    }

}
