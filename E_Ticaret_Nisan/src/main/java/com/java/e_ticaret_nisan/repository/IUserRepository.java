package com.java.e_ticaret_nisan.repository;

import com.java.e_ticaret_nisan.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);
}
