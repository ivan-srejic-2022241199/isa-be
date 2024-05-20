package com.example.isabe.mappers;

import com.example.isabe.entities.User;
import com.example.isabe.entities.UserProducts;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import com.example.isabe.models.UserProductsModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class UserProductsMapper
{
    public static UserProductsModel toModel(UserProducts entity)
    {
        return UserProductsModel.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .products(ProductMapper.toModelList(entity.getProducts()))
                .build();
    }

    public static List<UserProductsModel> toModelList(List<UserProducts> entities)
    {
        var list = new ArrayList<UserProductsModel>();
        for (var entity : entities)
        {
            list.add(toModel(entity));
        }
        return list;
    }
}
