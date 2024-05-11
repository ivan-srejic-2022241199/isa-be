package com.example.isabe.controllers;

import com.example.isabe.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result)
    {
        if(result.hasErrors())
        {
            return ResponseEntity.badRequest().body(result);
        }
        return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
    }
}
