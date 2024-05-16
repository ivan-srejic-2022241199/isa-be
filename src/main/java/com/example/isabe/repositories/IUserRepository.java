package com.example.isabe.repositories;

import com.example.isabe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer>
{
//    Ovo ce automatski da zna da pretrazi preko email prop-a. Naming convention je takav da ako stavimo npr
//    findByBrojTelefona, on ce da zna da pretrazi preko brojTelefona prop-a
    User findByEmail(String email);

//    Mozemo sami da definisemo sql query sa parametrom na ovaj nacin
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE first_name LIKE (%:firstName%)")
    List<User> findAllByFirstName(@Param("firstName") String firstName);
}
