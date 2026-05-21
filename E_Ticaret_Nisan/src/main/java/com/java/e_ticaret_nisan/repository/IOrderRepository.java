package com.java.e_ticaret_nisan.repository;

import com.java.e_ticaret_nisan.entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
}
