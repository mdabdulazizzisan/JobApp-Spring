package com.kolu.jobappbackend.user.repo;

import com.kolu.jobappbackend.user.userdetails.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
