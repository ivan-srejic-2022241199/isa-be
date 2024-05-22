package com.example.isabe.controllers;

import com.example.isabe.entities.User;
import com.example.isabe.models.UserModel;
import com.example.isabe.models.UserPageModel;
import com.example.isabe.models.UserProductsModel;
import com.example.isabe.services.IUserService;
import com.example.isabe.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController
{
    private final IUserService userService;

    @GetMapping("get-list")
    public List<UserModel> getList()
    {
        return userService.findAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize)
    {
        return userService.findPagedList(PageRequest.of(pageNumber,pageSize));
    }

    @GetMapping("get-by-email")
    public User getUserByEmail(String email)
    {
        return userService.findByEmail(email);
    }

    @PostMapping("create-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result)
    {
        if(result.hasErrors())
        {
            return ResponseEntity.badRequest().body(result);
        }

        return new ResponseEntity<UserModel>(userService.create(userModel), HttpStatus.CREATED);
    }

    @GetMapping("get-users-products-list")
    public List<UserProductsModel> getUserProductList()
    {
        return userService.getUserProductsList();
    }
}
