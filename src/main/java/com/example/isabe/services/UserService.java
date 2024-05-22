package com.example.isabe.services;

import com.example.isabe.entities.User;
import com.example.isabe.mappers.UserMapper;
import com.example.isabe.mappers.UserProductsMapper;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import com.example.isabe.models.UserProductsModel;
import com.example.isabe.repositories.IUserProductsRepository;
import com.example.isabe.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService
{
    private final IUserRepository userRepository;
    private final IUserProductsRepository userProductsRepository;

    @Override
    public List<UserModel> findAll()
    {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest)
    {
        return UserMapper.toModelPageList(userRepository.findAll(pageRequest));
    }

    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserModel create(UserModel userModel)
    {
        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(userModel)));
    }

    @Override
    public List<UserProductsModel> getUserProductsList()
    {
        return UserProductsMapper.toModelList(userProductsRepository.findAll());
    }
}
