package com.gda.ws.service;

import com.gda.ws.dto.FoodCategoryDto;
import com.gda.ws.dto.FoodDto;

import java.util.Collection;

public interface FoodService {

    FoodDto findOne(Long id);

    Collection<FoodCategoryDto> foodCategories();

    Collection<FoodDto> findAllfood();

    Collection<FoodDto> findFoodByCategory(Long id);
}
