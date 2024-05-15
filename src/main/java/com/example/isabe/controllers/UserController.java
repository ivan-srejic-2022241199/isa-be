package com.example.isabe.controllers;

import com.example.isabe.entities.User;
import com.example.isabe.mappers.UserMapper;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import com.example.isabe.repositories.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController
{
    private final IUserRepository userRepository;
//    Dependency injection - anotacija @RequiredArgsConstructor ce ovo da uradi umesto nas, ali prop mora da ima
//    klucnu rec "final"
//    public UserController(IUserRepository userRepository)
//    {
//        this.userRepository = userRepository;
//    }

    @CrossOrigin("*")
    @GetMapping("name")
    public String getFirstName()
    {
        return "Ivan";
    }

    @CrossOrigin("*")
    @GetMapping("get-user-list")
    public List<UserModel> getUserList()
    {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("get-user-page-list")
    public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize)
    {
        return UserMapper.toModelPageList(userRepository.findAll(PageRequest.of(pageNumber,pageSize)));
    }

    @GetMapping("get-by-email")
    public User getUserByEmail()
    {
        return userRepository.findByEmail("ivan.srejic.22@singimail.rs");
    }

    @PostMapping("create-user")
    public String createUser(String firstName, String lastName)
    {
        return firstName + lastName;
    }

    @PostMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result)
    {
        if(result.hasErrors())
        {
            return ResponseEntity.badRequest().body(result);
        }
        var entity = UserMapper.toEntity(userModel);

        userRepository.save(entity);

        return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
    }
}
