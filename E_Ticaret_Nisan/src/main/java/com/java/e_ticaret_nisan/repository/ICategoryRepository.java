package com.java.e_ticaret_nisan.repository;

import com.java.e_ticaret_nisan.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {

    boolean existsByName(String name);
}
