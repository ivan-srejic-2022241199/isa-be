package com.example.isabe.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="users")
@Data
public class UserProducts
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email") //Ako su identicni nazivi, moze da se izostavi ova anotacija
    private String email;

    @OneToMany (mappedBy = "userId")
    private List<Product> products;
}
