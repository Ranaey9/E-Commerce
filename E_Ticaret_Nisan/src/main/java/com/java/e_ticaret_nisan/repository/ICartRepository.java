package com.java.e_ticaret_nisan.repository;

import com.java.e_ticaret_nisan.entitiy.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {
    ThreadLocal<Object> findByUser_Id(Long userİd);

    Cart findByUserId(Long userid);
}
