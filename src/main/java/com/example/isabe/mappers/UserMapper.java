package com.example.isabe.mappers;

import com.example.isabe.entities.User;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    public static UserModel toModel(User entity)
    {
//        UserModel userModel = new UserModel();
//        userModel.setId(entity.getId());
        return UserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }

    public static List<UserModel> toModelList(List<User> entities)
    {
        var list = new ArrayList<UserModel>();
        for (var entity : entities)
        {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toModelPageList(Page<User> pageEntity)
    {
        return UserPageModel.builder()
                .users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }

    public static User toEntity(UserModel model)
    {
        User user = new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());

        return user;
    }
}
