package com.yogesh.studentsystem.repository;

import com.yogesh.studentsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
//    User findByEmail(String email);
}
