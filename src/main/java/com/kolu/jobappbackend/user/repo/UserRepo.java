package com.kolu.jobappbackend.user.repo;

import com.kolu.jobappbackend.user.userdetails.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
