package com.sparta.springminiproject.order.repository;

import com.sparta.springminiproject.order.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = "product")
    List<Order> findAll();


    /*
    @Query("""
           select o
           from Order o
           join fetch o.product
""")
    List<Order> findAllWithProduct();

     */
}