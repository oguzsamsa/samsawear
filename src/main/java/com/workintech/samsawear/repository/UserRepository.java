package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //TODO -> find user by mail, find user by name

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(String email);
}
