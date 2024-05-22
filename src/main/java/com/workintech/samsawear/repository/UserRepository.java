package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //TODO -> find user by mail, find user by name
}
