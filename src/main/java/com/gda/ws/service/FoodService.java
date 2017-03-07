package com.gda.ws.service;

import java.util.Collection;

import com.gda.ws.dto.FoodDto;
import com.gda.ws.entity.Food;
import com.gda.ws.dto.FoodCategoryDto;

public interface FoodService {

    Collection<FoodCategoryDto> foodCategories();

    Collection<FoodDto> findAllfood();

    Collection<FoodDto> findFoodByCategory(Long id);
}
