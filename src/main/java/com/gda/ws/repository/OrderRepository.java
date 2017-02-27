package com.gda.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gda.ws.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
