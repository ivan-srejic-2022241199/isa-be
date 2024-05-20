package com.example.isabe.mappers;

import com.example.isabe.entities.Product;
import com.example.isabe.entities.User;
import com.example.isabe.models.ProductModel;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper
{
    public static ProductModel toModel(Product entity)
    {
        return ProductModel.builder().name(entity.getName()).build();
    }
    public static List<ProductModel> toModelList(List<Product> entities)
    {
        List<ProductModel> models = new ArrayList<>();
        for (var entity : entities)
        {
            models.add(toModel(entity));
        }
        return models;
    }
}