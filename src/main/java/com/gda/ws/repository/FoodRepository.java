package com.gda.ws.repository;

import com.gda.ws.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Collection<Food> findFoodByCategoryId(Long id);

}
