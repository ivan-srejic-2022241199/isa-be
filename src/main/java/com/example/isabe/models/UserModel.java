package com.example.isabe.models;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserModel
{
    private int id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
}
