package com.example.isabe.services;

import com.example.isabe.entities.User;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import com.example.isabe.models.UserProductsModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService
{
    List<UserModel> findAll();
    UserPageModel findPagedList(PageRequest pageRequest);
    User findByEmail(String email);
    UserModel create(UserModel userModel);
    List<UserProductsModel> getUserProductsList();

}
