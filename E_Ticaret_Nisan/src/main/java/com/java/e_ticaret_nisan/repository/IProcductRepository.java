package com.java.e_ticaret_nisan.repository;

import com.java.e_ticaret_nisan.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcductRepository extends JpaRepository<Product,Long> {

}
