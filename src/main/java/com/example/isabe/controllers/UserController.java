package com.example.isabe.controllers;

import com.example.isabe.models.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController
{

    @GetMapping("ime")
    public String getFirstName()
    {
        return "Ivan";
    }

    @GetMapping("ime-list")
    public List<String> getFirstNameList()
    {
        return List.of("Ivan", "Ivan", "Ivan", "Ivan");
    }

    @PostMapping("create-user")
    public String createUser(String firstName, String lastName)
    {
        return firstName + lastName;
    }

    @PostMapping("create-user-body")
    public UserModel createUserBody(@RequestBody UserModel userModel)
    {
        return userModel;
    }
}
