package com.gda.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gda.ws.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
