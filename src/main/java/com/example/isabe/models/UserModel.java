package com.example.isabe.models;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel
{
    private int id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
}
